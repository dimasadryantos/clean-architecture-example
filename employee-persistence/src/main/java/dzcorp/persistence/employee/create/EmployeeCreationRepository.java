package dzcorp.persistence.employee.create;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCreationRepository extends JpaRepository<EmployeeEntity, Integer> {
}
