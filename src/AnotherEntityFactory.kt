import java.util.*

// practicing sealed class

enum class AnotherEntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object AnotherEntityFactory {
    fun create(type: AnotherEntityType): AnotherEntity {
        val id = UUID.randomUUID().toString()
        val name = type.getFormattedName()

        return when (type) {
            AnotherEntityType.EASY -> AnotherEntity.Easy(id, name)
            AnotherEntityType.MEDIUM -> AnotherEntity.Medium(id, name)
            AnotherEntityType.HARD -> AnotherEntity.Hard(id, name, 2f)
            AnotherEntityType.HELP -> AnotherEntity.Help
        }
    }
}

// sealed classes cannot be instantiated directly
sealed class AnotherEntity() {
    // Unlike enum classes, sealed class can return different types of properties and methods on each type
    // and the compiler can perform smart casting

    object Help: AnotherEntity() {
        val name = "Help"
    }

    data class Easy(val id: String, val name: String): AnotherEntity()
    data class Medium(val id: String, val name: String): AnotherEntity()
    data class Hard(val id: String, val name: String, val multiplier: Float): AnotherEntity()
}

fun main() {
    val easyEntity = AnotherEntityFactory.create(AnotherEntityType.EASY)
    println(easyEntity)

    val mediumEntity = AnotherEntityFactory.create(AnotherEntityType.MEDIUM)
    println(mediumEntity)

    val hardEntity = AnotherEntityFactory.create(AnotherEntityType.HARD)
    println(hardEntity)
}