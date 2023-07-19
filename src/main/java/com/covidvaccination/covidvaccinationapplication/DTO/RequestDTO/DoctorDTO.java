package com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO;

import com.covidvaccination.covidvaccinationapplication.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DoctorDTO {

    int centerId;

    String name;

    int age;

    String emailId;

    Gender gender;
}
