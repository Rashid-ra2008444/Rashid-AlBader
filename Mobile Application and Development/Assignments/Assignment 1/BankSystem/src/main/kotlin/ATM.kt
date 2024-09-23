class ATM (
    val location : String,
    val managedBy : Bank

) {
    fun identifies()  = println("ATM Identified")

    fun transactions() = println("ATM is processing transactions.")



}