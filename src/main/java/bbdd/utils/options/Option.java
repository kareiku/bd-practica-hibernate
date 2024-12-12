package bbdd.utils.options;

import org.hibernate.Session;

public interface Option {
    void execute(Session session);
}
