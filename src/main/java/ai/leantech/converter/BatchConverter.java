package ai.leantech.converter;

import ai.leantech.dto.BatchResponse;
import ai.leantech.model.Batch;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BatchConverter implements Converter<Batch, BatchResponse> {
    @Override
    public BatchResponse convert(Batch batch) {
        BatchResponse response = new BatchResponse();
        response.setId(batch.getId());
        return response;
    }
}
