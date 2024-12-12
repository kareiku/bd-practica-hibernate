package bbdd.utils.options;

import bbdd.model.Entretenimiento;
import bbdd.model.Gasto;
import bbdd.model.Pasajero;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise4bOption extends Option {
    public void execute(Session session) {
        try (CSVParser parser = new CSVParser(new FileReader(new File("").getAbsolutePath() + "/src/main/resources/gastos.csv"), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : parser) {
                Pasajero pasajero = new Pasajero(record.get(0));
                Entretenimiento entretenimiento = new Entretenimiento(record.get(1));
                Gasto gasto = new Gasto(pasajero, entretenimiento, Integer.parseInt(record.get(2)));
                session.save(pasajero);
                session.save(entretenimiento);
                session.save(gasto);
            }
        } catch (IOException ex) {
            assert false : ex.getMessage();
        }
    }
}
