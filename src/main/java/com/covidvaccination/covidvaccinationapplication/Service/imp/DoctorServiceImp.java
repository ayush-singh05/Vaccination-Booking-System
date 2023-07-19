package com.covidvaccination.covidvaccinationapplication.Service.imp;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.DoctorDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.CenterResponseDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.DoctorResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Exception.CenterNotFoundException;
import com.covidvaccination.covidvaccinationapplication.Model.Doctor;
import com.covidvaccination.covidvaccinationapplication.Model.VaccinationCenter;
import com.covidvaccination.covidvaccinationapplication.Repository.DoctorRepository;
import com.covidvaccination.covidvaccinationapplication.Repository.VaccinationRepository;
import com.covidvaccination.covidvaccinationapplication.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {
    @Autowired
    VaccinationRepository vaccinationRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public DoctorResponseDTO addDoctor(DoctorDTO doctorDTO) throws CenterNotFoundException {
       VaccinationCenter centerName = vaccinationRepository.findById(doctorDTO.getCenterId()).get();
        if (centerName== null){
            throw new CenterNotFoundException("Invalid Center");
        }
        VaccinationCenter center = centerName;
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setEmail(doctorDTO.getEmailId());
        doctor.setAge(doctorDTO.getAge());
        doctor.setGender(doctorDTO.getGender());
        doctor.setCenter(center);
        center.getDoctors().add(doctor);

        VaccinationCenter savedCenter = vaccinationRepository.save(center);


        List<Doctor> doctors = savedCenter.getDoctors();

        Doctor latestSavedDoctor = doctors.get(doctors.size()-1);

        CenterResponseDTO centerResponseDto = new CenterResponseDTO();
        centerResponseDto.setCenterType(savedCenter.getCenterType());
        centerResponseDto.setAddress(savedCenter.getAddress());
        centerResponseDto.setCenterName(savedCenter.getCenterName());

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setName(doctorDTO.getName());
        doctorResponseDTO.setMessage("Hey you have successfully added !!");
        doctorResponseDTO.setCenterResponseDto(centerResponseDto);

        return doctorResponseDTO;
    }
}
