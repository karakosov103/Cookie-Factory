package ai.leantech.converter;

import ai.leantech.dto.CookieResponse;
import ai.leantech.model.Cookie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CookieConverter implements Converter<Cookie, CookieResponse> {
    @Override
    public CookieResponse convert(Cookie cookie) {
        CookieResponse cookieResponse = new CookieResponse();
        cookieResponse.setId(cookie.getId());
        cookieResponse.setName(cookie.getName());
        cookieResponse.setManufacturer(cookie.getManufacturer());
        cookieResponse.setBarcode(cookie.getBarcode());
        cookieResponse.setCost(cookie.getCost());
        cookieResponse.setCalories(cookie.getCalories());
        cookieResponse.setIngredients(cookie.getIngredients());
        cookieResponse.setStorage(cookie.getStorage());
        return cookieResponse;
    }
}
