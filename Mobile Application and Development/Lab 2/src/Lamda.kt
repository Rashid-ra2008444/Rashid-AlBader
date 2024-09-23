import java.util.*


fun main(){

    println(add(12,13))

    println(square(4))

    calculate(12,13,add)
    calculate(12,13,sub)
    calculate(12,13,mul)
    calculate(12,13,div)

    val numbers = listOf(1,2,3,4,5,9,11,55,22)
    numbers.forEach(::println)
    // another way
    numbers.forEach {println(it)}
    //also another way
    numbers.forEach {a -> println(a)}

    val names = listOf<String>("Ali")
    names.countVowels()

    val name = "Abdulrahman"
    name.countVowel()

    numbers.mSum()
}



val add = {a:Int , b:Int -> a+b}
val sub = {a:Int , b:Int -> a-b}
val div = {a:Int , b:Int ->a/b}
val mul = {a:Int , b:Int ->a*b}
val square ={ a:Int -> a*a}


fun calculate (num1: Int ,num2:Int ,acton:(Int,Int)-> Int){
    println(acton(num1,num2))

}

fun List<String>.countVowels(){
    println(this)
}

fun String.countVowel(){
    val vowels = listOf('a','e','o','u','i')
    var counter =0
    for(x in this.lowercase(Locale.getDefault())){
        if(x in vowels){
            counter++
        }
    }
    println("The number of vowels letter in this name is $counter")
}

fun List<Int>.mSum() : Int{
    var sumof =0
    for(x in this){
        sumof+=x
    }
    return sumof
}