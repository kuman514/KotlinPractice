//interface PersonInfoProvider                  // Empty Interface. Available with no methods to implement.

interface PersonInfoProvider {
    //fun printInfo(person: Person)             // Just notice function name and parameters (no keyword "virtual" or "abstract" required)
    fun printInfo(person: Person) {
        // Interface on Kotlin can define default implementation
        println("Basic info provider's printInfo")
        person.printInfo()
    }
}

// If a class is abstract, not all functions need to be implemented
// However, the class can't be instantiated either
//abstract class BasicInfoProvider : PersonInfoProvider
class BasicInfoProvider : PersonInfoProvider {
    // Implementation of interface functions need keyword "override"
    /*
    override fun printInfo(person: Person) {
        println("Basic info provider's printInfo")
        person.printInfo()
    }
    */
}

fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
}