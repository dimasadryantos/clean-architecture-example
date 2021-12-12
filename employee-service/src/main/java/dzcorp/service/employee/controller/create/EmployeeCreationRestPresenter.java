package dzcorp.service.employee.controller.create;

import dzcorp.client.employee.response.EmployeeCreationRestRestResponse;
import dzcorp.core.employee.create.EmployeeCreationOutputBoundary;
import dzcorp.core.employee.create.EmployeeCreationResponse;

public class EmployeeCreationRestPresenter implements EmployeeCreationOutputBoundary {

    private EmployeeCreationRestRestResponse restResponse;

    @Override
    public void present(EmployeeCreationResponse employeeResponse) {
        restResponse = new EmployeeCreationRestRestResponse();
        restResponse.setEmployeeId(employeeResponse.getEmployeeId());
        restResponse.setEmployeeName(employeeResponse.getEmployeeName());
    }


    public EmployeeCreationRestRestResponse getRestResponse() {
        return restResponse;
    }
}
