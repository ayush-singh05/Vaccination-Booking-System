package com.covidvaccination.covidvaccinationapplication.Repository;

import com.covidvaccination.covidvaccinationapplication.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
