package com.basic.ddi.controller;

import com.basic.ddi.dto.CountryResolveRequest;
import com.basic.ddi.dto.CountryResolveResponse;
import com.basic.ddi.service.CountryResolverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryResolverService countryResolverService;

    public CountryController(CountryResolverService countryResolverService) {
        this.countryResolverService = countryResolverService;
    }

    @GetMapping("/resolve")
    public ResponseEntity<CountryResolveResponse> resolveByParams(
            @RequestParam Long agencyId,
            @RequestParam String numericCode) {

        CountryResolveRequest request = new CountryResolveRequest(agencyId, numericCode);
        CountryResolveResponse response = countryResolverService.resolveCountryForAgency(request);
        return ResponseEntity.ok(response);
    }

}