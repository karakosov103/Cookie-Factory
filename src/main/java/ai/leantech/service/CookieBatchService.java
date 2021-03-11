package ai.leantech.service;

import ai.leantech.model.CookieBatch;
import ai.leantech.repository.CookieBatchRepository;
import org.springframework.stereotype.Service;

@Service
public class CookieBatchService {
    private final CookieBatchRepository cookieBatchRepository;

    public CookieBatchService(CookieBatchRepository cookieBatchRepository) {
        this.cookieBatchRepository = cookieBatchRepository;
    }

    public CookieBatch save(CookieBatch cookieBatch){
        return cookieBatchRepository.save(cookieBatch);
    }
}
