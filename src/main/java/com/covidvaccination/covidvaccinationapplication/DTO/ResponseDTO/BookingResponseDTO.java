package com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class BookingResponseDTO {

    String personName;

    String doctorName;

    String appointmentId;

    Date appointmentDate;

    CenterResponseDTO centerResponseDTO;

}
