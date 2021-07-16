package Services;
import Entity.*;

import java.util.List;

public interface APService extends commable,Postable{
    poster getPoster(int var1);
    List<comment> getCommentInPoster(int posid);
    Area getArea(int Areaid);
    List<Area> getAllArea();
    int modifyArea(Area a);
    List<poster> getAllPoster();
    int modifyPoster(poster p);
    int modifyComment(comment c);
    void deletePoster(int posid);

}
