package ru.diszexuf.webshop.service;

import ru.diszexuf.webshop.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> findAllClients();
    Client saveClient(Client client);
    Client findClientByEmail(String emauk);
    Client updateClient(Client client);
    void deleteClient(String email);
}
