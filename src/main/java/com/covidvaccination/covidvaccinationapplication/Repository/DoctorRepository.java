package com.covidvaccination.covidvaccinationapplication.Repository;

import com.covidvaccination.covidvaccinationapplication.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
