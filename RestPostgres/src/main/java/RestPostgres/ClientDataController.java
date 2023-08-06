package RestPostgres;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/db")
public class ClientDataController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientDataController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{username}")
    public Flux<Client> getClient(@PathVariable @NotNull String username) {
        return Flux.just(clientRepository.getClientByUsername(username));
    }
}