package me.devksh930.hr.domain.model

data class DepartmentQuery(
    val departmentId: Int,
    val departmentName: String,
    val manageId: Int,
    val locationId: Int,
    val streetAddress: String,
    val postalCode: String,
    val city: String,
    val stateProvince: String,
    val countryId: String,
    val countryName: String,
    val regionId: Int,
    val regionName: String
)
