package dzcorp.core.employee.create;

public interface EmployeeCreationInputBoundary {
    void create(EmployeeCreationRequest employeeRequest, EmployeeCreationOutputBoundary presenter);
}
