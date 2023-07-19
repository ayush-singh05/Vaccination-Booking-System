package com.covidvaccination.covidvaccinationapplication.Service;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.DoctorDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoctorResponseDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoseResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Exception.CenterNotFoundException;
import org.springframework.stereotype.Service;


public interface DoctorService {
    public DoctorResponseDTO addDoctor(DoctorDTO doctorDTO) throws CenterNotFoundException;
}
