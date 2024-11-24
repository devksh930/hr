package me.devksh930.hr.application.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.devksh930.hr.domain.entity.Employee;
import me.devksh930.hr.domain.entity.Job;
import me.devksh930.hr.domain.entity.JobHistory;
import me.devksh930.hr.dto.command.EmployeeJobChangeCommand;
import me.devksh930.hr.exception.EmployeeNotFoundException;
import me.devksh930.hr.exception.JobNotFoundException;
import me.devksh930.hr.infrastructure.command.EmployeeRepository;
import me.devksh930.hr.infrastructure.command.JobHistoryRepository;
import me.devksh930.hr.infrastructure.command.JobRepository;

@Service
@RequiredArgsConstructor
public class EmployeeJobChangeService {
	private final EmployeeRepository employeeRepository;
	private final JobRepository jobRepository;
	private final JobHistoryRepository jobHistoryRepository;

	@Transactional
	public void changeJob(
		final EmployeeJobChangeCommand command
	) {
		final Employee employee = employeeRepository.findByEmployeeIdFetchJobAndManageDepartment(command.employeeId())
			.orElseThrow(EmployeeNotFoundException::new);

		final Job changeJob = jobRepository.findById(command.jobId())
			.orElseThrow(JobNotFoundException::new);

		saveJobHistory(
			employee,
			employee.getJob(),
			command.startDate(),
			command.endDate()
		);

		employee.changeJob(changeJob);

	}

	private void saveJobHistory(
		final Employee employee,
		final Job changeJob,
		final LocalDate startDate,
		final LocalDate endDate
	) {
		if (employee.isSameJob(changeJob)) {
			return;
		}

		final JobHistory jobHistory = new JobHistory(
			employee.getEmployeeId(),
			startDate,
			endDate,
			employee.getJob(),
			employee.getDepartment()
		);

		jobHistoryRepository.save(jobHistory);
	}
}
