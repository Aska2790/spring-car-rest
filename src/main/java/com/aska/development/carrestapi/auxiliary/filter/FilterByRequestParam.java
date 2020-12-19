package com.aska.development.carrestapi.auxiliary.filter;

public interface FilterByRequestParam<I> {

    String getRequirementParamName();

    boolean test(I item, String param);
}
