package Dao;

import Entity.Area;

import java.util.List;

public interface AreaDao {
    int updateArea(String var1,Object[] var2);

    List<Area> getALLArea();
    Area getArea(String var1, String[] var2);
    List<Area> selectArea(String sql,String[] param);
}
