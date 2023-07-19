package com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO;

import com.covidvaccination.covidvaccinationapplication.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DoseDTO {
    int personId;
    DoseType doseType;
}
