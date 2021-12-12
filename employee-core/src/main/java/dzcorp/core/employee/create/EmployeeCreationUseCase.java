package dzcorp.core.employee.create;

import dzcorp.core.employee.model.Employee;
import dzcorp.core.gateway.EmployeeCreationGateway;

public class EmployeeCreationUseCase implements EmployeeCreationInputBoundary {

    private final EmployeeCreationGateway employeeCreationGateway;

    public EmployeeCreationUseCase(EmployeeCreationGateway employeeCreationGateway) {
        this.employeeCreationGateway = employeeCreationGateway;
    }

    @Override
    public void create(EmployeeCreationRequest employeeRequest, EmployeeCreationOutputBoundary presenter) {
        Employee employee = employeeCreationGateway.saveEmployee(employeeRequest);
        constructResponse(employee, presenter);
    }

    private void constructResponse(Employee employee, EmployeeCreationOutputBoundary presenter) {
        EmployeeCreationResponse employeeResponse = EmployeeCreationResponse.valueOf(employee);
        presenter.present(employeeResponse);
    }


}
