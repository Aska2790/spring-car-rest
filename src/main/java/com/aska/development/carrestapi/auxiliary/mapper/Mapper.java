package com.aska.development.carrestapi.auxiliary.mapper;

public interface Mapper<S, D> {
    D map(S sourceItem);
}
