package me.devksh930.hr.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;

import me.devksh930.hr.domain.entity.Job;

public interface JobRepository extends JpaRepository<Job, String> {
}