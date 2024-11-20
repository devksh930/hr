package me.devksh930.hr.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;

import me.devksh930.hr.domain.entity.JobHistory;
import me.devksh930.hr.domain.entity.JobHistoryId;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
}