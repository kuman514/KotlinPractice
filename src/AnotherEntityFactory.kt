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

    data class Easy(val id: String, val name: String): AnotherEntity() {
        // ...
    }
    data class Medium(val id: String, val name: String): AnotherEntity()
    data class Hard(val id: String, val name: String, val multiplier: Float): AnotherEntity()
}

// class extension ============================
fun AnotherEntity.Medium.printInfo() {
    // extension function
    println("Medium Class: $id")
}

// extension property
val AnotherEntity.Medium.info : String
    get() = "Yasuo is Medium Science"
// ============================================

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

    // Same Class, Different Values (id)
    // that's why we use "is"
    val entity2: AnotherEntity = AnotherEntityFactory.create(AnotherEntityType.MEDIUM)

    // val entity2 = entity.copy()
    // val entity2 = entity.copy(name = "...")

    // this is data comparison
    if(entity == entity2) {
        println("same")
    } else {
        println("different")
    }
    // class type comparison: is
    // data value comparison: ==
    // reference comparison: ===

    if(entity2 is AnotherEntity.Medium) {
        entity2.printInfo()
        println(entity2.info)
    }
}