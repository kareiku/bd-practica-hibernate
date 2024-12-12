package bbdd.utils;

import bbdd.utils.options.*;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final SessionFactory factory;
    private final Map<Integer, Option> commands;

    public Menu(SessionFactory factory) {
        this.factory = factory;
        this.commands = new HashMap<>();
        Option[] options = {
                new Exercise4aOption(),
                new Exercise4bOption(),
                new DeletePasajeroOption(),
                new DeleteEntretenimientoOption(),
                new UpdatePasajeroOption(),
                new UpdateEntretenimientoOption()
        };
        for (int i = 1; i <= options.length; i++) {
            this.commands.put(i, options[i - 1]);
        }
    }

    public void start() {
        int input = -1;
        System.out.println();
        System.out.println(Message.WELCOME);
        do {
            try {
                System.out.println();
                System.out.println(Message.MENU);
                System.out.print(Message.PROMT);
                input = new Scanner(System.in).nextInt();
                Option option;
                if (input > 0) {
                    option = this.commands.get(input);
                    if (option != null) {
                        option.tryExecution(this.factory);
                    } else {
                        System.out.println();
                        System.out.println(Message.NOT_FOUND_ERROR);
                    }
                } else {
                    if (input != 0) {
                        System.out.println();
                        System.out.println(Message.INVALID_INPUT);
                    }
                }
            } catch (Exception ex) {
                assert false : ex.getMessage();
                System.out.println();
                System.out.println(Message.INVALID_INPUT);
            }
        } while (input != 0);
    }

    private enum Message {
        WELCOME("Bienvenido al menú de la práctica de Hibernate."),
        MENU("Opciones:\n" +
                "0. Salir\n" +
                "1. Ejecutar 4a\n" +
                "2. Ejecutar 4b\n" +
                "3. Borrar el pasajero con id=8\n" +
                "4. Borrar el entretenimiento con id=4\n" +
                "5. Actualizar el pasajero con id=7 a \"Mortarion\"\n" +
                "6. Actualizar el entretenimiento con id=9 a \"Starfruit farming\"\n"),
        PROMT("Introduzca una opción: "),
        INVALID_INPUT("Error: La opción introducida no está comprendida en el rango de números enteros válido."),
        NOT_FOUND_ERROR("Error: Opción no encontrada.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String toString() {
            return this.message;
        }
    }
}
