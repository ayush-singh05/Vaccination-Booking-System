package com.covidvaccination.covidvaccinationapplication.Service.imp;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.DoseDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoseResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Model.Dose;
import com.covidvaccination.covidvaccinationapplication.Model.Person;
import com.covidvaccination.covidvaccinationapplication.Repository.DoseRepository;
import com.covidvaccination.covidvaccinationapplication.Repository.PersonRepository;
import com.covidvaccination.covidvaccinationapplication.Service.DoseService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoseServiceImp implements DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PersonRepository personRepository;

    public DoseResponseDTO getDoseOne(DoseDTO doseDTO) {
        Dose dose = new Dose();
        dose.setDoseType(doseDTO.getDoseType());
        Person person =  personRepository.findById(doseDTO.getPersonId()).get();
        person.setDose1Taken(true);
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setPerson(person);

        DoseResponseDTO doseResponseDTO = new DoseResponseDTO();
        doseResponseDTO.setMessage("Hey "+person.getName() + " you have successfully complete your "+doseDTO.getDoseType()+ " First Dose");
        person.getDoseTaken().add(dose);
        personRepository.save(person);


        return doseResponseDTO;

    }
    public DoseResponseDTO getSecondDose(DoseDTO doseDTO) {
        Dose dose = new Dose();

        dose.setDoseType(doseDTO.getDoseType());
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        Person person =  personRepository.findById(doseDTO.getPersonId()).get();
        person.setDose2Taken(true);
        person.getDoseTaken().add(dose);
        dose.setPerson(person);
        personRepository.save(person);

        DoseResponseDTO doseResponseDTO = new DoseResponseDTO();
        doseResponseDTO.setMessage("Hey "+person.getName() + " you have successfully complete your all Doses of "+doseDTO.getDoseType());
        return doseResponseDTO;

    }
}
