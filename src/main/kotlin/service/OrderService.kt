package service

import dao.repository.CustomerRepository
import dao.repository.OrderDetailRepository
import dao.repository.OrderRepository
import dto.OrderDto
import dto.OrderRequest
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.NotFoundException
import java.util.UUID

@ApplicationScoped
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository,
    private val orderDetailRepository: OrderDetailRepository
) {

    fun createOrderForCustomer(order: OrderRequest): UUID =
        createOrderWithIds(order, UUID.randomUUID(), UUID.randomUUID())

    fun getOrderById(id: UUID): OrderDto = orderRepository.getOrderById(id)
        ?.takeIf { true } ?: throw NotFoundException()

    fun getAllOrders() = orderRepository.getAllOrders()

    private fun createOrderWithIds(order: OrderRequest, orderId: UUID, customerId: UUID): UUID =
        customerRepository.insertCustomer(order.customer, customerId)
            .also { orderRepository.insertOrder(order, orderId, customerId) }
            .also { orderDetailRepository.insertOrderDetails(order.orderDetails, orderId) }
            .let { orderId }
}