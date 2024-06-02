package ru.diszexuf.webshop.converter;

import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;
import ru.diszexuf.webshop.dto.SpecificationAggregationDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecificationAggregationConverter {

    public SpecificationAggregationDTO convert(Object[] dbData) {
        if (dbData == null) {
            return null;
        }

        Long specificationsId = ((Number) dbData[0]).longValue();
        String title = (String) dbData[1];
        List<String> values = Arrays.asList((String[]) dbData[2]);
        List<Long> productIds = Arrays.stream((Object[]) dbData[3])
                .map(id -> ((Number) id).longValue())
                .collect(Collectors.toList());

        return new SpecificationAggregationDTO(specificationsId, title, values, productIds);
    }
}
