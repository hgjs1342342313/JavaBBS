package Dao.impl;

import java.sql.*;

import Dao.BaseDao;
import Dao.CommentDao;
import Entity.comment;
import Entity.poster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoImpl extends BaseDao implements CommentDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public CommentDaoImpl() {
    }

    @Override
    public int updateComm(String sql, Object[] param) {
        int count = super.executeSQL(sql, param);
        return count;
    }

    @Override
    public List<comment> getALLComm() {
        ArrayList<comment> cList = new ArrayList();
        try {
            String preparedSql = "select * from com ";
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(preparedSql);
            this.rs = this.pstmt.executeQuery();

            while (this.rs.next()) {
                comment c = new comment();
                comment flowerStore = new comment();
                c.setId((int) this.rs.getInt(1));
                c.setPosid((int) this.rs.getInt(2));
                c.setDate((Date) this.rs.getDate(3));
                c.setContent((String) this.rs.getString(4));
                c.setUserid((int) this.rs.getInt(5));
                cList.add(c);
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return cList;
    }


    @Override
    public comment getComm(String sql, String[] param) {
        comment c = null;
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
                c = new comment();
                c.setId((int) this.rs.getInt(1));
                c.setPosid((int) this.rs.getInt(2));
                c.setDate((Date) this.rs.getDate(3));
                c.setContent((String) this.rs.getString(4));
                c.setUserid((int) this.rs.getInt(5));
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        } catch (ClassNotFoundException var10) {
            var10.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return c;
    }

    @Override
    public List<comment> selectComm(String sql, String[] param) {
        ArrayList<comment> cList = new ArrayList();
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
                comment P = new comment();
                P.setId((int) this.rs.getInt(1));
                P.setPosid((int) this.rs.getInt(2));
                P.setDate((Date) this.rs.getDate(3));
                P.setContent((String) this.rs.getString(4));
                P.setUserid((int) this.rs.getInt(5));
                cList.add(P);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }
        return cList;
    }

    @Override
    public void deleteComm(String sql, String[] param) {
        try {
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; ++i) {
                    this.pstmt.setString(i + 1, param[i]);
                }
            }
            this.rs = this.pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

