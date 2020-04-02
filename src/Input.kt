import java.util.Scanner

fun main() {
    // how to get raw input
    val str: String = readLine().toString()
    println(str)

    // how to get int input
    val scan = Scanner(System.`in`)
    val a: Int = scan.nextInt()
    val b: Int = scan.nextInt()
    println("${a+b}")
}
