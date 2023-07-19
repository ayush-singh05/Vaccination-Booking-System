package com.covidvaccination.covidvaccinationapplication.Repository;


import com.covidvaccination.covidvaccinationapplication.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<VaccinationCenter,Integer> {
}
