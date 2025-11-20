package dao.adapter.product

import dao.entity.Product
import dto.internal.OrderDto
import dto.internal.ProductDto
import dto.request.ProductRequest
import jakarta.enterprise.context.ApplicationScoped
import java.math.BigDecimal
import java.util.UUID

@ApplicationScoped
class PanacheProductAdapter : ProductAdapter<Product>() {
    override fun fromOrderRequest(productRequest: ProductRequest, id: UUID): Product {
        val product = Product()

        product.id = id
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