package bbdd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entretenimientos")
public class Entretenimiento {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private final Set<Gasto> gastos = new HashSet<>();

    public Entretenimiento() {
    }

    public Entretenimiento(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Gasto> getGastos() {
        return gastos;
    }
}
