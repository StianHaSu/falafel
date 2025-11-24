package resource

import auth.ProtectedEndpoint
import auth.Roles
import com.arjuna.ats.arjuna.objectstore.StoreManager
import dto.internal.ProductDto
import dto.request.ProductRequest
import io.quarkus.security.Authenticated
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
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
}