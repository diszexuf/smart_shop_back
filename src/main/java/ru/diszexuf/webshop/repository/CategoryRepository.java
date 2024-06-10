package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    void deleteCategoryById(Long id);
}
