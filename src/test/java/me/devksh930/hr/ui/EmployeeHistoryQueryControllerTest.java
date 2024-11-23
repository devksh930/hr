package me.devksh930.hr.ui;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import me.devksh930.hr.application.service.EmployeeHistoryQueryService;
import me.devksh930.hr.dto.response.EmployeeJobHistoryResponse;

@WebMvcTest(EmployeeHistoryQueryController.class)
class EmployeeHistoryQueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeHistoryQueryService employeeHistoryQueryService;

	@Test
	@DisplayName("성공적으로 직원의 job history를 반환한다")
	void queryEmployeeJobHistory_Success() throws Exception {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size);
		Integer employeeId = 101;

		List<EmployeeJobHistoryResponse> jobHistories = List.of(
			new EmployeeJobHistoryResponse(101, LocalDate.of(1989, 9, 21), LocalDate.of(1993, 10, 27), "AC_ACCOUNT", "Public Accountant", 110, "Accounting"),
			new EmployeeJobHistoryResponse(101, LocalDate.of(1995, 4, 1), LocalDate.of(2000, 12, 15), "IT_PROG", "Programmer", 60, "IT")
		);

		PageImpl<EmployeeJobHistoryResponse> jobHistoryPage = new PageImpl<>(jobHistories, pageRequest, jobHistories.size());

		when(employeeHistoryQueryService.queryEmployeeJobHistory(employeeId, pageRequest)).thenReturn(jobHistoryPage);

		mockMvc.perform(get("/employees/{employeeId}/job-history", employeeId)
				.param("page", String.valueOf(page))
				.param("size", String.valueOf(size))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").isArray())
			.andExpect(jsonPath("$.content[0].employeeId").value(101))
			.andExpect(jsonPath("$.content[0].jobId").value("AC_ACCOUNT"))
			.andExpect(jsonPath("$.content[0].jobTitle").value("Public Accountant"))
			.andExpect(jsonPath("$.content[0].departmentId").value(110))
			.andExpect(jsonPath("$.content[0].departmentName").value("Accounting"))
			.andExpect(jsonPath("$.content[1].employeeId").value(101))
			.andExpect(jsonPath("$.content[1].jobId").value("IT_PROG"))
			.andExpect(jsonPath("$.content[1].jobTitle").value("Programmer"))
			.andExpect(jsonPath("$.content[1].departmentId").value(60))
			.andExpect(jsonPath("$.content[1].departmentName").value("IT"));
	}

	@Test
	@DisplayName("유효하지 않은 페이지 요청에 대해 빈 결과를 반환한다")
	void queryEmployeeJobHistory_shouldReturnEmptyResultsForInvalidPageRequest() throws Exception {
		int page = 100;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size);
		Integer employeeId = 101;
		PageImpl<EmployeeJobHistoryResponse> pageResponse = new PageImpl<>(List.of(), pageRequest, 0);

		given(employeeHistoryQueryService.queryEmployeeJobHistory(employeeId, pageRequest)).willReturn(pageResponse);

		mockMvc.perform(get("/employees/{employeeId}/job-history", employeeId)
				.param("page", String.valueOf(page))
				.param("size", String.valueOf(size))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").isEmpty());
	}
}