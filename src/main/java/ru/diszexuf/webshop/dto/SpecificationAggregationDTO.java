package ru.diszexuf.webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SpecificationAggregationDTO {
    private Long specificationsId;
    private String title;
    private List<String> values;

}
