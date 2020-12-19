package com.aska.development.carrestapi.services.filter;

import com.aska.development.carrestapi.auxiliary.filter.BaseFilterByRequestParam;
import com.aska.development.carrestapi.services.dto.Car;

public abstract class BaseCarFilter extends BaseFilterByRequestParam<Car> {
    public  BaseCarFilter(String requirementParamName) {
        super(requirementParamName);
    }

}
