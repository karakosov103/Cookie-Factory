package ai.leantech.repository;

import ai.leantech.model.CookieBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieBatchRepository extends JpaRepository<CookieBatch, Long> {
}
