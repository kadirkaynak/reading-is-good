package com.company.readingisgood.dto.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerCreateDtoTest {
    @Test
    public void bookCustomerCreateDtoBuilder() {
        //
        // Given
        //
        CustomerCreateDto customerCreateDto = CustomerCreateDto.builder().name("name").surname("surname").email("email@gmail.com").phone("05000000000").build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("name", customerCreateDto.getName()),
                () -> assertEquals("surname", customerCreateDto.getSurname()),
                () -> assertEquals("email@gmail.com", customerCreateDto.getEmail()),
                () -> assertEquals("05000000000", customerCreateDto.getPhone())
        );
    }
    @Test
    public void bookCustomerCreateGetterSetter() {
        //
        // Given
        //
        CustomerCreateDto customerCreateDto = new CustomerCreateDto();
        customerCreateDto.setName("name");
        customerCreateDto.setSurname("surname");
        customerCreateDto.setEmail("email@gmail.com");
        customerCreateDto.setPhone("05000000000");
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("name", customerCreateDto.getName()),
                () -> assertEquals("surname", customerCreateDto.getSurname()),
                () -> assertEquals("email@gmail.com", customerCreateDto.getEmail()),
                () -> assertEquals("05000000000", customerCreateDto.getPhone())
        );
    }
}