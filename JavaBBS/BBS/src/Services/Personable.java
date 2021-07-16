package Services;
import Entity.Person;

import java.util.List;

public interface Personable {
    List<Person> person(int var1);
    void signin(Person p);
}
