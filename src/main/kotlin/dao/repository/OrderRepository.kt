package dao.repository

import dto.internal.OrderDto
import dto.request.OrderRequest
import java.util.UUID

interface OrderRepository {
    fun insertOrder(order: OrderRequest, id: UUID, customerId: UUID)

    fun getOrderById(orderId: UUID): OrderDto?

    fun getAllOrders(): List<OrderDto>
}