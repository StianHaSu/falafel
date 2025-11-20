package dao.adapter.product

import dto.internal.ProductDto
import dto.request.ProductRequest
import java.util.UUID

abstract class ProductAdapter<T> {
    abstract fun fromOrderRequest(productRequest: ProductRequest, id: UUID): T

    abstract fun toProductDto(product: T): ProductDto
}