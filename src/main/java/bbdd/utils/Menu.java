package bbdd.utils;

import bbdd.utils.options.*;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Session session;
    private final Map<Character, Option> commands;

    public Menu(Session session) {
        this.session = session;
        this.commands = new HashMap<>();
        Option[] options = {
                new Exercise4aOption(),
                new Exercise4bOption(),
                new DeletePasajeroOption(),
                new DeleteEntretenimientoOption(),
                new UpdatePasajeroOption(),
                new UpdateEntretenimientoOption()
        };
        for (int i = 1; i < options.length; i++) {
            this.commands.put(Character.forDigit(i, 10), options[i]);
        }
    }

    public void start() {
        System.out.println(Message.WELCOME);
        char option;
        do {
            System.out.println(Message.MENU);
            System.out.print(Message.PROMT);
            option = new Scanner(System.in).next().charAt(0);
            Option command = this.commands.get(option);
            if (command != null) {
                command.execute(this.session);
            } else {
                System.out.println(Message.NOT_FOUND_ERROR);
            }
        } while (option != '0');
    }

    private enum Message {
        WELCOME("Bienvenido al menú de la práctica de Hibernate."),
        MENU("Opciones:\n" +
                "1. Ejecutar 4a\n" +
                "2. Ejecutar 4b\n" +
                "3. Borrar el pasajero con id=8\n" +
                "4. Borrar el entretenimiento con id=4\n" +
                "5. Actualizar el pasajero con id=7 a \"Mortarion\"\n" +
                "6. Actualizar el entretenimiento con id=9 a \"Starfruit farming\"\n"),
        PROMT("Introduzca una opción: "),
        NOT_FOUND_ERROR("Error: Opción inválida.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String toString() {
            return this.message;
        }
    }
}
