package Dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Dao.BaseDao;
import Dao.PersonDao;
import Entity.Person;

public class PersonDaoImpl extends BaseDao implements PersonDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    public PersonDaoImpl() {
    }

    @Override
    public Person selectPerson(String sql,String[] param) {
        Person p = null;
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
                p = new Person();
                p.setId((int) this.rs.getInt(1));
                p.setName((String) this.rs.getString(2));
                p.setUsername((String) this.rs.getString(3));
                p.setLevel((int) this.rs.getInt(4));
                p.setStatus((boolean) this.rs.getBoolean(5));
                p.setIfMgr((boolean) this.rs.getBoolean(6));
                p.setPwd((String) rs.getString(7));
            }
        }catch(Exception var8){
            var8.printStackTrace();
        }finally{
            super.closeAll(this.conn,this.pstmt,this.rs);
        }
    return p;
    }

    @Override
    public int updatePerson(String sql, Object[] param) {
        int count = super.executeSQL(sql, param);
        return count;
    }

    @Override
    public Person getPerson(String sql, String[] param) {
        Person p = null;

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
                p = new Person();
                p.setId((int) this.rs.getInt(1));
                p.setName((String) this.rs.getString(2));
                p.setUsername((String) this.rs.getString(3));
                p.setLevel((int) this.rs.getInt(4));
                p.setStatus((boolean) this.rs.getBoolean(5));
                p.setIfMgr((boolean) this.rs.getBoolean(6));
                p.setPwd((String) rs.getString(7));
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        } catch (ClassNotFoundException var10) {
            var10.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return p;
    }

    @Override
    public List<Person> getAllPerson() {
        ArrayList pList = new ArrayList();

        try {
            String preparedSql = "select * from person ";
            this.conn = this.getConn();
            this.pstmt = this.conn.prepareStatement(preparedSql);
            this.rs = this.pstmt.executeQuery();

            while (this.rs.next()) {
                Person p = new Person();
                p = new Person();
                p.setId((int) this.rs.getInt(1));
                p.setName((String) this.rs.getString(2));
                p.setUsername((String) this.rs.getString(3));
                p.setLevel((int) this.rs.getInt(4));
                p.setStatus((boolean) this.rs.getBoolean(5));
                p.setIfMgr((boolean) this.rs.getBoolean(6));
                p.setPwd((String) rs.getString(7));
                pList.add(p);
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        } catch (ClassNotFoundException var9) {
            var9.printStackTrace();
        } finally {
            super.closeAll(this.conn, this.pstmt, this.rs);
        }

        return pList;
    }
}

