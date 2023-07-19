package com.covidvaccination.covidvaccinationapplication.Service;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.DoseDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoseResponseDTO;

public interface DoseService {
    public DoseResponseDTO getDoseOne(DoseDTO doseDTO);
    public DoseResponseDTO getSecondDose(DoseDTO doseDTO);
}

