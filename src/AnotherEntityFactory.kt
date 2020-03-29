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
    val entity: AnotherEntity = AnotherEntityFactory.create(AnotherEntityType.EASY)
    //val entity: AnotherEntity = AnotherEntityFactory.create(AnotherEntityType.MEDIUM)
    //val entity: AnotherEntity = AnotherEntityFactory.create(AnotherEntityType.HARD)
    //val entity: AnotherEntity = AnotherEntityFactory.create(AnotherEntityType.HELP)

    val msg = when(entity) {
        AnotherEntity.Help -> "help class"
        is AnotherEntity.Easy -> "easy class"
        is AnotherEntity.Medium -> "medium class"
        is AnotherEntity.Hard -> "hard class"
    }

    println(msg)
}