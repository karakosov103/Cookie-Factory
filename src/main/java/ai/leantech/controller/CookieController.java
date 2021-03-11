package ai.leantech.controller;

import ai.leantech.dto.BatchRequest;
import ai.leantech.dto.BatchResponse;
import ai.leantech.dto.CookieRequest;
import ai.leantech.dto.CookieResponse;
import ai.leantech.service.CookieService;
import ai.leantech.service.TaskCreateCookieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cookies")
public class CookieController {
    public final CookieService cookieService;
    public final TaskCreateCookieService taskCreateCookieService;

    public CookieController(CookieService cookieService, TaskCreateCookieService taskCreateCookieService) {
        this.cookieService = cookieService;
        this.taskCreateCookieService = taskCreateCookieService;
    }

    @PostMapping
    public CookieResponse addCookie(@RequestBody CookieRequest request){
        return cookieService.addCookie(request);
    }

    @PutMapping
    public BatchResponse addTaskCreateCookie(@RequestBody BatchRequest request){
        return taskCreateCookieService.add(request);
    }
}
