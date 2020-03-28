// object declaration
object EntityFactory {
    //fun create() = Entity("514", "kuman")
}

class Entity(val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id, name: $name"
    }
}

fun main() {
    val entity = EntityFactory.create()
    println(entity)
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