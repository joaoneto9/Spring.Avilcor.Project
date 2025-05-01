package com.avilcor.campina.grande.Spring.Avilcor.Project.api.config;

import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Roupa;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Activity;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Client;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity.Order;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.ActivityRepository;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.ClientRepository;
import com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@Configuration // determina que euma classe de configuracao
@Profile("test") // setermina que e apenas teste
public class TestConfig implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clientes
        Client client1 = new Client(null, "Maria Oliveira", "maria.oliveira@example.com");
        Client client2 = new Client(null, "João Santos", "joao.santos@example.com");
        Client client3 = new Client(null, "Ana Lima", "ana.lima@example.com");
        clientRepository.saveAll(List.of(client1, client2, client3));

        // Atividades
        Object Trabalho;
        Activity activity1 = new Activity(null, new BigDecimal("50.00"), Roupa.CAMISA, com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Trabalho.BARRA);
        Activity activity2 = new Activity(null, new BigDecimal("80.00"), Roupa.CALCA, com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Trabalho.AJUSTE);
        Activity activity3 = new Activity(null, new BigDecimal("100.00"), Roupa.VESTIDO, com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.enums.Trabalho.BORDADO);
        activityRepository.saveAll(List.of(activity1, activity2, activity3));

        Order order1 = new Order(null, client1, List.of(activity1, activity2), new BigDecimal("130.00"));
        Order order2 = new Order(null, client2, List.of(activity3), new BigDecimal("100.00"));
        Order order3 = new Order(null, client2, List.of(activity3), new BigDecimal("100.00"));
        order3.setStatusOrderEntregue(); // unico que tem status de Entregue para poder finalizar

        orderRepository.saveAll(List.of(order1, order2, order3));
    }
}
