package com.avilcor.campina.grande.Spring.Avilcor.Project.Config;

import com.avilcor.campina.grande.Spring.Avilcor.Project.model.Client;
import com.avilcor.campina.grande.Spring.Avilcor.Project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration // determina que euma classe de configuracao
@Profile("test") // setermina que e apenas teste
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client(null, "Maria Oliveira", "maria.oliveira@example.com");
        Client client2 = new Client(null, "João Santos", "joao.santos@example.com");
        Client client3 = new Client(null, "Ana Lima", "ana.lima@example.com");

        clientRepository.saveAll(List.of(client1, client2, client3));
    }
}
