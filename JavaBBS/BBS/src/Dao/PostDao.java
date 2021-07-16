package Dao;
import Entity.poster;

import java.util.List;

public interface PostDao {
    List<poster> getAllPoster();
    int updatePoster(String var1,Object[] var2);
    List<poster> selectPoster(String var1,String[] var2);
    poster getPoster(String sql,String[] param);
    void deletePoster(String sql, Object[] param);
}
