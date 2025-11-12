package resource

import dto.ProductDto
import dto.ProductRequest
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import service.ProductService

@Path("/products")
class ProductResource(private val productService: ProductService) {

    @POST
    @Transactional
    fun createProduct(product: ProductRequest) = productService.createProduct(product)

    @GET
    fun getProducts(): List<ProductDto> = productService.getAllProducts()
}