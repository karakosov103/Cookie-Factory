package ai.leantech.repository;

import ai.leantech.model.TaskCreateCookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCreateCookieRepository extends JpaRepository<TaskCreateCookie,Long> {
}
