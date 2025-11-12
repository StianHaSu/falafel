package service

import dao.repository.CustomerRepository
import dao.repository.OrderRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository,
) {

}