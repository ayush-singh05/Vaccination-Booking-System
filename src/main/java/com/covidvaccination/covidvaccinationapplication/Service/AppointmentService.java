package com.covidvaccination.covidvaccinationapplication.Service;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.AppointmentBookingDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.BookingResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Exception.DoctorNotFoundException;
import com.covidvaccination.covidvaccinationapplication.Exception.PersonNotFoundException;

public interface AppointmentService {
    public BookingResponseDTO bookAppointment(AppointmentBookingDTO appointmentBookingDTO) throws PersonNotFoundException, DoctorNotFoundException;
}
