package me.devksh930.hr.common.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

class PagingUtilsTest {

	@Test
	@DisplayName("데이터가 없는 경우 빈리스트 생성")
	public void testFetchPageWithNoData() {
		PageRequest pageRequest = PageRequest.of(
			0,
			10
		);
		Long count = 0L;

		Supplier<List<String>> dataSupplier = Collections::emptyList;

		Page<String> page = PagingUtils.fetchPage(
			dataSupplier,
			pageRequest,
			count
		);

		assertEquals(
			0,
			page.getTotalElements()
		);
		assertEquals(
			0,
			page.getTotalPages()
		);
		assertTrue(page.getContent().isEmpty());
	}

	@Test
	@DisplayName("데이터가 존재하는 경우 페이지 생성")
	public void testFetchPageWithData() {
		PageRequest pageRequest = PageRequest.of(
			0,
			10
		);
		List<String> fakeData = List.of(
			"A",
			"B",
			"C"
		);
		Long count = 3L;

		Supplier<List<String>> dataSupplier = () -> fakeData;

		Page<String> page = PagingUtils.fetchPage(
			dataSupplier,
			pageRequest,
			count
		);

		assertEquals(
			3,
			page.getTotalElements()
		);
		assertEquals(
			1,
			page.getTotalPages()
		);
		assertEquals(
			fakeData,
			page.getContent()
		);
	}

	@Test
	@DisplayName("카운트가 NULL일때 빈리스트 생성")
	public void testFetchPageWithNullCount() {
		PageRequest pageRequest = PageRequest.of(
			0,
			10
		);
		Supplier<List<String>> dataSupplier = Collections::emptyList;

		Page<String> page = PagingUtils.fetchPage(
			dataSupplier,
			pageRequest,
			null
		);

		assertEquals(
			0,
			page.getTotalElements()
		);
		assertEquals(
			0,
			page.getTotalPages()
		);
		assertTrue(page.getContent().isEmpty());
	}

	@Test
	@DisplayName("카운트가 0 일때 지연실행테스트")
	public void testFetchPageWithNoDataLazyEvaluation() {
		Supplier<List<String>> dataSupplier = Mockito.mock(Supplier.class);
		PageRequest pageRequest = PageRequest.of(
			0,
			10
		);

		PageImpl<String> result = PagingUtils.fetchPage(
			dataSupplier,
			pageRequest,
			0L
		);

		// Assert
		assertEquals(
			0,
			result.getTotalElements()
		);
		assertEquals(
			Collections.emptyList(),
			result.getContent()
		);
		verify(
			dataSupplier,
			times(0)
		).get();
	}

	@Test
	@DisplayName("카운트가 0이 아닐때 지연실행테스트")
	public void testFetchPageWithDataLazyEvaluation() {
		List<String> mockData = List.of(
			"A",
			"B"
		);

		Supplier<List<String>> dataSupplier = Mockito.mock(Supplier.class);
		when(dataSupplier.get()).thenReturn(mockData);
		PageRequest pageRequest = PageRequest.of(
			0,
			10
		);

		PageImpl<String> result = PagingUtils.fetchPage(
			dataSupplier,
			pageRequest,
			2L
		);

		// Assert
		assertEquals(
			2,
			result.getTotalElements()
		);
		assertEquals(
			mockData,
			result.getContent()
		);
		verify(
			dataSupplier,
			times(1)
		).get();
	}
}