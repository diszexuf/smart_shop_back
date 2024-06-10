package ru.diszexuf.webshop.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.exception.ResourceNotFoundException;
import ru.diszexuf.webshop.model.Category;
import ru.diszexuf.webshop.repository.CategoryRepository;
import ru.diszexuf.webshop.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setTitle(category.getTitle());
            return categoryRepository.save(existingCategory);
        } else {
            throw new ResourceNotFoundException("Category not found with id " + id);
        }
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
