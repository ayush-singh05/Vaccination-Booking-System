package com.covidvaccination.covidvaccinationapplication.Controller;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.AppointmentBookingDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.BookingResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentBookingDTO appointmentBookingDTO) {
        try{
            BookingResponseDTO bookingResponseDTO = appointmentService.bookAppointment(appointmentBookingDTO);
            return new ResponseEntity(bookingResponseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
