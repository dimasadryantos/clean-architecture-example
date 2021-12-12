package dzcorp.core.employee.create;

import dzcorp.core.employee.model.Employee;

public class EmployeeCreationResponse {
    private Integer employeeId;

    private String employeeName;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeCreationResponse() {
    }

    public EmployeeCreationResponse(Integer employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private Integer employeeId;
        private String employeeName;

        public Builder setEmployeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public EmployeeCreationResponse build() {
            return new EmployeeCreationResponse(employeeId, employeeName);
        }
    }


    public static EmployeeCreationResponse valueOf(Employee employee) {
        return EmployeeCreationResponse.builder()
                .setEmployeeId(employee.getEmployeeId())
                .setEmployeeName(employee.getEmployeeName()).build();
    }


}
