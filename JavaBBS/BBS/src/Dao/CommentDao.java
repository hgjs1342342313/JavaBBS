package Dao;
import Entity.Area;
import Entity.comment;

import java.util.List;

public interface CommentDao {
    int updateComm(String var1,Object[] var2);
    List<comment> getALLComm();
    comment getComm(String var1, String[] var2);
    List<comment> selectComm(String sql,String[] param);
    void deleteComm(String sql,String[] param);
}
