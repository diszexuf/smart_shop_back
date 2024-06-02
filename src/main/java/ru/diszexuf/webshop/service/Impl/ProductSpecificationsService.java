package ru.diszexuf.webshop.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.dto.SpecificationAggregationDTO;
import ru.diszexuf.webshop.converter.SpecificationAggregationConverter;
import ru.diszexuf.webshop.repository.IProductSpecificationsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductSpecificationsService {

    private IProductSpecificationsRepository productSpecificationsRepository;

    private SpecificationAggregationConverter specificationAggregationConverter;

    public List<SpecificationAggregationDTO> getSpecificationsAggregationByCategoryId(Long categoryId) {
        List<Object[]> results = productSpecificationsRepository.findSpecificationsAggregationByCategoryId(categoryId);

        return results.stream()
                .map(specificationAggregationConverter::convert)
                .collect(Collectors.toList());
    }

}