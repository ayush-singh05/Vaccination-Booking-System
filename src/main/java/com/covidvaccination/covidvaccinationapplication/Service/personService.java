package com.covidvaccination.covidvaccinationapplication.Service;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.PersonDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.PersonResponseDTO;

public interface personService {
    public PersonResponseDTO addPerson(PersonDTO persondto) throws Exception;
}
