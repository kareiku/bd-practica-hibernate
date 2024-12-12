package bbdd.utils;

import bbdd.utils.commands.Command;
import bbdd.utils.commands.Execute4aCommand;
import bbdd.utils.commands.Execute4bCommand;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CLI {
    private final Session session;
    private final Map<Character, Command> commands;

    public CLI(Session session) {
        this.session = session;
        this.commands = new HashMap<>();
        Command[] commands = {new Execute4aCommand(), new Execute4bCommand()};
        for (int i = 1; i < commands.length; i++) {
            this.commands.put(Character.forDigit(i, 10), commands[i]);
        }
    }

    public void start() {
        System.out.println(Message.WELCOME);
        char option;
        do {
            System.out.println(Message.MENU);
            System.out.print(Message.PROMT);
            option = new Scanner(System.in).next().charAt(0);
            Command command = this.commands.get(option);
            if (command != null) {
                command.execute(this.session);
            } else {
                System.out.println(Message.NOT_FOUND_ERROR);
            }
        } while (option != '0');
    }

    private enum Message {
        WELCOME("Bienvenido al menú de la práctica de Hibernate."),
        MENU("Opciones:" +
                "1. Ejecutar 4a" +
                "2. Ejecutar 4b" +
                "3. Borrar el pasajero con id=8" +
                "4. Borrar el entretenimiento con id=4" +
                "5. Actualizar el pasajero con id=7 a \"Mortarion\"" +
                "6. Actualizar el entretenimiento con id=9 a \"Starfruit cultivation\""),
        PROMT("> "),
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
