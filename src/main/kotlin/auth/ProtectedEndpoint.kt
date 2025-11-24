package auth

annotation class ProtectedEndpoint(
    val allowableRoles: Array<Roles> = []
)
