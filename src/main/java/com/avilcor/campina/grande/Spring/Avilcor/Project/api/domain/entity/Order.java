package com.avilcor.campina.grande.Spring.Avilcor.Project.api.domain.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int DAYS_FOR_ORDER = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany // revisar
    @JoinTable(
            name = "tb_order_activity", // nome da tabela de junção
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private List<Activity> services;

    private BigDecimal valorTotal;

    private Instant dateBegin;
    private Instant dateFinish;

    public Order() {
        this.dateBegin = Instant.now();
        this.dateFinish = dateBegin.plus(10, ChronoUnit.DAYS); // determina que e 10 dias depois do pedido
    }

    public Order(Long id, Client client, List<Activity> services, BigDecimal valorTotal) {
        this.client = client;
        this.id = id;
        this.services = services;
        this.valorTotal = valorTotal;
        this.dateBegin = Instant.now();
        this.dateFinish = dateBegin.plus(10, ChronoUnit.DAYS); // determina que e 10 dias depois do pedido
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Activity> getServices() {
        return services;
    }

    public void setServices(List<Activity> services) {
        this.services = services;
    }

    public void addActivity(Activity activity) {
        this.services.add(activity); // nao fazer verificacao se contem ou nao, ele pode fazer quantos ajustes quiser da mesma forma.
        this.valorTotal = this.valorTotal.add(activity.getPreco()); // exemplo: ele pode ajustar duas calcas. MESMA ATIVIDADE...
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Instant getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Instant dateBegin) {
        this.dateBegin = dateBegin;
        setDateFinish(dateBegin);
    }

    public Instant getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Instant dateBegin) {
        this.dateFinish = dateBegin.plus(10, ChronoUnit.DAYS);
    }
}
