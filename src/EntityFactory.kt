import java.util.*

// enum class
enum class EntityType {
    EASY, MEDIUM, HARD
}

// object declaration
object EntityFactory {
    //fun create() = Entity("514", "kuman")
    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> "Easy"
            EntityType.MEDIUM -> "Medium"
            EntityType.HARD -> "Hard"
        }

        return Entity(id, name)
    }
}

class Entity(val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id, name: $name"
    }
}

fun main() {
    val easyEntity = EntityFactory.create(EntityType.EASY)
    println(easyEntity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)

    val hardEntity = EntityFactory.create(EntityType.HARD)
    println(hardEntity)
}

/*
// Object Companions

interface IdProvider {
    fun getID(): String
}

class Entity private constructor(val id: String) {
    companion object Factory: IdProvider {
        override fun getID(): String {
            return "123"
        }

        const val id = "ID"
        fun create() = Entity(getID())
    }
}

fun main() {
    //val entity = Entity.Companion.create()
    //val entity = Entity.create()
    val entity = Entity.Factory.create()
    Entity.id
}
*/