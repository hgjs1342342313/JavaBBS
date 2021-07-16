package Services;
import Entity.*;

import java.util.List;

public interface PersonService extends Personable{
    Person login();
    List<poster> getMyPoster(int var1);
    List<comment> getMyComment(int var1);
    void deletePoster(poster p);
    void deleteComm(comment c);
}
