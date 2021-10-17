package com.company.readingisgood.dto.output;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerOutputDtoTest {
    @Test
    public void customerOutputDto() {
        //
        // Given
        //
        CustomerOutputDto customerOutputDto = CustomerOutputDto.builder().customerId(1L).name("name").surname("surname").email("email@gmail.com").phone("05000000000").build();
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("name", customerOutputDto.getName()),
                () -> assertEquals("surname", customerOutputDto.getSurname()),
                () -> assertEquals("email@gmail.com", customerOutputDto.getEmail()),
                () -> assertEquals("05000000000", customerOutputDto.getPhone())
        );
    }
    @Test
    public void customerOutputDtoGetterSetter() {
        //
        // Given
        //
        CustomerOutputDto customerOutputDto = new CustomerOutputDto();
        customerOutputDto.setName("name");
        customerOutputDto.setSurname("surname");
        customerOutputDto.setEmail("email@gmail.com");
        customerOutputDto.setPhone("05000000000");
        //
        // When
        //

        //
        // Then
        //
        assertAll("Should return dto",
                () -> assertEquals("name", customerOutputDto.getName()),
                () -> assertEquals("surname", customerOutputDto.getSurname()),
                () -> assertEquals("email@gmail.com", customerOutputDto.getEmail()),
                () -> assertEquals("05000000000", customerOutputDto.getPhone())
        );
    }
}