package auth

enum class Roles(val roleName: String) {
    STORE_MODERATOR("moderator"),
    STORE_WORKER("worker"),
}