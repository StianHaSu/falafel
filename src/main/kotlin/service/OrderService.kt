package service

import dao.repository.CustomerRepository
import dao.repository.OrderDetailRepository
import dao.repository.OrderRepository
import dto.request.OrderFilter
import dto.request.OrderRequest
import dto.request.PatchOrderRequest
import dto.response.OrderResponse
import dto.toOrderResponse
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

    fun getOrderById(id: UUID): OrderResponse = orderRepository.getOrderById(id)
        ?.toOrderResponse() ?: throw NotFoundException()


    fun getOrders(orderFiler: OrderFilter) = orderRepository.getOrders(orderFiler)

    private fun createOrderWithIds(order: OrderRequest, orderId: UUID, customerId: UUID): UUID =
        customerRepository.insertCustomer(order.customer, customerId)
            .also { orderRepository.insertOrder(order, orderId, customerId) }
            .also { orderDetailRepository.insertOrderDetails(order.orderDetails, orderId) }
            .let { orderId }

    fun updateOrder(id: UUID, orderPatch: PatchOrderRequest) =
            orderPatch.orderStatus
                ?.let { orderStatus -> orderRepository.setOrderStatus(id, orderStatus) }
                .also { orderPatch.paymentStatus
                    ?.let { paymentStatus -> orderRepository.setPaymentStatus(id, paymentStatus) }
                }
}