var n: String = "Top Level Variable"
val nullableString: String? = null      // Nullable String

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
}