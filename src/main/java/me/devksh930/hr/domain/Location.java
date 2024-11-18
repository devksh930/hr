package me.devksh930.hr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations", indexes = {@Index(name = "idx_locations_country_id", columnList = "country_id")})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;

	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	public Location(
		final Integer locationId,
		final String streetAddress,
		final String postalCode,
		final String city,
		final String stateProvince,
		final Country country
	) {
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}
}