package me.devksh930.hr.test.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
public abstract class DataBaseIntegrationTest {
	private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>(DockerImageName.parse("mysql:8.0")).withDatabaseName("testdb")
		.withUsername("test")
		.withPassword("test")
		.withInitScript("testcontainer/init.sql");

	static {
		mysqlContainer.start(); // 컨테이너 시작
	}

	@DynamicPropertySource
	public static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add(
			"spring.datasource.url",
			mysqlContainer::getJdbcUrl
		);
		registry.add(
			"spring.datasource.username",
			mysqlContainer::getUsername
		);
		registry.add(
			"spring.datasource.password",
			mysqlContainer::getPassword
		);
	}
}
