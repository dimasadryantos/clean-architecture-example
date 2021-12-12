package dzcorp.service.config;

import dzcorp.core.gateway.EmployeeCreationGateway;
import dzcorp.persistence.employee.create.EmployeeCreationRepository;
import dzcorp.persistence.employee.create.JpaEmployeeCreationGateway;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "dzcorp.persistence")
@EnableJpaRepositories(basePackages = "dzcorp.persistence")
public class JpaConfiguration {


    @Bean
    public EmployeeCreationGateway employeeCreationGateway(EmployeeCreationRepository repository){
        return new JpaEmployeeCreationGateway(repository);
    }


}
