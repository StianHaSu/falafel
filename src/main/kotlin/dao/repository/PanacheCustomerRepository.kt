package dao.repository

import dao.adapter.customer.CustomerAdapter
import dao.entity.Customer
import dto.CustomerRequest
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class PanacheCustomerRepository(private val adapter: CustomerAdapter<Customer>) : PanacheRepository<Customer>, CustomerRepository {
    override fun insertCustomer(customer: CustomerRequest, id: UUID) {
        persist(adapter.fromCustomerRequest(customer, id))
    }
}