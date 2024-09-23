fun main() {
    // account 1 created
    var account1 = Account("01010202", 1000.0)
    println("account created with account id ${account1.number} and balance ${account1.balance}\n")
    account1.withdraw(300.0)
    println("now the account balance withdrawn by 300.0")
    println("\tthe current balance in the account is ${account1.balance}\n")
    println("Now we will deposit 600.0 to the account")
    account1.deposit(600.0)
    println("\tthe current balance in the account is ${account1.balance}\n")
    println("now we will test the withdraw if we can withdraw more than the account balance")
    account1.withdraw(2000.0)

}