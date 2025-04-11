package dev.cat.employee;

public class EmployeeMapper {

    public static EmployeeDTO toDto(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail());
    }

}







