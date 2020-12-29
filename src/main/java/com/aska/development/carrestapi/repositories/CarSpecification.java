package com.aska.development.carrestapi.repositories;

import com.aska.development.carrestapi.entities.Car;
import com.aska.development.carrestapi.services.CarSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CarSpecification implements Specification<Car> {

    //region Fields

    private CarSearchCriteria mSearchCriteria;

    //endregion

    //region Constructors

    public CarSpecification(CarSearchCriteria searchCriteria) {
        mSearchCriteria = searchCriteria;
    }

    //endregion

    //region Methods

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if(mSearchCriteria.getOperation().equalsIgnoreCase(":")){
            return builder.equal(root.get(mSearchCriteria.getKey()), mSearchCriteria.getValue());
        }
        return null;
    }

    //endregion
}
