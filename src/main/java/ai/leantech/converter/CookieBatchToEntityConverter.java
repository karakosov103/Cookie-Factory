package ai.leantech.converter;

import ai.leantech.dto.CookieBatchRequest;
import ai.leantech.model.CookieBatch;
import ai.leantech.service.CookieService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CookieBatchToEntityConverter implements Converter<CookieBatchRequest, CookieBatch> {
    private final CookieService cookieService;

    public CookieBatchToEntityConverter(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @Override
    public CookieBatch convert(CookieBatchRequest request) {
        CookieBatch cookieBatch = new CookieBatch();
        cookieBatch.setWeight(request.getWeight());
        cookieBatch.setCookie(cookieService.getById(request.getCookieId()));
        return cookieBatch;
    }
}
