package me.devksh930.hr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "countries",
	indexes = {
		@Index(name = "idx_countries_region_id", columnList = "region_id")
	}
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Country {

	@Id
	private String countryId;

	private String countryName;

	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;

	public Country(
		final String countryId,
		final String countryName,
		final Region region
	) {
		this.countryId = countryId;
		this.countryName = countryName;
		this.region = region;
	}
}
