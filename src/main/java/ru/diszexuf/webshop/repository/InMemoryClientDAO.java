package ru.diszexuf.webshop.repository;

import org.springframework.stereotype.Repository;
import ru.diszexuf.webshop.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryClientDAO {
    private final List<Client> Clients = new ArrayList<Client>();

    public List<Client> findAllUsers() {
        return Clients;
    }

    public Client saveUser(Client client) {
        Clients.add(client);
        return client;
    }

    public Client findByEmail(String email) {
        return Clients.stream().filter(elem -> elem.getEmail().
                equals(email)).findFirst().orElse(null);
    }

    public Client updateUser(Client client) {
        var userIndex = IntStream.range(0, Clients.size()).
                filter(elem -> Clients.get(elem).getEmail().
                        equals(client.getEmail())).
                findFirst().orElse(-1);
        if (userIndex != -1) {
            Clients.set(userIndex, client);
        }
        return null;
    }

    public void deleteUser(String email) {
        var user = findByEmail(email);
        if (user != null) {
            Clients.remove(user);
        }
    }
}
