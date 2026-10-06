package com.basic.ddi.repository;

import com.basic.ddi.entity.AgencyCountryConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyCountryConfigRepository extends JpaRepository<AgencyCountryConfig, Long> {
    Optional<AgencyCountryConfig> findByAgencyId(Long agencyId);
}
