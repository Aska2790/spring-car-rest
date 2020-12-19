package com.aska.development.carrestapi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CarEntity {
    //region Fields

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "manufacture")
    private String manufacture;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "country")
    private String country;

    @Temporal(TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate;

    //endregion

    //region Properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //endregion

}
