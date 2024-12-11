package bbdd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bbdd.model.Pasajero;
import bbdd.model.Entretenimiento;
import bbdd.model.Gasto;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        /* ========================= Ej 4a ========================== */
        {
            Pasajero pasajero = new Pasajero("Din Djarin");
            Entretenimiento entretenimiento = new Entretenimiento("Bounty Hunting");
            Gasto gasto = new Gasto(pasajero, entretenimiento, 100);
            session.beginTransaction();
            session.saveOrUpdate(pasajero);
            session.saveOrUpdate(entretenimiento);
            session.saveOrUpdate(gasto);
            session.getTransaction().commit();
        }

        /* ========================= Ej 4b ========================== */
        {
            try (CSVParser parser = new CSVParser(new FileReader(new File("").getAbsolutePath() + "/src/main/resources/gastos.csv"), CSVFormat.DEFAULT.withHeader())) {
                session.beginTransaction();
                for (CSVRecord record : parser) {
                    Pasajero pasajero = new Pasajero(record.get(0));
                    Entretenimiento entretenimiento = new Entretenimiento(record.get(1));
                    Gasto gasto = new Gasto(pasajero, entretenimiento, Integer.parseInt(record.get(2)));
                    session.saveOrUpdate(pasajero);
                    session.saveOrUpdate(entretenimiento);
                    session.saveOrUpdate(gasto);
                }
                session.getTransaction().commit();
            } catch (IOException ignore) {
            }
        }

        session.close();
    }
}





