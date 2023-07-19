package com.covidvaccination.covidvaccinationapplication.Controller;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.DoctorDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoctorResponseDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoseResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/add")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/doctor")
    public ResponseEntity addDoctor(@RequestBody DoctorDTO doctorDTO) throws Exception{
        try{
            DoctorResponseDTO doctorResponseDTO = doctorService.addDoctor(doctorDTO);
            return new ResponseEntity<>(doctorResponseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
