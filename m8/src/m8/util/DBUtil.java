package m8.util;

import java.sql.Connection;
import java.sql.DriverManager;

// JDBC드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메소드로 구성된 class 만들기
public class DBUtil {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");
        } catch (Exception e) {
            System.out.println("DB연결 실패");
            e.getStackTrace();
        }
        return conn;
    }
}
