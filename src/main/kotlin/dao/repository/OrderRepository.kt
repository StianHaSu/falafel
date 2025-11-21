package dao.repository

import OrderStatus
import PaymentStatus
import dto.internal.OrderDto
import dto.request.OrderFilter
import dto.request.OrderRequest
import java.util.UUID

interface OrderRepository {
    fun insertOrder(order: OrderRequest, id: UUID, customerId: UUID)

    fun getOrderById(orderId: UUID): OrderDto?

    fun getOrders(filter: OrderFilter): List<OrderDto>

    fun setOrderStatus(id: UUID, orderStatus: OrderStatus)

    fun setPaymentStatus(id: UUID, paymentStatus: PaymentStatus)
}