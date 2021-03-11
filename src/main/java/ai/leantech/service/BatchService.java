package ai.leantech.service;

import ai.leantech.model.Batch;
import ai.leantech.repository.BatchRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceBatch {
    private final BatchRepository batchRepository;

    public ServiceBatch(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public Batch add(Batch batch){
        return batchRepository.save(batch);
    }


}