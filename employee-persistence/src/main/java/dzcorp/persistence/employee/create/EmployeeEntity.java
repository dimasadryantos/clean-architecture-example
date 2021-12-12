package dzcorp.persistence.employee.create;

import dzcorp.core.employee.create.EmployeeCreationRequest;
import dzcorp.core.employee.model.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Employee {

    @Id
    private Integer employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    public EmployeeEntity(Integer employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public EmployeeEntity() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                '}';
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

        public EmployeeEntity build() {
            return new EmployeeEntity(employeeId, employeeName);
        }
    }


    public static EmployeeEntity valueOf(EmployeeCreationRequest request) {
        return EmployeeEntity.builder().setEmployeeId(request.getEmployeeId()).setEmployeeName(request.getEmployeeName()).build();
    }
}
