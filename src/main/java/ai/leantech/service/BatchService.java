package ai.leantech.service;

import ai.leantech.model.Batch;
import ai.leantech.repository.BatchRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class BatchService {
    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public Batch add(Batch batch){
        batch.setCreatedTime(ZonedDateTime.now());
        return batchRepository.save(batch);
    }

}
