package com.my.employeesystemmvc.model;
import com.my.employeesystemmvc.validation.CheckEmployee;
import com.my.employeesystemmvc.validation.UniqueEmail;
import com.my.employeesystemmvc.validation.ValidName;
import com.my.employeesystemmvc.validation.groups.AddValidation;
import com.my.employeesystemmvc.validation.groups.UpdateValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@CheckEmployee(message = "email exist in database", groups = UpdateValidation.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ValidName(message = "first name must have only alphabetic characters and first letter must be capitalized",
            groups = {AddValidation.class, UpdateValidation.class})
    String firstName;

    @ValidName(message = "last name must have only alphabetic characters and first letter must be capitalized",
            groups = {AddValidation.class, UpdateValidation.class})
    String lastName;

    @Email(message = "valid email is required", groups = {AddValidation.class, UpdateValidation.class})
    @NotEmpty(message = "is required", groups = {AddValidation.class, UpdateValidation.class})
    @UniqueEmail(message = "email exist in database", groups = AddValidation.class)
    String email;
}
