package com.covidvaccination.covidvaccinationapplication.Repository;

import com.covidvaccination.covidvaccinationapplication.Model.Dose;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
