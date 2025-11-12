package resource

import dto.OrderDto
import dto.OrderRequest
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import service.OrderService
import java.util.UUID

@Path("/orders")
class OrderResource(private val orderService: OrderService) {

    @POST
    @Transactional
    fun createOrder(orderRequest: OrderRequest): UUID = orderService.createOrderForCustomer(orderRequest)

    @GET
    @Path("/{orderId}")
    fun getOrderById(@PathParam("orderId") orderId: UUID): OrderDto = orderService.getOrderById(orderId)
}