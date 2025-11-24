package auth

import io.smallrye.jwt.auth.principal.JWTAuthContextInfo
import io.smallrye.jwt.auth.principal.JWTParser
import jakarta.enterprise.context.ApplicationScoped
import jakarta.json.JsonString
import jakarta.ws.rs.ForbiddenException
import jakarta.ws.rs.NotAuthorizedException
import org.eclipse.microprofile.jwt.JsonWebToken

@ApplicationScoped
class TokenValidation(
    private val jwt: JsonWebToken,
    private val context: JWTAuthContextInfo,
    private val jwtParser: JWTParser,
) {

    fun authenticate() {
        if (jwt.rawToken == null) {
            throw NotAuthorizedException("Unauthenticated")
        }

        try {
            val token = verifyToken()
        } catch (e: Exception) {
            throw NotAuthorizedException("User is not authorized to access this resource")
        }
    }

    private fun verifyToken(): JsonWebToken {
        return jwtParser.parse(jwt.rawToken, context)
    }

    fun checkRoles(allowedRoles: List<Roles>) {
        val roles = jwt.getClaim<Map<String, List<JsonString>>>("metadata")
            ?.get("roles")?.map { it.string } ?: emptyList()

        val allowedRoleNames = allowedRoles.map { role -> role.roleName }

        if (allowedRoles.isEmpty() || allowedRoleNames.any { roles.contains(it) }) {
            return
        } else {
            throw ForbiddenException("User is not authorized to access this resource")
        }
    }
}