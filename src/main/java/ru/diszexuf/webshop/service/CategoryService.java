package ru.diszexuf.webshop.service;

import ru.diszexuf.webshop.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category saveCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategoryById(Long id);
}
