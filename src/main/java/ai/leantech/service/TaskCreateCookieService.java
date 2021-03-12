package ai.leantech.service;

import ai.leantech.converter.BatchConverter;
import ai.leantech.dto.BatchRequest;
import ai.leantech.dto.BatchResponse;
import ai.leantech.dto.CookieBatchRequest;
import ai.leantech.model.Batch;
import ai.leantech.model.CookieBatch;
import ai.leantech.model.TaskCreateCookie;
import ai.leantech.repository.TaskCreateCookieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@Service
public class TaskCreateCookieService {

    private final BatchConverter batchConverter;
    private final TaskCreateCookieRepository taskRepository;
    private final CookieService cookieService;
    private final BatchService batchService;
    private final CookieBatchService cookieBatchService;

    public TaskCreateCookieService(BatchConverter batchConverter,
                                   TaskCreateCookieRepository taskRepository,
                                   CookieService cookieService,
                                   BatchService batchService,
                                   CookieBatchService cookieBatchService) {
        this.batchConverter = batchConverter;
        this.taskRepository = taskRepository;
        this.cookieService = cookieService;
        this.batchService = batchService;
        this.cookieBatchService = cookieBatchService;
    }

    public BatchResponse addTask(@RequestBody BatchRequest request){
        cookieService.cookiesIsExist(request.getCookies().stream()
                .map(CookieBatchRequest::getCookieId)
                .collect(Collectors.toList()));
        TaskCreateCookie task = new TaskCreateCookie();
        Batch batch = batchService.add(new Batch());
        task.setBatch(batch);
        task.setStatus("NEW");
        task.setCreatedTime(ZonedDateTime.now());
        taskRepository.save(task);
        request.getCookies().stream()
                .map((s) -> getCookieBatch(batch, s))
                .forEach(cookieBatchService::save);
        return batchConverter.convert(batch);
    }

    private CookieBatch getCookieBatch(Batch batch, CookieBatchRequest s) {
        CookieBatch cookieBatch = new CookieBatch();
        cookieBatch.setWeight(s.getWeight());
        cookieBatch.setBatch(batch);
        cookieBatch.setCookie(cookieService.getById(s.getCookieId()));
        return cookieBatch;
    }

    public void getTaskWithStatus(String status){

    }
}
