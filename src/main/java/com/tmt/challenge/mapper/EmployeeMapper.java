package com.tmt.challenge.mapper;

import com.tmt.challenge.dto.EmployeeDTO;
import com.tmt.challenge.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target="departmentId", source="employeeId.departmentId"),
            @Mapping(target="employeeId", source="employeeId.employeeId")
    })
    EmployeeDTO toEmployeeDTO(Employee employee);
    List<EmployeeDTO> toEmployeeDTO(Collection<Employee> employees);
    @Mappings({
            @Mapping(target="employeeId.departmentId", source="departmentId"),
            @Mapping(target="employeeId.employeeId", source="employeeId")
    })
    Employee toEmployeeEntity(EmployeeDTO employeeDTO);
    List<Employee> toEmployeeEntity(Collection<EmployeeDTO> employeeDTOS);

}
