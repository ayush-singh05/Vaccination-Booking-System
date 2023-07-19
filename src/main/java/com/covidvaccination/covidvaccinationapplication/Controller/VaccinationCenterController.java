package com.covidvaccination.covidvaccinationapplication.Controller;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.CenterDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.CenterResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/add")
public class VaccinationCenterController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/center")
    public ResponseEntity addCenter(@RequestBody CenterDTO centerDTO) {
        try{
            CenterResponseDTO centerResponseDTO = vaccinationCenterService.addCenter(centerDTO);
            return new ResponseEntity(centerResponseDTO,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
