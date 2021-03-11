package ai.leantech.service;

import ai.leantech.converter.CookieConverter;
import ai.leantech.dto.CookieRequest;
import ai.leantech.dto.CookieResponse;
import ai.leantech.model.Cookie;
import ai.leantech.repository.CookieRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CookieService {
    private final CookieRepository repository;
    private final CookieConverter cookieConverter;

    public CookieService(CookieRepository repository, CookieConverter cookieConverter) {
        this.repository = repository;
        this.cookieConverter = cookieConverter;
    }

    public CookieResponse addCookie(CookieRequest request){
        Cookie cookie = new Cookie();
        cookie.setName(request.getName());
        cookie.setManufacturer(request.getManufacturer());
        cookie.setBarcode(request.getBarcode());
        cookie.setCost(request.getCost());
        cookie.setCalories(request.getCalories());
        cookie.setIngredients(request.getIngredients());
        cookie.setStorage(request.getStorage());
        return cookieConverter.convert(repository.save(cookie));
    }

    public Cookie getById(Long id){
        return repository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException(String.format("Cookie with id %s not exists", id)));
    }
}
