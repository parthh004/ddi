package com.basic.ddi.service;

import com.basic.ddi.dto.CountryResolveRequest;
import com.basic.ddi.dto.CountryResolveResponse;
import com.basic.ddi.entity.AgencyCountryConfig;
import com.basic.ddi.entity.CountryMaster;
import com.basic.ddi.repository.AgencyCountryConfigRepository;
import com.basic.ddi.repository.CountryMasterRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryResolverService {

    private final CountryMasterRepository countryMasterRepository;
    private final AgencyCountryConfigRepository agencyConfigRepository;

    public CountryResolverService(CountryMasterRepository countryMasterRepository,
                                  AgencyCountryConfigRepository agencyConfigRepository) {
        this.countryMasterRepository = countryMasterRepository;
        this.agencyConfigRepository = agencyConfigRepository;
    }

    public CountryResolveResponse resolveCountryForAgency(CountryResolveRequest request) {
        AgencyCountryConfig config = getAgencyConfig(request.getAgencyId());
        CountryMaster country = getCountryMaster(request.getNumericCode());

        String resolvedValue = switch (config.getFormat()) {
            case ISO2 -> country.getIso2();
            case ISO3 -> country.getIso3();
            case FULL_NAME -> country.getFullName();
        };

        return new CountryResolveResponse(
                request.getAgencyId(),
                request.getNumericCode(),
                resolvedValue,
                config.getFormat()
        );
    }

    public AgencyCountryConfig getAgencyConfig(Long agencyId) {
        return agencyConfigRepository.findByAgencyId(agencyId)
                .orElseThrow(() -> new IllegalArgumentException("No country format configuration found for agency ID: " + agencyId));
    }

    public CountryMaster getCountryMaster(String numericCode) {
        return countryMasterRepository.findByNumericCode(numericCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country code: " + numericCode));
    }
}
