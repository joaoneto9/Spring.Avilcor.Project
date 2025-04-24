package com.avilcor.campina.grande.Spring.Avilcor.Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany

    private Client client;
}
