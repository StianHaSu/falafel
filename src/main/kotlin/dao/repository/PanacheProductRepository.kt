package dao.repository

import dao.adapter.product.ProductAdapter
import dao.entity.Product
import dto.internal.ProductDto
import dto.request.ProductRequest
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheProductRepository(private val adapter: ProductAdapter<Product>): PanacheRepository<Product>, ProductRepository {
    override fun insertProduct(product: ProductRequest, id: UUID) {
        persist(adapter.fromOrderRequest(product, id))
    }

    override fun getProducts(): List<ProductDto> {
        return findAll().list().map { product -> adapter.toProductDto(product) }
    }

    override fun getProductById(id: UUID): ProductDto? {
        return find("id = ?1", id)
            .firstResult()?.let { adapter.toProductDto(it) }
    }

    override fun deleteProduct(id: UUID) {
        delete("id = ?1", id)
    }

    override fun updateName(id: UUID, newName: String) {
        update("name = ?1 where id = ?2", newName, id)
    }

    override fun updatePrice(id: UUID, price: Double) {
        update("price = ?1 where id = ?2", price, id)
    }

    override fun updateDescription(id: UUID, newDescription: String) {
        update("description = ?1 where id = ?2", newDescription, id)
    }
}