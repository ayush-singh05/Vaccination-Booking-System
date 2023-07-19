package com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO;

import com.covidvaccination.covidvaccinationapplication.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CenterDTO {
    String centerName;

    CenterType centerType;

    String address;
}
