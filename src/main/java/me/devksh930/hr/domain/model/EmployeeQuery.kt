package me.devksh930.hr.domain.model

import java.time.LocalDate


data class EmployeeQuery(
     val id: Int,
     val firstName: String,
     val lastName: String,
     val email: String,
     val phoneNumber: String,
     val hireDate: LocalDate,
     val departmentId: String,
     val departmentName: String,
     val jobId: String,
     val jobTitle: String
)
