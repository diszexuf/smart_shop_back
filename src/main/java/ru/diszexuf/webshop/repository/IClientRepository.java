package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
    void deleteClientByEmail(String email);
    Client findClientByEmail(String email);
}
