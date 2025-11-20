package dao.repository

import dto.request.CustomerRequest
import java.util.UUID

interface CustomerRepository {
    fun insertCustomer(customer: CustomerRequest, id: UUID)
}