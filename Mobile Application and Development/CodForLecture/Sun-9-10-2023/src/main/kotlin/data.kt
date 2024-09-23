


data class person (val firstName :String ,val lastName : String) {
    var age =0
    override fun toString(): String {
        return "the name of this dumb person is $firstName $lastName"
    }

    }
fun main() {
    val person1 = person("ALi" , "Ahmed")

    println(person1)


}
