package dzcorp.service.employee.controller.create;

import dzcorp.client.employee.request.EmployeeCreationRestRequest;
import dzcorp.client.employee.response.EmployeeCreationRestRestResponse;
import dzcorp.core.employee.create.EmployeeCreationInputBoundary;
import dzcorp.core.employee.create.EmployeeCreationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCreationController {

    private final EmployeeCreationInputBoundary useCase;

    public EmployeeCreationController(EmployeeCreationInputBoundary useCase) {
        this.useCase = useCase;
    }

    @PostMapping(value = "/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeCreationRestRestResponse createEmployee(@RequestBody EmployeeCreationRestRequest restRequest) {
        EmployeeCreationRequest creationRequest = constructEmployeeRequest(restRequest);
        EmployeeCreationRestPresenter presenter = new EmployeeCreationRestPresenter();
        useCase.create(creationRequest, presenter);
        return presenter.getRestResponse();
    }

    private EmployeeCreationRequest constructEmployeeRequest(EmployeeCreationRestRequest restRequest) {
        return new EmployeeCreationRequest(restRequest.getEmployeeId(), restRequest.getEmployeeName());
    }


}
