package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.Specifications;

public interface SpecificationsRepository extends JpaRepository<Specifications, Long> {
    Specifications findByTitle(String name);
}
