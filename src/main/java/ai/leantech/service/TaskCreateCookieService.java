package ai.leantech.service;

import ai.leantech.converter.CookieBatchToEntityConverter;
import ai.leantech.converter.TaskCreateCookieConverter;
import ai.leantech.dto.BatchRequest;
import ai.leantech.dto.CookieBatchRequest;
import ai.leantech.model.Batch;
import ai.leantech.model.CookieBatch;
import ai.leantech.model.TaskCreateCookie;
import ai.leantech.repository.CookieBatchRepository;
import ai.leantech.repository.TaskCreateCookieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collectors;

@Service
public class ServiceTaskCreateCookie {
    private final TaskCreateCookieConverter converter;
    private final TaskCreateCookieRepository taskRepository;
    private final ServiceCookie serviceCookie;
    private final ServiceBatch serviceBatch;
    private final S
    private final CookieBatchToEntityConverter cookieBatchToEntityConverter;
    private final CookieBatchRepository cookieBatchRepository;

    public ServiceTaskCreateCookie(TaskCreateCookieConverter converter, TaskCreateCookieRepository taskRepository, ServiceCookie serviceCookie, ServiceBatch serviceBatch, CookieBatchToEntityConverter cookieBatchToEntityConverter, CookieBatchRepository cookieBatchRepository) {
        this.converter = converter;
        this.taskRepository = taskRepository;
        this.serviceCookie = serviceCookie;
        this.serviceBatch = serviceBatch;
        this.cookieBatchToEntityConverter = cookieBatchToEntityConverter;
        this.cookieBatchRepository = cookieBatchRepository;
    }

    public void add(@RequestBody BatchRequest request){
        for(CookieBatchRequest cookie: request.getCookies()){
            serviceCookie.getById(cookie.getCookieId());
        }
        TaskCreateCookie task = new TaskCreateCookie();
        Batch batch = serviceBatch.add(new Batch());
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
                .forEach(cookieBatchRepository::save);
        //converter.convert(taskRepository.save(task));
    }
}
