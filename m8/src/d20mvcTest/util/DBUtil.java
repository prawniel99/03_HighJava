package d20mvcTest.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

// JDBC드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메소드로 구성된 class 만들기
public class DBUtil {
	
	static Logger logger = Logger.getLogger(DBUtil.class);

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            logger.info("jdbc driver load success");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패");
            logger.error("jdbc driver load fail", e);
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");
            logger.info("db connection success");
        } catch (Exception e) {
            System.out.println("DB연결 실패");
            logger.fatal("db connection failed");
            e.getStackTrace();
        }
        return conn;
    }
}
