package com.basic.ddi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agency_country_config")
public class AgencyCountryConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id", nullable = false, unique = true)
    private Agency agency;

    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false, length = 20)
    private CountryFormat format;

    public AgencyCountryConfig() {}

    public AgencyCountryConfig(Agency agency, CountryFormat format) {
        this.agency = agency;
        this.format = format;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Agency getAgency() { return agency; }
    public void setAgency(Agency agency) { this.agency = agency; }

    public CountryFormat getFormat() { return format; }
    public void setFormat(CountryFormat format) { this.format = format; }
}
