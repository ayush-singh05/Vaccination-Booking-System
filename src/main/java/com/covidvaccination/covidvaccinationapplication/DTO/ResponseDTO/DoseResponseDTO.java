package com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO;

import com.covidvaccination.covidvaccinationapplication.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DoseResponseDTO {
    String message;

}
