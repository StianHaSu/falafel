package auth

import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ResourceInfo
import org.jboss.resteasy.reactive.server.ServerRequestFilter

class AuthFilter(
    private val tokenValidation: TokenValidation,
    private val resourceInfo: ResourceInfo
) {

    @ServerRequestFilter(preMatching = false)
    fun accessControl(requestContext: ContainerRequestContext) {
        val protectionAnnotation = resourceInfo.resourceMethod.annotations
            .filterIsInstance<ProtectedEndpoint>().firstOrNull()

        if (protectionAnnotation == null) return

        tokenValidation.authenticate()
        tokenValidation.checkRoles(protectionAnnotation.allowableRoles.toList())
    }
}