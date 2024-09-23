import java.time.LocalDate

class Account(
    val number :String ,
    var balance: Double,
) { var customer: Customer? = null
    fun deposit(amount: Double) = if( amount >0 ) { balance += amount }
    else println("Invalid amount")
    fun withdraw(amount: Double) = if( amount >0 && amount <= balance ) { balance -= amount }
    else println("Invalid amount")

    fun createTransaction() = println("Transaction created")

}