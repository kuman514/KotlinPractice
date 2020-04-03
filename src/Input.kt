import java.lang.Exception
import java.util.*

fun main() {
    // how to get raw input
    val str: String = readLine().toString()
    println(str)

    // how to get int input
    val scan = Scanner(System.`in`)
    try {
        val a: Int = scan.nextInt()
        val b: Int = scan.nextInt()
        println("${a+b}")
    } catch (e: InputMismatchException) {
        println(e.toString())
    }

    // how to get float input
    val c: Float = scan.nextFloat()
    val d: Float = scan.nextFloat()
    println("${c-d}")
}
