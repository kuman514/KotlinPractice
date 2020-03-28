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