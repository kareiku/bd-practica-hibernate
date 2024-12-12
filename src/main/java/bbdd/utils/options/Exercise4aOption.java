package bbdd.utils.options;

import bbdd.model.Entretenimiento;
import bbdd.model.Gasto;
import bbdd.model.Pasajero;
import org.hibernate.Session;

public class Exercise4aOption extends Option {
    public void execute(Session session) {
        Pasajero pasajero = new Pasajero("Din Djarin");
        Entretenimiento entretenimiento = new Entretenimiento("Bounty Hunting");
        Gasto gasto = new Gasto(pasajero, entretenimiento, 100);
        session.save(pasajero);
        session.save(entretenimiento);
        session.save(gasto);
    }
}
