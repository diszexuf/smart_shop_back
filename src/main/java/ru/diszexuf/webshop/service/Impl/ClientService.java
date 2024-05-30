package ru.diszexuf.webshop.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.diszexuf.webshop.model.Client;
import ru.diszexuf.webshop.repository.IClientRepository;
import ru.diszexuf.webshop.service.IClientService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(String email) {
        clientRepository.deleteClientByEmail(email);
    }
}
