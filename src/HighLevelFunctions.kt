fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if(predicate(it)) {
            println(it)
        }
    }
}

fun main() {
    val list = listOf("kotlin", "java", "c++", "javascript")

    //printFilteredStrings(list, { it.startsWith("j") })
    printFilteredStrings(list) {
        it.startsWith("j")
    }
}