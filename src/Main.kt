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
}