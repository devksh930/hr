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

import me.devksh930.hr.application.service.EmployeeQueryService;
import me.devksh930.hr.dto.response.EmployeeQueryResponse;

@WebMvcTest(EmployeeQueryController.class)
class EmployeeQueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeQueryService employeeQueryService;

	@Test
	@DisplayName("성공적으로 직원 목록을 반환한다")
	void queryEmployee_Success() throws Exception {
		// Given
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(
			page,
			size
		);

		List<EmployeeQueryResponse> employees = List.of(
			new EmployeeQueryResponse(
				209,
				"Emily",
				"Davis",
				"EDAVIS",
				"555-987-6543",
				LocalDate.of(
					2018,
					12,
					1
				),
				"104",
				"Finance",
				"FIN004",
				"Financial Analyst"
			),
			new EmployeeQueryResponse(
				210,
				"Michael",
				"Brown",
				"MBROWN",
				"444-321-9876",
				LocalDate.of(
					2020,
					11,
					30
				),
				"105",
				"HR",
				"HR005",
				"HR Specialist"
			)
		);

		PageImpl<EmployeeQueryResponse> employeePage = new PageImpl<>(
			employees,
			pageRequest,
			employees.size()
		);

		when(employeeQueryService.queryEmployee(pageRequest)).thenReturn(employeePage);

		mockMvc.perform(get("/employees")
				.param(
					"page",
					String.valueOf(page)
				)
				.param(
					"size",
					String.valueOf(size)
				)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").isArray())
			.andExpect(jsonPath("$.content[0].firstName").value("Emily"))
			.andExpect(jsonPath("$.content[0].lastName").value("Davis"))
			.andExpect(jsonPath("$.content[0].jobId").value("FIN004"))
			.andExpect(jsonPath("$.content[0].departmentId").value("104"))
			.andExpect(jsonPath("$.content[1].firstName").value("Michael"))
			.andExpect(jsonPath("$.content[1].lastName").value("Brown"))
			.andExpect(jsonPath("$.content[1].jobId").value("HR005"))
			.andExpect(jsonPath("$.content[1].departmentId").value("105"));
	}
	@Test
	@DisplayName("유효하지 않은 페이지 요청에 대해 빈 결과를 반환한다")
	void queryEmployee_shouldReturnEmptyResultsForInvalidPageRequest() throws Exception {
		// given
		int page = 100;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size);
		PageImpl<EmployeeQueryResponse> pageResponse = new PageImpl<>(List.of(),pageRequest,0);

		given(employeeQueryService.queryEmployee(pageRequest)).willReturn(pageResponse);

		// when, then
		mockMvc.perform(get("/employees")
				.param("page", String.valueOf(page))
				.param("size", String.valueOf(size))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").isEmpty());
	}
}