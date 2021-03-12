package ai.leantech.dto;

import java.time.ZonedDateTime;
import java.util.Date;

public class TaskCreateCookieResponse {
    private long taskId;
    private long cookieId;
    private float weight;
    private ZonedDateTime createdTime;
    private ZonedDateTime updateTime;
    private String status;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getCookieId() {
        return cookieId;
    }

    public void setCookieId(long cookieId) {
        this.cookieId = cookieId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
