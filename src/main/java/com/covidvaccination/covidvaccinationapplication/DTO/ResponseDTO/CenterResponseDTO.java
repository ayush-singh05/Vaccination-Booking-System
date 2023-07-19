package com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO;

import com.covidvaccination.covidvaccinationapplication.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CenterResponseDTO {
    String centerName;

    CenterType centerType;

    String address;
}
