package MainApp;

import Clients.*;
import Payments.*;
import Shipments.*;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestApp implements Serializable {
    static ArrayList<Client> clients = new ArrayList<Client>();
    static ArrayList<Shipment> shipments = new ArrayList<Shipment>();
    static ArrayList<Destination> destinations = new ArrayList<Destination>();
    static ArrayList<ShippingStatus> shipmentsStatus = new ArrayList<ShippingStatus>();

    @SuppressWarnings("unchecked")
	private static void readAllDat() throws FileNotFoundException {
        File file = new File("Data.dat");
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            clients = (ArrayList<Client>) ois.readObject();
            shipments = (ArrayList<Shipment>) ois.readObject();
            destinations = (ArrayList<Destination>) ois.readObject();
            shipmentsStatus = (ArrayList<ShippingStatus>) ois.readObject();
        } catch (IOException  | ClassNotFoundException e) {
            System.err.println("Failed to read data: "+e.getMessage());
            clients = new ArrayList<>();
            shipments = new ArrayList<>();
            destinations = new ArrayList<>();
            shipmentsStatus = new ArrayList<>();
        }
    }

    private static void saveAllDat(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.dat"))){
            oos.writeObject(clients);
            oos.writeObject(shipments);
            oos.writeObject(destinations);
            oos.writeObject(shipmentsStatus);
        } catch (IOException e){
            System.err.println("Failed to save data: "+e.getMessage());
        }
    }
    private static void showInputs(){
        System.out.println("1. Add Client");
        System.out.println("2. Add Destination");
        System.out.println("3. Create new Shipment");
        System.out.println("4. Update an existing Shipment");
        System.out.println("5. Sending and Receiving Shipment");
        System.out.println("6. Report 1");
        System.out.println("7. Report 2");
        System.out.println("8. Report 3");
        System.out.println("9. Report 4");
        System.out.println("10. Report 5");
        System.out.println("11. Report 6");
        System.out.println("12. Report 7");
        System.out.println("13. Exit");
        System.out.println("Enter your choice: ");
    }

    //                      (Done)
    public static Client addClient() {
        Client client = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice( Staff , Student , Company ): ");
        String choice = sc.next();
        while(!choice.equalsIgnoreCase("Staff")&&!choice.equalsIgnoreCase("Student")&&!choice.equalsIgnoreCase("Company")){
            System.out.println("Invalid choice");
            System.out.println("Enter your choice( Staff , Student , Company ): ");
            choice = sc.next();
        }
                if(choice.equalsIgnoreCase("Staff")) {
                    System.out.println("Enter your Name: ");
                    String name = sc.next();
                    System.out.println("Enter your Job ID: ");
                    String jobId = sc.next();
                    client = new Staff(name,jobId);
                }
                else if(choice.equalsIgnoreCase("Student")) {
                    System.out.println("Enter your Name: ");
                    String name = sc.next();
                    System.out.println("Enter your University ID: ");
                    int uniId = sc.nextInt();
                    client = new Student(uniId,name);
                }
                else{
                    System.out.println("Enter your Company name: ");
                    String companyName = sc.next();
                    System.out.println("Enter your Location: ");
                    String location = sc.next();
                    System.out.println("Enter your Po Box: ");
                    int poBox = sc.nextInt();
                    client = new Company(companyName,location,poBox);
                }

        return client;
    }
    //                      (Done)
    public static Destination addDestination() {
        Scanner sc = new Scanner(System.in);
        String destCode = "Des";

        System.out.println("Enter your Destination Name: ");
        String destName = sc.next();

        System.out.println("Enter your Air Cost for 1st Kilo: ");
        double airCost1stKilo = sc.nextDouble();
        while(airCost1stKilo <= 0){
            System.out.println("Should be more than 0");
            System.out.println("Enter your Air Cost for 1st Kilo: ");
            airCost1stKilo = sc.nextDouble();
        }

        System.out.println("Enter your Air Cost for each Add Half: ");
        double airCostEachAddHalf = sc.nextDouble();
        while(airCostEachAddHalf <= 0){
            System.out.println("Should be more than 0");
            System.out.println("Enter your Air Cost for each Add Half: ");
            airCostEachAddHalf = sc.nextDouble();
        }

        System.out.println("Enter your Ground Shipping Discount(percentage value): ");
        double groundShippingDiscount = sc.nextDouble();
        while(groundShippingDiscount <= 0){
            System.out.println("Should be more than 0");
            System.out.println("Enter your Ground Shipping Discount(percentage value): ");
            groundShippingDiscount = sc.nextDouble();
        }
        if(groundShippingDiscount > 1.0) {
            groundShippingDiscount/= 100;
        }
        System.out.println("Enter your Sea Shipping Discount(percentage value): ");
        double seaShippingDiscount = sc.nextDouble();
        while(seaShippingDiscount <= 0){
            System.out.println("Should be more than 0");
            System.out.println("Enter your Sea Shipping Discount(percentage value): ");
            seaShippingDiscount = sc.nextDouble();
        }
        if(seaShippingDiscount > 1.0){
            seaShippingDiscount/= 100;
        }

        return new Destination(destCode,destName,airCost1stKilo,airCostEachAddHalf,groundShippingDiscount,seaShippingDiscount);
    }
    //                      (Done)
    public static Shipment createShipment() {
        //a. Already generated in the class
        Scanner sc = new Scanner(System.in);
        //b. User enter weight
        System.out.println("Enter your Weight: ");
        double weight = calculateWeight(sc.nextDouble());
        // shipper and destination has to be one of the existing clients/destination
        //e
        showAllClientsNamesAndId();
        System.out.println("Enter shipper id");
        int shipperId = sc.nextInt();
        Client shipper = findClient(shipperId);
        if(shipper == null) {
            System.out.println("Invalid shipper id");
            return null;
        }
        //e
        showAllDestinationNameAndId();
        System.out.println("Enter destination id");
        String destinationId = sc.next();
        Destination destination = findDestination(destinationId);
        if(destination == null) {
            System.out.println("Invalid destination id");
            return null;
        }
        // should be automatically for the shipping cost calculation
        //D.c
        double shippingCost = calculateShippingCost(shipper,destination,weight);


        // by default shippingWay set to be Air Freight
        //f
        ShippingWays shippingWay = ShippingWays.AirFreight;

        System.out.println("The default Selected is Air Freight do you want to change it(yes/no)");
        String choice = sc.next().toLowerCase();
        while(!choice.equalsIgnoreCase("yes")&&!choice.equalsIgnoreCase("no")){
            System.out.println("Invalid input.");
            System.out.println("The default Selected is Air Freight do you want to change it(yes/no)");
            choice = sc.next().toLowerCase();
        }
        if(choice.equals("yes")){
            System.out.println("Enter the new Shipping way (AirFreight, GroundShipping, SeaShipping)\n(Write exactly how its written): ");
            String shippingWayStr = sc.next();
            if(shippingWayStr.equalsIgnoreCase("AirFreight")){
                System.out.println("Then why you want to change it then ??\nDon't worry nothing changed");
            }
            else if(shippingWayStr.equalsIgnoreCase("GroundShipping")){
                shippingWay = ShippingWays.GroundShipping;
                shippingCost-= shippingCost*destination.getGroundShippingDiscount();
            }
            else if(shippingWayStr.equalsIgnoreCase("SeaShipping")){
                shippingWay = ShippingWays.SeaFreight;
                shippingCost-= shippingCost*destination.getSeaShippingDiscount();
            }
            else {
                System.out.println("Invalid choice\n You can update the shipping later before paying.");
            }
        }
        //G we can pay for three different ways a. Postponed till later b.Paid in partial c.Paid in total
        double paid = 0.0;
        System.out.println("How do you want to pay for your shipment:\nA. Postponed till later\nB. Pay in partial\nc.Pay in total\n Choose by writing(a,b,c)");
        String howToPay = sc.next().toLowerCase();
        while(!howToPay.equalsIgnoreCase("a")&&!howToPay.equalsIgnoreCase("b")&&!howToPay.equalsIgnoreCase("c")){
            System.out.println("Invalid input.");
            System.out.println("How do you want to pay for your shipment:\nA. Postponed till later\nB. Pay in partial\nc.Pay in total\n Choose by writing(a,b,c)");
            howToPay = sc.next().toLowerCase();
        }
        if(howToPay.equalsIgnoreCase("a")){
            paid = 0.0;
        }
        else if(howToPay.equalsIgnoreCase("b")){
            System.out.println("Current Shipping cost: " + shippingCost);

            System.out.println("Enter the amount you want to pay");
            double amount = sc.nextDouble();
            // new while loop for checking the amount mot be grater than the shipping cost
            while(amount > shippingCost){
                System.out.println("Invalid amount cannot be greater than shipping");
                System.out.println("Enter the amount you want to pay");
                amount = sc.nextDouble();
            }
            amount = getPayment(amount);

            paid = amount;
            System.out.printf("You Paid : %.2f QAR,  Remaining Shipping Cost:  %.2f\n",amount,shippingCost-paid);

        } else if (howToPay.equalsIgnoreCase("c")) {
            paid = shippingCost;
            System.out.println("Thanks you for payment");
        }
        //h
        return new Shipment(weight,shippingCost,shippingWay,shipper,destination, paid);
    }
    private static Client findClient(double id){
        Client client = null;
        for(Client c : clients){
            if(c.getId() == id){
                client = c;
                break;
            }
        }
        return client;
    }
    private static Destination findDestination(String id){
        Destination destination = null;
        for(Destination d : destinations){
            if(d.getDestCode().equalsIgnoreCase(id)){
                destination = d;
                break;
            }
        }
        return destination;
    }
    private static Shipment findShipment(String id){
        Shipment shipment = null;
        for(Shipment s : shipments){
            if(s.getShipmentCode().equalsIgnoreCase(id)){
                shipment = s;
                break;
            }
        }
        return shipment;
    }
    private static double calculateShippingCost(Client client , Destination destination ,double weight){
        double shippingCost = weight * destination.getAirCost1stKilo() * destination.getAirCostEachAddHalf();

        if(client instanceof Staff s){
            shippingCost-= shippingCost*s.getDISCOUNT();
        }
        else if(client instanceof Student s){
            shippingCost-= shippingCost*s.getDISCOUNT();
        }
        else if(client instanceof Company c){
            shippingCost-= shippingCost*c.getDISCOUNT();
        }
        return shippingCost;
    }
    private static double calculateWeight(double number){
        double weight;
        if(number < 1){
            weight = 1.0;
        }
        else {
            weight = roundUpByHalf(number);
        }
        return weight;
    }
    private static double roundUpByHalf(double number){
        double roundedNumber = Math.ceil(number);
        if(roundedNumber - number <= 0.5) {
            roundedNumber+=0.5;
        }
        return roundedNumber;
    }

    private static void showAllClientsNamesAndId(){
        for(Client c : clients){
            System.out.printf("ID: %d,\tName: %s",c.getId(),c.getName());
            System.out.println();
        }
    }

    private static void showAllDestinationNameAndId(){
        for(Destination d : destinations){
            System.out.printf("Destination ID: %s ,\t Destination Name: %s",d.getDestCode(),d.getDestName());
            System.out.println();
        }
    }
    private static void showAllShipmentsId(){
        for(Shipment s : shipments){
            System.out.printf("Shipment ID : %s",s.getShipmentCode());
            System.out.println();
        }
    }

    private static double getPayment(double amount){
        double total= 0;
        Scanner sc = new Scanner(System.in);
        Payment payment;

        System.out.println("How Would you like to pay for your shipment?\nA.CreditCard\nB.WireTransfer\nC.Check payment\nD.Cash Payment\nChoose by writing(a,b,c,d)");
        String paymentType = sc.next().toLowerCase();
        while(!paymentType.equals("a") && !paymentType.equals("b") && !paymentType.equals("c") && !paymentType.equals("d")){
            System.out.println("Invalid input.");
            System.out.println("How Would you like to pay for your shipment?\nA.CreditCard\nB.WireTransfer\nC.Check payment\nD.Cash Payment\nChoose by writing(a,b,c,d)");
            paymentType = sc.next().toLowerCase();
        }
        if (paymentType.equalsIgnoreCase("a")) {
            payment = new CreditCard(amount);
            total = payment.calcPaymentAmount();
        } else if (paymentType.equalsIgnoreCase("b")) {
            payment = new WireTransfer(amount);
            total = payment.calcPaymentAmount();
        } else if (paymentType.equalsIgnoreCase("c")) {
            payment = new Check(amount);
            total = payment.calcPaymentAmount();
        } else {
            payment = new Cash(amount);
            total = payment.calcPaymentAmount();
        }


        return total;
    }


    public static Shipment updateShipment() {
        Scanner sc = new Scanner(System.in);

        showAllShipmentsId();
        System.out.println("Enter your shipment code to update");
        Shipment shipmentToUpdate = findShipment(sc.next());
        //checking
        if(shipmentToUpdate == null){
            System.out.println("Shipment not found");
            return null;
        }

        //Current data
        System.out.println("Current detail of the shipment");
        System.out.println(shipmentToUpdate);

        if(shipmentToUpdate.getTotalPaid() > 0) {
            System.out.println("This shipment has already has paid amount and cannot be modified.");
            if(!shipmentToUpdate.isFullyPaid()) {
                System.out.println("How do you want to pay for your shipment:\nA. Postponed till later\nB. Pay in partial \nc.Pay in total\n Choose by writing(a,b,c)");
                String howToPay = sc.next().toLowerCase();
                while(!howToPay.equalsIgnoreCase("a")&&!howToPay.equalsIgnoreCase("b")&&!howToPay.equalsIgnoreCase("c")){
                    System.out.println("Invalid input.");
                    System.out.println("How do you want to pay for your shipment:\nA. Postponed till later\nB. Pay in partial\nc.Pay in total\n Choose by writing(a,b,c)");
                    howToPay = sc.next().toLowerCase();
                }
                if (howToPay.equalsIgnoreCase("a")) {
                    System.out.println("Hopefully you pay soon.");
                } else if (howToPay.equalsIgnoreCase("b")) {
                    // the latest update here shows now how much the client has paid so the clients know if he can pay the rest of the amount or not
                    System.out.println("Current Shipping cost: " + shipmentToUpdate.getShippingCost());
                    System.out.println("Current Paid cost: " + shipmentToUpdate.getPaid());

                    System.out.println("Enter the amount you want to pay");
                    double amount = sc.nextDouble();
                    // here new while loop shows if the client enters amount more than the shipment cost or the amount he pays and his new payment
                    while(amount > shipmentToUpdate.getShippingCost() && amount + shipmentToUpdate.getPaid() > shipmentToUpdate.getShippingCost()){
                        System.out.println("Invalid amount cannot be greater than shipping");
                        System.out.println("Enter the amount you want to pay");
                        amount = sc.nextDouble();
                    }
                    amount = getPayment(amount);
                    // here is the correct way to calculate the amount of the payment has been paid
                    shipmentToUpdate.setPaid(amount + shipmentToUpdate.getPaid());
                    System.out.printf("You Paid : %.2f QAR,  Remaining Shipping Cost:  %.2f\n", amount, shipmentToUpdate.getShippingCost()-shipmentToUpdate.getPaid());

                } else if (howToPay.equalsIgnoreCase("c")) {
                    shipmentToUpdate.setPaid(shipmentToUpdate.getShippingCost());
                    System.out.println("Thanks you for payment");
                }
                return shipmentToUpdate;
            }
            return shipmentToUpdate;
        }
        else {
            System.out.println("Do you want to change the shipping way ? (yes/no): ");
            String choice = sc.next().toLowerCase();
            while(!choice.equalsIgnoreCase("yes")&&!choice.equalsIgnoreCase("no")){
                System.out.println("Invalid input.");
                System.out.println("Do you want to change the shipping way ? (yes/no): ");
                choice = sc.next().toLowerCase();
            }
            if (choice.equals("yes")) {
                System.out.println("Enter the new Shipping way (AirFreight, GroundShipping, SeaShipping)\n(Write exactly how its written): ");
                String shippingWay = sc.next();
                ShippingWays newShippingWay = ShippingWays.valueOf(shippingWay);

                shipmentToUpdate.setShippingWay(newShippingWay);
            }
        }

        return shipmentToUpdate;
    }

    public static void sendingAndReceivingShipment() {
        Scanner sc = new Scanner(System.in);
        showAllShipmentsId();
        System.out.println("Enter your shipment code");
        Shipment shipment = findShipment(sc.next());

        // check if the shipment has been found
        if(shipment == null) {
            System.out.println("Shipment not found");
            return;
        }
        // here we check if the shipment has been fully paid since you want to put the dates you should fully paid
        if(!shipment.isFullyPaid()){
            System.out.println("Shipment not fully paid");
            return;
        }
        //here I want to check if the sending date and receiving date are null or not
        ShippingStatus shippingStatus = null;
        for(ShippingStatus s : shipmentsStatus){
            if(s.getShipment() == shipment){
                shippingStatus = s;
                break;
            }
        }
        LocalDate sendingDate = shippingStatus.getShippingDate();
        LocalDate receivingDate = shippingStatus.getReceivingDate();

        //here its check if It's null or not if its is, then the user should enter sending date
        if(sendingDate == null) {
            System.out.println("Enter sending date(DD-MM-YYYY): ");
            sendingDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            while (sendingDate.isBefore(shipment.getRegistrationDate())) {
                System.out.println("Invalid sending date");
                System.out.println("Enter sending date(DD-MM-YYYY): ");
                sendingDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        }
        else {
            System.out.println("You already submitted the sending date.");
        }
        // here maybe the client still didn't receive the shipment in this situation I write if statement
        // that if the user want to enter the receiving date or not
        if(receivingDate == null){
            System.out.println("Do you want to enter receiving date? (yes/no): ");
            String choice = sc.next();
            if(choice.equalsIgnoreCase("yes")) {
                System.out.println("Enter receiving  Date(DD-MM-YYYY): ");
                receivingDate = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                while(receivingDate.isBefore(sendingDate)){
                    System.out.println("Invalid receiving date");
                    System.out.println("Enter receiving date(DD-MM-YYYY): ");
                    receivingDate = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                }
            }
        }
        else {
            System.out.println("You already submitted the receiving date.");
        }



        for(ShippingStatus status : shipmentsStatus){
            if(status.getShipment().getShipmentCode().equalsIgnoreCase(shipment.getShipmentCode())){
                status.setShippingDate(sendingDate);
                status.setReceivingDate(receivingDate);
                return;
            }
        }

    }

    // Report 1 must return a List that print all existing clients (Done)
    public static void Report1() {
        int countClients = 0 , countStudent = 0 , countCompany = 0, countStaff = 0;
        for(Client client : clients) {
            countClients++;
            if(client instanceof Student){
                countStudent++;
            }
            else if(client instanceof Company){
                countCompany++;
            }
            else if(client instanceof Staff){
                countStaff++;
            }
        }
        System.out.println(countClients +" Client(s): ");
        for(Client client : clients) {
            System.out.println(client.getId() + "\t\t" + client.getName());
        }
        System.out.println(countStudent+" Student(s): ");
        for(Client client : clients) {
            if(client instanceof Student s) {
                System.out.println(s);
            }
        }
        System.out.println(countCompany+" Company(s): ");
        for(Client client : clients) {
            if(client instanceof Company c) {
                System.out.println(c);
            }
        }
        System.out.println(countStaff+" Staff(s): ");
        for(Client client : clients){
            if(client instanceof Staff s){
                System.out.println(s);
            }
        }
    }

    // Report 2 must list the destination details (Done)
    public static void Report2(String destcode) {
        boolean found = false;
        for(Destination destination : destinations) {
            if(destination.getDestCode().equalsIgnoreCase(destcode)) {
                System.out.println(destination);
                found = true;
                break;
            }
        }
        // This check method checks if the destination found or not
        if(!found) {
            System.out.println("Destination not found");
        }
    }

    // Report 3 must list the shipment details (Done)
    private static void Report3(String shipCode) {
        boolean found = false;
        for(ShippingStatus status : shipmentsStatus) {
            if(status.getShipment().getShipmentCode().equalsIgnoreCase(shipCode)) {
                System.out.println(status);
                found = true;
                break;
            }
        }
        // similar to the previous
        if(!found) {
            System.out.println("Shipment not found");
        }
    }

    // Report 4 must list the queued shipments
    private static void Report4() {
        int counter= 0;
        System.out.println("Queued Shipments: ");
        for(ShippingStatus shipmentStatus : shipmentsStatus) {
            if(shipmentStatus.getShipment().isFullyPaid() &&
                    shipmentStatus.getShippingDate() == null ) {
                counter++;
                System.out.println(shipmentStatus.getShipment().toString());
            }
        }
        if(counter == 0) {
            System.out.println("There is no shipment in the Que list ");
        }
    }

    // Report 5 must-list the client shipments
    private static void Report5(int id) {
        System.out.println("Ship. Code\tReg. Date\tWeight\tCost\tDest. Name\tSending Date\tReceiving Date");
        for(ShippingStatus shipmentStatus : shipmentsStatus){
            if(shipmentStatus.getShipment().getShipper().getId()==id){
                System.out.printf("%s\t%s\t%.2f\t%.2f\t%s\t\t%s\t\t%s",
                        shipmentStatus.getShipment().getShipmentCode(),
                        shipmentStatus.getShipment().getRegistrationDate(),
                        shipmentStatus.getShipment().getWeight(),
                        shipmentStatus.getShipment().getShippingCost(),
                        shipmentStatus.getShipment().getDestination().getDestName(),
                        shipmentStatus.getShippingDate(),
                        shipmentStatus.getReceivingDate());
                System.out.println();
            }
        }
    }

    // Report 6 must list the income
    private static double Report6() {
        double income = 0.0;
        for(Shipment shipment : shipments){
            income += shipment.getTotalPaid();
        }

        return income;
    }

    // Report 7 must list the shipments not yet collected
    private static void Report7() {
        int counter = 0;
        System.out.println("Uncollected Shipments: ");
        for(ShippingStatus shipmentStatus : shipmentsStatus){
            if(shipmentStatus.getShippingDate() != null && shipmentStatus.getReceivingDate() == null ) {
                counter++;
                System.out.printf("Shipment Code: %s\nSender Name: %s\n",
                        shipmentStatus.getShipment().getShipmentCode(),
                        shipmentStatus.getShipment().getShipper().getName());
            }
        }
        if(counter == 0){
            System.out.println("All shipment has been collected.");
        }
    }


    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        readAllDat();
        showInputs();
        int input = sc.nextInt();

        while (input!= 13) {
            if(input == 1) {
                Client client = addClient();
                clients.add(client);
            } else if (input == 2) {
                Destination destination = addDestination();
                destinations.add(destination);
            }
            else if (input == 3) {
                Shipment shipment = createShipment();
                if(shipment == null) {
                    System.out.println("Shipment not created");
                }
                else {
                    shipments.add(shipment);
                    if(shipment.isFullyPaid()) {
                        shipmentsStatus.add(new ShippingStatus(null,null,shipment));
                    }
                }

            }
            else if (input == 4) {
                Shipment shipmentToUpdate = updateShipment();
                if(shipmentToUpdate!= null){
                    for(Shipment s : shipments){
                        if(s.getShipmentCode().equalsIgnoreCase(shipmentToUpdate.getShipmentCode())){
                            s = shipmentToUpdate;
                            if(s.isFullyPaid()){
                                shipmentsStatus.add(new ShippingStatus(null,null,s));
                            }
                            break;
                        }
                    }
                }
            }
            else if (input == 5) {
                sendingAndReceivingShipment();
            }
            else if (input == 6) {
                Report1();
            }
            else if (input == 7) {
                showAllDestinationNameAndId();
                System.out.println("Write the destination code: ");
                String destCode = sc.next();
                Report2(destCode);
            }
            else if (input == 8) {
                showAllShipmentsId();
                System.out.println("Write the shipment code: ");
                String shipCode = sc.next();
                Report3(shipCode);
            }
            else if (input == 9) {
                Report4();
            }
            else if (input == 10) {
                showAllClientsNamesAndId();
                System.out.println("Write the client id: ");
                int id = sc.nextInt();
                Report5(id);
            }
            else if (input == 11) {
                double income = Report6();
                System.out.printf("The company overall income is QAR %.2f\n",income);
            }
            else if (input == 12) {
                Report7();
            }
            else {
                System.out.println("Invalid input");
            }
            Thread.sleep(1000);
            System.out.println("----------------------------------------------------------------");
            showInputs();
            input = sc.nextInt();
        }

        sc.close();
        System.out.println("Data all saved successfully");
        saveAllDat();
    }
}
