package com.basic.ddi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country_master")
public class CountryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeric_code", nullable = false, unique = true, length = 10)
    private String numericCode;

    @Column(name = "iso2", nullable = false, length = 2)
    private String iso2;

    @Column(name = "iso3", nullable = false, length = 3)
    private String iso3;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    public CountryMaster() {}

    public CountryMaster(String numericCode, String iso2, String iso3, String fullName) {
        this.numericCode = numericCode;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.fullName = fullName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumericCode() { return numericCode; }
    public void setNumericCode(String numericCode) { this.numericCode = numericCode; }

    public String getIso2() { return iso2; }
    public void setIso2(String iso2) { this.iso2 = iso2; }

    public String getIso3() { return iso3; }
    public void setIso3(String iso3) { this.iso3 = iso3; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}