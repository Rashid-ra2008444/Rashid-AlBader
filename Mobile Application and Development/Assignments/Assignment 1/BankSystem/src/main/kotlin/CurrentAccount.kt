class CurrentAccount(
    val accountNo: Int,
    var balance: Double
    ) {

    fun withdraw(amount: Double) {

        if(amount >0 && amount <= balance) {
            balance -= amount
        }
        else println("Insufficient balance")

    }


}