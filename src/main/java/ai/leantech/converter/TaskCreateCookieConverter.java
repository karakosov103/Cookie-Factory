package ai.leantech.converter;

import ai.leantech.dto.TaskCreateCookieResponse;
import ai.leantech.model.TaskCreateCookie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskCreateCookieConverter implements Converter<TaskCreateCookie, TaskCreateCookieResponse> {

    @Override
    public TaskCreateCookieResponse convert(TaskCreateCookie taskCreateCookie) {
        TaskCreateCookieResponse response = new TaskCreateCookieResponse();
        response.setTaskId(taskCreateCookie.getTaskId());
        response.setCreatedTime(taskCreateCookie.getCreatedTime());
        response.setWeight(taskCreateCookie.getWeight());
        response.setUpdateTime(taskCreateCookie.getUpdateTime());
        response.setStatus(taskCreateCookie.getStatus());
        return response;
    }
}
