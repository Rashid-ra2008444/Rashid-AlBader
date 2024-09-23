fun main(args: Array<String>) {
    val num = 1..100
    for (n in num) {
        if (n % 2 == 0) {
            print("$n\t")
            if (n % 10 == 0) {
                println("")
            }
        }
    }

    println(getLetterGrade(86))

    // Initialize a list of friends
    val friends = listOf(
        Friend("Abdulahi", "Hassen", "M"),
        Friend("Fatima", "Hamza", "F"),
        Friend("Fiona", "Shrek", "F"),
        Friend("Abbas", "Ibn Fernas")
    )

    // Display the list of friends
    println("List of Friends:")
    for (friend in friends) {
        println(friend)
    }

    val cities = mutableListOf("Doha","Tokyo","Delhi")
    cities.add("Dhaka")
    cities.add("Beijing")

}

fun List<String>.display() {
    for (city in this) {
        println(city)
    }
}

fun getLetterGrade(number: Int): String {
    val letter: String = when (number) {
        in 90..100 -> "A"
        in 85..89  -> "B+"
        in 80..84  -> "B"
        in 75..79  -> "C+"
        in 70..74  -> "C"
        in 65..69  -> "D+"
        in 60..64  -> "D"
        in 0..59   -> "F"
        else       -> "Invalid number"
    }
    return letter
}

class Friend (val firstName :String,
            val lastName :String,
            val gender :String = "M"){
    override fun toString() :String {
        val title = if(gender =="M") "Mr." else "Ms."

        return "$title $firstName $lastName"
    }



}