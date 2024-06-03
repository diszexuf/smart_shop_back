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

        return new SpecificationAggregationDTO(specificationsId, title, values);
    }
}
