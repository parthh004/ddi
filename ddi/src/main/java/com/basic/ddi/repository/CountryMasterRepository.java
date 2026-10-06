package com.basic.ddi.repository;

import com.basic.ddi.entity.CountryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster, Long> {
    Optional<CountryMaster> findByNumericCode(String numericCode);
}
