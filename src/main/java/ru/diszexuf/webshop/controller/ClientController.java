package ru.diszexuf.webshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.diszexuf.webshop.model.Client;
import ru.diszexuf.webshop.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class ClientController {

    private final IClientService userService;

    @PostMapping("save_user")
    public Client saveProduct(@RequestBody Client client) {
        return userService.saveClient(client);
    }

    @GetMapping("/{email}")
    public Client findByName(@PathVariable String email) {
        return userService.findClientByEmail(email);
    }

    @PutMapping("update_user")
    public Client updateProduct(Client client) {
        return userService.updateClient(client);
    }

    @DeleteMapping("delete_product/{email}")
    public void deleteProduct(@PathVariable String email) {
        userService.deleteClient(email);
    }

    @GetMapping("/all")
    public List<Client> findAllProducts() {
        return userService.findAllClients();
    }
}
