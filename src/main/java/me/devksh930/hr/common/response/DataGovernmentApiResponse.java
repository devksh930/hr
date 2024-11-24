package me.devksh930.hr.common.response;

import java.util.List;

public record DataGovernmentApiResponse<T>(
	int currentCount,
	List<T> data,
	int matchCount,
	int page,
	int perPage,
	int totalCount
) {
}