package Dao.impl;

import Dao.BaseDao;
import Dao.PostDao;
import Entity.poster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDaoImpl extends BaseDao implements PostDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public List<poster> getAllPoster() {
        ArrayList PList = new ArrayList();

        try {
            String preparedSql = "select * from poster ";
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(preparedSql);
            this.rs = this.pstmt.executeQuery();

            while (this.rs.next()) {
                poster P = new poster();
                P.setId((int) this.rs.getInt(1));
                P.setTitle((String) this.rs.getString(2));
                P.setDate((Date) this.rs.getDate(3));
                P.setContent((String) this.rs.getString(4));
                P.setUserid((int) this.rs.getInt(5));
                P.setAreaid((int) this.rs.getInt(6));
                P.setIfAnno((int) this.rs.getInt(7));
                PList.add(P);
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return PList;
    }

    public int updatePoster(String sql, Object[] param) {
        int count = super.executeSQL(sql, param);
        return count;
    }

    public List<poster> selectPoster(String sql, String[] param) {
        ArrayList PList = new ArrayList();

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
                poster P = null;
                P = new poster();
                P.setId((int) this.rs.getInt(1));
                P.setTitle((String) this.rs.getString(2));
                P.setDate((Date) this.rs.getDate(3));
                P.setContent((String) this.rs.getString(4));
                P.setUserid((int) this.rs.getInt(5));
                P.setAreaid((int) this.rs.getInt(6));
                P.setIfAnno((int) this.rs.getInt(7));
                PList.add(P);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }
        return PList;
    }

    public void deletePoster(String sql, Object[] param){
        super.executeSQL(sql,param);
    }

        public poster getPoster(String sql, String[] param){
        poster P = null;
        try {
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(sql);
            if (param != null) {
                for(int i = 0; i < param.length; ++i) {
                    this.pstmt.setString(i + 1, param[i]);
                }
            }

            this.rs = this.pstmt.executeQuery();

            while(this.rs.next()) {
                P = new poster();
                P.setId((int) this.rs.getInt(1));
                P.setTitle((String) this.rs.getString(2));
                P.setDate((Date) this.rs.getDate(3));
                P.setContent((String) this.rs.getString(4));
                P.setUserid((int) this.rs.getInt(5));
                P.setAreaid((int) this.rs.getInt(6));
                P.setIfAnno((int) this.rs.getInt(7));
            }
        }catch (SQLException var9) {
            var9.printStackTrace();
        } catch (ClassNotFoundException var10) {
            var10.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return P;
    }

}


