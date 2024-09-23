class Customer(
    val name: String,
    val address: String,
    val dob: String,
    val cardNumber:Int,
    val pin :Int,
    val bank:Bank
    ) {
    private val accounts: MutableList<Account> = mutableListOf()
    fun verfiyPassword()=  println("Password Verified")

    fun addAccount(account:Account) {

        if(accounts.size <2) {
            accounts.add(account)
            account.customer = this
        }
        else throw Exception("Customer can only have max of 2 accounts")
    }
    fun removeAccount(account:Account) {
        if(accounts.contains(account)) {
            accounts.remove(account)
            account.customer = null
        }
    }
}