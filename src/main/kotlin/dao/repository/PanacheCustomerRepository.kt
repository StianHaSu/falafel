package dao.repository

import dao.adapter.customer.CustomerAdapter
import dao.entity.Customer
import dto.CustomerRequest
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PanacheCustomerRepository(private val adapter: CustomerAdapter<Customer>) : PanacheRepository<Customer>, CustomerRepository {
    override fun insertCustomer(customer: CustomerRequest) {
        persist(adapter.fromCustomerRequest(customer))
    }
}