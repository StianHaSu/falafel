package dao.repository

import dto.OrderDto
import dto.OrderRequest
import java.util.UUID

interface OrderRepository {
    fun insertOrder(order: OrderRequest, id: UUID, customerId: UUID)

    fun getOrderById(orderId: UUID): OrderDto?
}