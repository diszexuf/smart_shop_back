package ru.diszexuf.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.dto.SpecificationAggregationDTO;
import ru.diszexuf.webshop.service.Impl.ProductSpecificationsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-specifications")
public class ProductSpecificationsController {

//    @Autowired
//    private ProductSpecificationsService productSpecificationsService;
//
//    @GetMapping("/filters_{categoryId}")
//    public List<SpecificationAggregationDTO> getSpecificationsAggregationByCategoryId(@PathVariable Long categoryId) {
//        return productSpecificationsService.getSpecificationsAggregationByCategoryId(categoryId);
//    }
}
