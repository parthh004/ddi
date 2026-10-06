package com.basic.ddi.dto;

public class CountryResolveRequest {

    private Long agencyId;
    private String numericCode;

    public CountryResolveRequest() {}

    public CountryResolveRequest(Long agencyId, String numericCode) {
        this.agencyId = agencyId;
        this.numericCode = numericCode;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }
}
