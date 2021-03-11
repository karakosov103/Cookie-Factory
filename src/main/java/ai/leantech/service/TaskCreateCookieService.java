package ai.leantech.service;

import ai.leantech.converter.BatchConverter;
import ai.leantech.converter.CookieBatchToEntityConverter;
import ai.leantech.dto.BatchRequest;
import ai.leantech.dto.BatchResponse;
import ai.leantech.dto.CookieBatchRequest;
import ai.leantech.model.Batch;
import ai.leantech.model.CookieBatch;
import ai.leantech.model.TaskCreateCookie;
import ai.leantech.repository.TaskCreateCookieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskCreateCookieService {
    private final BatchConverter batchConverter;
    private final TaskCreateCookieRepository taskRepository;
    private final CookieService cookieService;
    private final BatchService batchService;
    private final CookieBatchService cookieBatchService;
    private final CookieBatchToEntityConverter cookieBatchToEntityConverter;


    public TaskCreateCookieService(BatchConverter batchConverter, TaskCreateCookieRepository taskRepository, CookieService cookieService, BatchService batchService, CookieBatchService cookieBatchService, CookieBatchToEntityConverter cookieBatchToEntityConverter) {
        this.batchConverter = batchConverter;
        this.taskRepository = taskRepository;
        this.cookieService = cookieService;
        this.batchService = batchService;
        this.cookieBatchService = cookieBatchService;
        this.cookieBatchToEntityConverter = cookieBatchToEntityConverter;
    }

    public BatchResponse add(@RequestBody BatchRequest request){
        for(CookieBatchRequest cookie: request.getCookies()){
            cookieService.getById(cookie.getCookieId());
        }
        TaskCreateCookie task = new TaskCreateCookie();
        Batch batch = batchService.add(new Batch());
        task.setBatch(batch);
        taskRepository.save(task);

        request.getCookies().stream()
                .map(cookieBatchToEntityConverter::convert)
                .map((s) -> {
                    CookieBatch cookieBatch1 = new CookieBatch();
                    cookieBatch1.setWeight(s.getWeight());
                    cookieBatch1.setBatch(batch);
                    cookieBatch1.setCookie(s.getCookie());
                    return cookieBatch1;
                })
                .forEach(cookieBatchService::save);
        return batchConverter.convert(batch);
    }
}
