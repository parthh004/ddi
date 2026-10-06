package com.basic.ddi.dto;

import com.basic.ddi.entity.CountryFormat;

public class CountryResolveResponse {

    private Long agencyId;
    private String numericCode;
    private String formattedValue;
    private CountryFormat formatApplied;

    public CountryResolveResponse() {}

    public CountryResolveResponse(Long agencyId, String numericCode, String formattedValue, CountryFormat formatApplied) {
        this.agencyId = agencyId;
        this.numericCode = numericCode;
        this.formattedValue = formattedValue;
        this.formatApplied = formatApplied;
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

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public CountryFormat getFormatApplied() {
        return formatApplied;
    }

    public void setFormatApplied(CountryFormat formatApplied) {
        this.formatApplied = formatApplied;
    }
}
