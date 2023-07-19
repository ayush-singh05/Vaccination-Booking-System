package com.covidvaccination.covidvaccinationapplication.Service.imp;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.PersonDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.PersonResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Exception.EmailAlreadyExits;
import com.covidvaccination.covidvaccinationapplication.Exception.InvalidAgeException;
import com.covidvaccination.covidvaccinationapplication.Model.Person;
import com.covidvaccination.covidvaccinationapplication.Repository.PersonRepository;
import com.covidvaccination.covidvaccinationapplication.Service.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class personServiceimp implements personService {
    @Autowired
    PersonRepository personRepository;
    public PersonResponseDTO addPerson(PersonDTO persondto) throws Exception {
        // check for existing details
        if(personRepository.findByEmail(persondto.getEmail()) != null) {
            throw new EmailAlreadyExits("Email Already Exists");
        }
        if(persondto.getAge() < 18 || persondto.getAge() > 60) {
            throw new InvalidAgeException("Age Should be in between 18 and 60");
        }
        Person person = new Person();
        person.setName(persondto.getName());
        person.setAge(persondto.getAge());
        person.setEmail(persondto.getEmail());
        person.setGender(persondto.getGender());
        personRepository.save(person);
        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setName(persondto.getName());
        personResponseDTO.setMessage("You have successfully register !");

        return personResponseDTO;
    }
}
