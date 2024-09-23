package P2;
//Create and print 100 anonymous Student objects with dept being CSE inside the constructor of the class StudentTester.
public class StudentTester {

    public StudentTester (){
        for(int i = 0; i < 100; i++){
            new Student(Dept.CSE);
        }
    }

    public static void main(String[] args) {
        new StudentTester();
    }
}
