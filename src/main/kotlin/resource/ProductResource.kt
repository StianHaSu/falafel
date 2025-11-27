package resource

import auth.ProtectedEndpoint
import auth.Roles
import dto.internal.ProductDto
import dto.request.ProductPatchRequest
import dto.request.ProductRequest
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import service.ProductService
import java.util.UUID

@Path("/products")
class ProductResource(private val productService: ProductService) {

    @POST
    @Transactional
    @ProtectedEndpoint(allowableRoles = [Roles.STORE_MODERATOR])
    fun createProduct(@Valid product: ProductRequest) = productService.createProduct(product)

    @GET
    fun getProducts(): List<ProductDto> = productService.getAllProducts()

    @DELETE
    @Transactional
    @Path("/{productId}")
    @ProtectedEndpoint(allowableRoles = [Roles.STORE_MODERATOR])
    fun deleteProductById(@PathParam("productId") id: UUID) = productService.deleteProduct(id)

    @PATCH
    @Transactional
    @Path("/{productId}")
    @ProtectedEndpoint(allowableRoles = [Roles.STORE_MODERATOR])
    fun patchProduct(@PathParam("productId") id: UUID, patch: ProductPatchRequest) =
        productService.applyPatchToProduct(id, patch)
}