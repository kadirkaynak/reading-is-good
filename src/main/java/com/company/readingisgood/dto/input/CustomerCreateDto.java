package com.company.readingisgood.dto.input;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerCreateDto {

    @NotNull(message = "Name cannot be null")
    @Length(min = 1, max = 100, message = "Name length should be between {min} and {max}")
    private String name;
    @NotNull(message = "Name cannot be null")
    @Length(min = 1, max = 100, message = "Name length should be between {min} and {max}")
    private String surname;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be a well-formed")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone should be a well-formed")
    private String phone;

}
