//class Person                          // Create an empty class

//class Person constructor(v: String)   // Create an empty class with a constructor
//class Person(v: String)               // this one too

/*
class Person(_firstName: String, _lastName: String) {
    val firstName: String = _firstName
    val lastName: String = _lastName
}
*/

/*
class Person(val firstName: String, val lastName: String) { // Still can instantiate
    // execute secondary constructor after all inits
    init {
        println("init 1")
    }

    constructor(): this("Steve", "Fox") {
        println("secondary constructor")
    }

    init {
        println("init 2")
    }
}
*/

// Visibility in Kotlin is public by default
// We don't have to use "public" if a variable or class is supposed to be public

// public: accessible in all range
// internal: accessible within the module
// protected: accessible within the class and it's subclasses
// private: accessible within the file in which it's implemented

// ex) public class ..., internal class ..., protected var ..., private val ...

class Person(val firstName: String = "Steve", val lastName: String = "Fox") {
    var nickName: String? = null
        set(value) {
            // if setter is defined, these will run if modified the value (by =)
            // field -> property of the variable
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value is $field")
            return field
        }

    fun printInfo() {
        //val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}