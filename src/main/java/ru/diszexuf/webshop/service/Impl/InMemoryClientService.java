package ru.diszexuf.webshop.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.Client;
import ru.diszexuf.webshop.repository.InMemoryClientDAO;
import ru.diszexuf.webshop.service.IClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryClientService implements IClientService {
    private final InMemoryClientDAO inMemoryClientDAO;

    @Override
    public List<Client> findAllClients() {
        return inMemoryClientDAO.findAllUsers();
    }

    @Override
    public Client saveClient(Client client) {
        return inMemoryClientDAO.saveUser(client);
    }

    @Override
    public Client findClientByEmail(String email) {
        return inMemoryClientDAO.findByEmail(email);
    }

    @Override
    public Client updateClient(Client client) {
        return inMemoryClientDAO.updateUser(client);
    }

    @Override
    public void deleteClient(String email) {
        inMemoryClientDAO.deleteUser(email);
    }
}
