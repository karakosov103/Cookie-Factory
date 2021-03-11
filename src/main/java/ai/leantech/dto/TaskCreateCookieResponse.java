package ai.leantech.dto;

import java.util.Date;

public class TaskCreateCookieResponse {
    private long taskId;
    private long cookieId;
    private float weight;
    private Date createdTime;
    private Date updateTime;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
