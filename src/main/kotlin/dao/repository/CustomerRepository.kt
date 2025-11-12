package dao.repository

import dto.CustomerRequest
import java.util.UUID

interface CustomerRepository {
    fun insertCustomer(customer: CustomerRequest, id: UUID)
}