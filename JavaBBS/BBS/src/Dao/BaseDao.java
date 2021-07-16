package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    public static String DRIVER;
    public static String URL;
    public static String DBNAME;
    public static String DBPASS;
    Connection conn = null;

    static {
        init();
    }

    public BaseDao() {
    }

    public static void init() {
        Properties params = new Properties();
        String configFile = "database.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            params.load(is);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        DRIVER = params.getProperty("driver");
        URL = params.getProperty("url");
        DBNAME = params.getProperty("user");
        DBPASS = params.getProperty("password");
    }

    public Connection getConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, DBNAME, DBPASS);
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return conn;
    }

    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var7) {
                var7.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var5) {
                var5.printStackTrace();
            }
        }

    }

    public int executeSQL(String preparedSql, Object[] param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int num = 0;

        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; ++i) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }

            num = pstmt.executeUpdate();
        } catch (ClassNotFoundException var11) {
            var11.printStackTrace();
        } catch (SQLException var12) {
            var12.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, (ResultSet) null);
        }

        return num;
    }
}