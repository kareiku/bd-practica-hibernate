package bbdd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// TODO Realiza todas las anotaciones necesarias en esta clase para que
//      que sus instancias sean guardadas en la base de datos utilizando
//      Hibernate. Respecta las restricciones de modelado impuestas en el
//      enunciado de la práctica. No es necesario modificar el código de esta
//      clase, únicamente debes hacer las anotaciones que consideres
//      necesarías.
public class Pasajero {
    
    private Long id;

    private String nombre;

    private Set<Gasto> gastos = new HashSet<>();

    public Pasajero() {
        // requerido por Hibernate
    }

    public Pasajero(String nombre) {
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
