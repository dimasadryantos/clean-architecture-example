package dzcorp.persistence.employee.create;

import dzcorp.core.employee.create.EmployeeCreationRequest;
import dzcorp.core.employee.model.Employee;
import dzcorp.core.gateway.EmployeeCreationGateway;

public class JpaEmployeeCreationGateway implements EmployeeCreationGateway {

    private final EmployeeCreationRepository employeeRepository;

    public JpaEmployeeCreationGateway(EmployeeCreationRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(EmployeeCreationRequest request) {
        EmployeeEntity employeeEntity = EmployeeEntity.valueOf(request);
        return employeeRepository.save(employeeEntity);
    }

}
