package com.sagar.registry;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"HOSTNAME=eureka-0"})
class ServiceRegistryApplicationTests {

	@Test
	void contextLoads() {
	}

}
