package com.aska.development.carrestapi.services.filter;

import com.aska.development.carrestapi.services.dto.Car;
import org.springframework.stereotype.Component;

@Component
public class CarIdParamFilter extends BaseCarFilter {

    public CarIdParamFilter() {
        super("id");
    }

    public boolean test(Car item, String param) {
        if (param != null) {
            try {
                int id = Integer.parseInt(param);
                return id == item.getId();
            } catch (Exception ignore) {}
        }
        return false;

    }

}
