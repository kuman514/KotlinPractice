var n: String = "Top Level Variable"
var nullableString: String? = null      // Nullable String

var typeInferenceStr = "Yasuo"          // type inference
var nullAssign = null                   // nothing type

fun main() {
    println("Hello Kotlin")

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
}