package resource

import dto.internal.ProductDto
import dto.request.ProductRequest
import jakarta.transaction.Transactional
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import service.ProductService
import java.util.UUID

@Path("/products")
class ProductResource(private val productService: ProductService) {

    @POST
    @Transactional
    fun createProduct(product: ProductRequest) = productService.createProduct(product)

    @GET
    fun getProducts(): List<ProductDto> = productService.getAllProducts()

    @DELETE
    fun deleteProductById(id: UUID) = productService.deleteProduct(id)
}