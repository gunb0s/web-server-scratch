package codeReview

class UserManager {
    private val users = mutableListOf<User>()

    fun addUser(user: User): Boolean {
        if (users.any { it.id == user.id }) {
            println("User with id ${user.id} already exists.")
            return false
        }
        users.add(user)
        println("User added successfully.")
        return true
    }

    fun findUserByName(name: String): User? {
        return users.find { it.name == name }
    }

    fun getAllUsers(): List<User> {
        return users.toList()
    }
}

data class User(val id: Int, val name: String)

fun main() {
    val userManager = UserManager()
    userManager.addUser(User(1, "John Doe"))
    userManager.addUser(User(2, "Jane Doe"))

    println("Trying to add a user with an existing ID:")
    userManager.addUser(User(1, "John Smith"))

    val user = userManager.findUserByName("Jane Doe")
    println("Found user: $user")

    val allUsers = userManager.getAllUsers()
    println("All users:")
    allUsers.forEach { println(it) }
}