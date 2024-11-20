package me.devksh930.hr.infrastructure.command;

import org.springframework.data.jpa.repository.JpaRepository;

import me.devksh930.hr.domain.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}