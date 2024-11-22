package me.devksh930.hr.common.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class PagingUtils {
	private PagingUtils() {
		throw new IllegalStateException("Util class.");
	}

	public static <T> PageImpl<T> fetchPage(
		final Supplier<List<T>> dataSupplier,
		final PageRequest pageRequest,
		final Long count
	) {
		long totalCount = Optional.ofNullable(count).orElse(0L);

		if (totalCount == 0) {
			return new PageImpl<>(
				Collections.emptyList(),
				pageRequest,
				totalCount
			);
		}

		List<T> data = dataSupplier.get();
		return new PageImpl<>(
			data,
			pageRequest,
			totalCount
		);
	}

}
