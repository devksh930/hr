package me.devksh930.hr.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;

import me.devksh930.hr.domain.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}