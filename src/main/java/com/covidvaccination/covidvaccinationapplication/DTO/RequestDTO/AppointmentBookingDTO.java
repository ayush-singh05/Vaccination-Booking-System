package com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AppointmentBookingDTO {
    int personId;
    int doctorId;
}
