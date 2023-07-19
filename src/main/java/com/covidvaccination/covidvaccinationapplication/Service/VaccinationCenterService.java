package com.covidvaccination.covidvaccinationapplication.Service;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.CenterDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.CenterResponseDTO;

public interface VaccinationCenterService {
    public CenterResponseDTO addCenter(CenterDTO centerDTO);
}
