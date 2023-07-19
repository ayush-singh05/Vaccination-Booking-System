package com.covidvaccination.covidvaccinationapplication.Service.imp;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.CenterDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.CenterResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Model.VaccinationCenter;
import com.covidvaccination.covidvaccinationapplication.Repository.VaccinationRepository;
import com.covidvaccination.covidvaccinationapplication.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImp implements VaccinationCenterService {
    @Autowired
    VaccinationRepository vaccinationRepository;
    @Override
    public CenterResponseDTO addCenter(CenterDTO centerDTO) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setCenterName(centerDTO.getCenterName());
        vaccinationCenter.setCenterType(centerDTO.getCenterType());
        vaccinationCenter.setAddress(centerDTO.getAddress());

        VaccinationCenter saveCenter = vaccinationRepository.save(vaccinationCenter);
        CenterResponseDTO centerResponseDTO = new CenterResponseDTO();
        centerResponseDTO.setCenterName(saveCenter.getCenterName());
        centerResponseDTO.setAddress(saveCenter.getAddress());
        centerResponseDTO.setCenterType(saveCenter.getCenterType());
        return centerResponseDTO;
    }
}
