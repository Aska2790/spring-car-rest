package com.aska.development.carrestapi.auxiliary.filter;

import java.util.Objects;

public abstract class BaseFilterByRequestParam<I> implements FilterByRequestParam<I> {

    //region Fields

    private String mRequirementParamName;

    //endregion

    //region Constructors

    public  BaseFilterByRequestParam(String requirementParamName) {
        mRequirementParamName = requirementParamName;
        Objects.requireNonNull(mRequirementParamName);
    }

    //endregion

    //region Properties

    @Override
    public String getRequirementParamName() {
        return mRequirementParamName;
    }

    //endregion
}
