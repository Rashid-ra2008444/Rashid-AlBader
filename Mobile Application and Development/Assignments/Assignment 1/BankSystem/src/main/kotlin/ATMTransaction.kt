

class ATMTransaction (
    val transactionId: String,
    val date: String,
    val type :String,
    val amount: Double,
    val postBalance: Double,
) {

    fun modifies(){
        println("Transaction modified")
    }

}