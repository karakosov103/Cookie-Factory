package ai.leantech.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "test")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="time_create")
    private Date timeCreate;
    @OneToOne(mappedBy = "batch")
    @JsonBackReference
    private TaskCreateCookie taskCreateCookie;
    @OneToMany(mappedBy = "batch")

    private List<CookieBatch> cookieBatchList = new ArrayList<>();

    public List<CookieBatch> getCookieBatchList() {
        return cookieBatchList;
    }

    public void setCookieBatchList(List<CookieBatch> cookieBatchList) {
        this.cookieBatchList = cookieBatchList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public TaskCreateCookie getTaskCreateCookie() {
        return taskCreateCookie;
    }

    public void setTaskCreateCookie(TaskCreateCookie taskCreateCookie) {
        this.taskCreateCookie = taskCreateCookie;
    }

}
