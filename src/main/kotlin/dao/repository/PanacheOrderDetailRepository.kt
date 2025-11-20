package dao.repository

import dao.adapter.order_detail.OrderDetailAdapter
import dao.entity.OrderDetail
import dto.request.OrderDetailRequest
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheOrderDetailRepository(private val adapter: OrderDetailAdapter<OrderDetail>): PanacheRepository<OrderDetail>, OrderDetailRepository {
    override fun insertOrderDetails(orderDetailDtos: List<OrderDetailRequest>, orderId: UUID) {
        orderDetailDtos
            .map { detail -> adapter.fromOrderDetailDto(detail, orderId, detail.productId) }
            .let { details -> persist(details) }
    }
}