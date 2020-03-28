//interface PersonInfoProvider                  // Empty Interface. Available with no methods to implement.

interface PersonInfoProvider {
    val providerInfo: String

    //fun printInfo(person: Person)             // Just notice function name and parameters (no keyword "virtual" or "abstract" required)
    fun printInfo(person: Person) {
        // Interface on Kotlin can define default implementation
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

// If a class is abstract, not all functions need to be implemented
// However, the class can't be instantiated either
//abstract class BasicInfoProvider : PersonInfoProvider
class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic Info Provider Override"

    // Implementation of interface functions need keyword "override"
    /*
    override fun printInfo(person: Person) {
        println("Basic info provider's printInfo")
        person.printInfo()
    }
    */

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Another Print Statement")
    }

    override fun getSessionId(): String {
        return "Session ID"
    }
}

fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    //if(infoProvider is SessionInfoProvider) {
    if(infoProvider !is SessionInfoProvider) {
        //println("is a session info provider")
        println("is NOT a session info provider")
    } else {
        //println("is NOT a session info provider")
        println("is a session info provider")
        //(infoProvider as SessionInfoProvider).getSessionId()
        infoProvider.getSessionId()
    }
}