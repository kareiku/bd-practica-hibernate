package bbdd.utils.commands;

import org.hibernate.Session;

public interface Command {
    void execute(Session session);
}
