package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BaseDao;
import Dao.AreaDao;
import Entity.Area;

public class AreaDaoImpl extends BaseDao implements AreaDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public AreaDaoImpl() {
    }

    @Override
    public int updateArea(String sql, Object[] param) {
        int count = super.executeSQL(sql, param);
        return count;
    }

    @Override
    public List<Area> getALLArea() {
        ArrayList areaList = new ArrayList();

        try {
            String preparedSql = "select * from area ";
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(preparedSql);
            this.rs = this.pstmt.executeQuery();

            while (this.rs.next()) {
                Area area = new Area();
                area.setId(this.rs.getInt(1));
                area.setName(this.rs.getString(2));
                areaList.add(area);
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return areaList;
    }

    @Override
    public Area getArea(String sql, String[] param) {
        Area area = null;

        try {
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; ++i) {
                    this.pstmt.setString(i + 1, param[i]);
                }
            }

            this.rs = this.pstmt.executeQuery();

            while (this.rs.next()) {
                area = new Area();
                area.setId((int)this.rs.getInt(1));
                area.setName((String) this.rs.getString(2));
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        } catch (ClassNotFoundException var10) {
            var10.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }
        return area;
    }

    @Override
    public List<Area> selectArea(String sql, String[] param) {
        List<Area> areaList = new ArrayList<Area>();

        try {
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; ++i) {
                    this.pstmt.setString(i + 1, param[i]);
                }
            }

            this.rs = this.pstmt.executeQuery();

            while (this.rs.next()) {
        Area                         area = new Area();
                area.setId(this.rs.getInt(1));
                area.setName(this.rs.getString(2));
areaList.add(area);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return areaList;
    }
}
