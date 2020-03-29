/*
fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if(predicate(it)) {
            println(it)
        }
    }
}
*/

fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    println("printFilteredStrings")
    list.forEach {
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.endsWith("n")
}

// this higher order function can work as both inputs and outputs
fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("j") }
}

fun main() {
    val list = listOf("kotlin", "java", "c++", "javascript", "python")

    //printFilteredStrings(list, { it.startsWith("j") })
    printFilteredStrings(list) {
        it.startsWith("j")
    }

    // higher order functions are useful for optional inputs
    printFilteredStrings(list, null)
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate())
}