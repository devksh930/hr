package me.devksh930.hr.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;

import me.devksh930.hr.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}