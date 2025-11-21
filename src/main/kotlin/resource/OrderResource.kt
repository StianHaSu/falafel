package resource

import OrderStatus
import PaymentStatus
import dto.internal.OrderDto
import dto.request.OrderFilter
import dto.request.OrderRequest
import dto.request.PatchOrderRequest
import dto.response.OrderResponse
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import jakarta.ws.rs.BeanParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.QueryParam
import service.OrderService
import java.util.UUID

@Path("/orders")
class OrderResource(private val orderService: OrderService) {

    @POST
    @Transactional
    fun createOrder(@Valid orderRequest: OrderRequest): UUID = orderService.createOrderForCustomer(orderRequest)

    @GET
    fun getAllOrders(
        @BeanParam orderFilter: OrderFilter,
    ): List<OrderDto> = orderService.getOrders(orderFilter)

    @GET
    @Path("/{orderId}")
    fun getOrderById(@PathParam("orderId") orderId: UUID): OrderResponse = orderService.getOrderById(orderId)

    @PATCH
    @Transactional
    @Path("/{orderId}")
    fun updateOrder(orderUpdate: PatchOrderRequest, @PathParam("orderId") orderId: UUID) =
        orderService.updateOrder(orderId, orderUpdate)
}