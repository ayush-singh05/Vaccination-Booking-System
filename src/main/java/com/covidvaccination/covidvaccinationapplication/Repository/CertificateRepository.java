package com.covidvaccination.covidvaccinationapplication.Repository;

import com.covidvaccination.covidvaccinationapplication.Model.Certificate;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
}
