package dao.adapter.product

import dao.entity.Product
import dto.OrderDto
import dto.ProductDto
import dto.ProductRequest
import jakarta.enterprise.context.ApplicationScoped
import java.math.BigDecimal
import java.util.UUID

@ApplicationScoped
class PanacheProductAdapter : ProductAdapter<Product>() {
    override fun fromOrderRequest(productRequest: ProductRequest): Product {
        val product = Product()

        product.id = UUID.randomUUID()
        product.name = productRequest.productName
        product.description = productRequest.productDescription
        product.price = BigDecimal.valueOf(productRequest.productPrice)
        product.imageUrl = productRequest.productImageUrl

        return product
    }

    override fun toProductDto(product: Product): ProductDto {
        return ProductDto(
            product.id,
            product.name,
            product.price.toDouble(),
            product.imageUrl,
            product.description
        )
    }
}