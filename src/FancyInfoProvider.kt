// Only "open" superclasses can be inherited
// Superclasses that are not "open" cannot be inherited
class FancyInfoProvider : BasicInfoProvider() {
    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy Info Provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }
}