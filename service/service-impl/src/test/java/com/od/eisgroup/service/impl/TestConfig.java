package com.od.eisgroup.service.impl;

import com.od.eisgroup.dao.api.RoleDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

/**
 * This class provides test configuration of the Servise Layer of a EIS HR Project.
 *
 * @author Alice Klochkova
 * @since 1.1
 */
@Configuration
@ImportResource("classpath*:META-INF/spring/service-impl-spring-context.xml")
public class TestConfig {

    /**
     * Mocked Bean for {@link com.od.eisgroup.service.impl.RoleServiceImplTest} to Autowire.
     */
    @Bean
    @Primary
    public RoleDAO roleDAO() {
        return mock(RoleDAO.class);
    }
}
