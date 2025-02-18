package me.devksh930.hr.domain.model

import java.math.BigDecimal

data class EmployeeDetailQuery(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val jobId: String,
    val jobTitle: String,
    val departmentId: Int,
    val departmentName: String,
    val locationId: Int,
    val city: String,
    val stateProvince: String,
    val countryId: String,
    val countryName: String,
    val regionName: String,
    val salary: BigDecimal,
    val commissionPct: BigDecimal = BigDecimal.ZERO,
    val managerId: Int
)
