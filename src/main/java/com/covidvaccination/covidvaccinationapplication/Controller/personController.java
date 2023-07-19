package com.covidvaccination.covidvaccinationapplication.Controller;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.PersonDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.PersonResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Service.imp.personServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class personController {
    @Autowired
    personServiceimp personServiceimp;
    @PostMapping("/add/user")
    public ResponseEntity addPerson(@RequestBody PersonDTO personDTO) throws Exception {

        try{
            PersonResponseDTO personResponseDTO = personServiceimp.addPerson(personDTO);
            return new ResponseEntity(personResponseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }
}
