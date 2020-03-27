var n: String = "Top Level Variable"
var nullableString: String? = null      // Nullable String

var typeInferenceStr = "Yasuo"          // type inference
var nullAssign = null                   // nothing type

// Basic Functions on Kotlin ============
fun getGreeting(): String {
    return "Hello Kotlin!"
}
/*
fun getGreeting(): String? {
    return null
}
 */
fun getAnotherGreeting(): String = "Hello Kotlin!?"

// must specify "name: Type" on parameters
fun getAnotherGreeting2(str: String): String = "Hello, $str"
fun sayHello2(itemToGet: String) {
    //val msg = "Hello, " + itemToGet + "." // "Hello, $itemToGet."
    val msg = "Hello, $itemToGet."
    println(msg)
}
fun sayHello3(greeting: String, item: String) = println("$greeting $item.")

fun sayHello() : Unit {
    println(getGreeting())
}

fun sayHello4(greeting: String, itemsToGet: List<String>) {
    itemsToGet.forEach { itemToGet ->
        println("$greeting, $itemToGet!")
    }
}

fun sayHello5(greeting: String, vararg itemsToGet: String) {
    // Check out "vararg"
    // treated as an array
    itemsToGet.forEach { itemToGet ->
        println("$greeting, $itemToGet!")
    }
}

fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting, $name!")
// ======================================

fun main() {
    // Print Hello Kotlin ===================
    println("Hello Kotlin")
    // ======================================

    // Variables on Kotlin ==================
    var id: String = "513"       // var: variable that can reassign
    val name: String = "kuman"   // val: read only variable

    id = "514"
    println(name)
    println(id)
    println(name+id)

    //var n: String = "Local Variable"
    n = "Hello kuman514"
    println(n)

    //typeInferenceStr = null
    println(typeInferenceStr)

    nullableString = "LLL"
    if(nullableString != null) {
        println(nullableString)
    }

    // using "when" keyword
    //nullableString = null
    when(nullableString) {
        null -> println("nothing...")
        else -> println(nullableString)
    }

    // variable branch expressions
    var greeting: String? = null
    greeting = "Greetings."
    //val greetingToPrint = if(greeting != null) greeting else "HI!"
    val greetingToPrint = when (greeting) {
        null -> "HI!"
        else -> greeting
    }
    println(greetingToPrint)
    // ======================================

    // testing basic functions
    println(getGreeting())
    sayHello()
    println(getAnotherGreeting())
    println(getAnotherGreeting2("greeters."))
    sayHello2("ParameterName")
    sayHello3("our baby","koishi")

    // Collections and Iterations ===========
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))

    for(interestingThing in interestingThings) {
        println(interestingThing)
    }

    interestingThings.forEach {
        println(it)
    }

    interestingThings.forEach { interestingThing ->
        println(interestingThing)
        // lambda syntax within Kotlin
    }

    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    val amusingThings = listOf("Kotlin", "Programming", "Comic Books")      // unmutable (can't add)
    amusingThings.forEach { amusingThing ->
        println("$amusingThing is Fun!")
    }

    val anotherAmusement = mutableListOf("Dogs", "Yasuo", "Koishi")         // mutable (can add)
    anotherAmusement.add("kuman")

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")                           // unmutable (can't put)
    map.forEach { (key, value) ->
        println("$key to $value")
    }

    val anotherMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")             // mutable (can put)
    anotherMap.put(4, "d")

    sayHello4("Hello", amusingThings)
    sayHello4("Hello", anotherAmusement)
    sayHello5("Hello")                                              // Doesn't have to pass varargs
    sayHello5("Hey", "koishi", "kotlin", "kuman")       // But also can pass multiple arguments
    sayHello5("Hi", *interestingThings)                             // Array to varargs

    greetPerson(name = "kuman", greeting = "kekeke")                        // changing order of the parameters
    greetPerson()                                                           // can be empty if default argument is defined
    sayHello5("Hi", *interestingThings)
    //sayHello5(greeting = "Hi", *interestingThings)
    sayHello5(greeting = "Hi", itemsToGet = *interestingThings)
    // ======================================
}