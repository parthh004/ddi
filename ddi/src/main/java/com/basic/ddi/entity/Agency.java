package com.basic.ddi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agency")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agency_name", nullable = false, length = 100)
    private String agencyName;

    @OneToOne(mappedBy = "agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AgencyCountryConfig countryConfig;

    public Agency() {}

    public Agency(String agencyName) {
        this.agencyName = agencyName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAgencyName() { return agencyName; }
    public void setAgencyName(String agencyName) { this.agencyName = agencyName; }

    public AgencyCountryConfig getCountryConfig() { return countryConfig; }
    public void setCountryConfig(AgencyCountryConfig countryConfig) { this.countryConfig = countryConfig; }
}