package com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PersonResponseDTO {
    String name;
    String message;

}
