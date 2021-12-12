package dzcorp.core.gateway;


import dzcorp.core.employee.create.EmployeeCreationRequest;
import dzcorp.core.employee.model.Employee;

public interface EmployeeCreationGateway {
    Employee saveEmployee(EmployeeCreationRequest creationRequest);
}
