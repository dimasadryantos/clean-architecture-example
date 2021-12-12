package dzcorp.service.config;

import dzcorp.core.employee.create.EmployeeCreationInputBoundary;
import dzcorp.core.employee.create.EmployeeCreationUseCase;
import dzcorp.core.gateway.EmployeeCreationGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {


    @Bean
    public EmployeeCreationInputBoundary useCase(EmployeeCreationGateway creationGateway) {
        return new EmployeeCreationUseCase(creationGateway);
    }


}
