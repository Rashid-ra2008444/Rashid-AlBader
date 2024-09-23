fun main(){

    val numbers= listOf(1,2,3,5,8,9,10)
    val names =  listOf("Ali", "Ahmed","Omar","Rashid","Mohammed")
    println(numbers.sum())
    println(numbers.max())
    println(numbers.min())

    numbers.forEach {x->println ("this is $x")}
    val mapped = numbers.map{ a ->a*a}
    println(mapped)
    // similar to this name -> name.length
    val mappedtoLength = names.map{it.length}
    println(mappedtoLength)

    println(names.filter{ it.length >= 4 })
    println(names.sorted())
    println(names.sortedDescending())

    println(names.find{it =="Rashid"})
    /* similar to
    val acc=0
    for(x in names)
    acc+=x.length               vv      the intial means it start in which place in the list
     */
    println(names.fold(0){acc ,curr -> acc+curr.length})
}