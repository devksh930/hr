package me.devksh930.hr.domain.model

import java.time.LocalDate

data class EmployeeJobHistoryQuery(
   val employeeId: Int,
   val startDate: LocalDate,
   val endDate: LocalDate,
   val jobId: String,
   val jobTitle: String,
   val departmentId: Int,
   val departmentName: String
)
