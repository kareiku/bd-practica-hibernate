package bbdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gastos")
public class Gasto {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "id_entretenimiento", nullable = false)
    private Entretenimiento entretenimiento;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Gasto() {
    }

    public Gasto(Pasajero pasajero, Entretenimiento entretenimiento, Integer cantidad) {
        this.pasajero = pasajero;
        this.entretenimiento = entretenimiento;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Entretenimiento getEntretenimiento() {
        return entretenimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
