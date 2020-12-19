package com.aska.development.carrestapi.services.dto;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    //region Fields

    private Long id;
    private String manufacture;
    private String model;
    private String type;
    private String country;
    private Date createDate;

    //endregion

    //region Properties

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public String getManufacture() {
        return manufacture;
    }

    public Car setManufacture(String manufacture) {
        this.manufacture = manufacture;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getType() {
        return type;
    }

    public Car setType(String type) {
        this.type = type;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Car setCountry(String country) {
        this.country = country;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Car setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }


    //endregion

}
