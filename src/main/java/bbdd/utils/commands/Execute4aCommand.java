package bbdd.utils.commands;

import bbdd.model.Entretenimiento;
import bbdd.model.Gasto;
import bbdd.model.Pasajero;
import org.hibernate.Session;

public class Execute4aCommand implements Command {
    public void execute(Session session) {
        Pasajero pasajero = new Pasajero("Din Djarin");
        Entretenimiento entretenimiento = new Entretenimiento("Bounty Hunting");
        Gasto gasto = new Gasto(pasajero, entretenimiento, 100);
        session.beginTransaction();
        session.saveOrUpdate(pasajero);
        session.saveOrUpdate(entretenimiento);
        session.saveOrUpdate(gasto);
        session.getTransaction().commit();
    }
}
