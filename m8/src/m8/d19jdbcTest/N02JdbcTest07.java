package m8.d19jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 회원 관리 프로그램 작성 (MYMEMBER 테이블 이용)
 * 
 * 아래 메뉴의 기능을 모두 구현하시오 (CRUD 기능 구현하기)
 * 메뉴 예시)
 * 
 * === 작업 선택 ===
 * 1. 자료 추가         --> insert (C)
 * 2. 자료 삭제         --> delete (D)
 * 3. 자료 수정         --> update (U)
 * 4. 전체 자료 출력    --> select (R)
 * 0. 작업 끝
 * ================
 * 
 * 조건)
 * 1. 자료 추가에서 '회원ID'는 중복되지 않는다 (중복되면 다시 입력 받는다)
 * 2. 자료 삭제에서는 '회원ID'를 입력 받아서 처리한다
 * 3. 자료 수정에서 '회원ID'는 변경되지 않는다
 * 
 */

public class N02JdbcTest07 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            while(true) {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BHM93", "java");
                
                System.out.println(""+"\n"+
                "=== 작업 선택 ==="   +"\n"+
                "1. 자료 추가"        +"\n"+
                "2. 자료 삭제"        +"\n"+
                "3. 자료 수정"        +"\n"+
                "4. 전체 자료 출력"   +"\n"+
                "0. 작업 끝"          +"\n"+
                "==================");
                
                
                int choice = scan.nextInt();
                
                if(choice==0) System.exit(0);
                
                else if(choice==1) {
                    System.out.println("자료 추가");

                    String duplTest = "select mid from mymember";
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(duplTest);

                    String mid = "";
                    int dupl = 0;
                    while(true) {
                        System.out.println("아이디");
                        String midTemp = scan.next();
                        while(rs.next()) {
                            String idcheck = rs.getString("mid");
                            if(idcheck.equals(midTemp)) {
                                dupl = 1;
                                break;
                            }
                        }
                        if(dupl==0) {
                            mid = midTemp;
                            break;
                        } else {
                            System.out.println("중복");
                        }
                    }
                    System.out.println("비밀번호");
                    String mpass = scan.next();
                    System.out.println("이름");
                    String mname = scan.next();
                    
                    String sql = "insert into mymember(mno, mid, mpass, mname) values((SELECT NVL(MAX(mno), 0)+1 FROM mymember) , ?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    
                    pstmt.setString(1, mid);
                    pstmt.setString(2, mpass);
                    pstmt.setString(3, mname);
                    
                    pstmt.executeUpdate();
                }
                
                else if(choice==2) {
                    System.out.println("자료 삭제");
                    System.out.println("삭제할 아이디 입력");
                    String delid = scan.next();

                    String delTest = "select mid from mymember";
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(delTest);

                    int delcount = 0;
                    while(rs.next()) {
                        String idcheck = rs.getString("mid");
                        if(idcheck.equals(delid)) {
                            String sql = "delete from mymember where mid=?";
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1, delid);
                            pstmt.executeUpdate();
                            delcount++;
                            System.out.println("삭제 완료");
                        }
                    }
                    if(delcount==0) {
                        System.out.println("삭제 실패");
                    }
                }
                
                
                else if(choice==3) {
                    System.out.println("자료 수정");

                    System.out.println("수정할 아이디 입력");
                    String upid = scan.next();
                    System.out.println("비밀번호 수정");
                    String uppass = scan.next();
                    System.out.println("이름 수정");
                    String upname = scan.next();

                    String sql = "update mymember set mpass=?, mname=? where mid=?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, uppass);
                    pstmt.setString(2, upname);
                    pstmt.setString(3, upid);
                    pstmt.executeUpdate();
                }
                
                else if(choice==4) {
                    System.out.println("전체 출력");
                    String sql = "select * from mymember";
                    pstmt = conn.prepareStatement(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);

                    System.out.println("회원정보전체출력");
                    System.out.println("-----------------------------------");
                    while(rs.next()) {
                        System.out.println("mno: "+rs.getInt(1));
                        System.out.println("mid: "+rs.getString("mid"));
                        System.out.println("mname: "+rs.getString("mname"));
                        System.out.println("-----------------------------------");
                    }
                }
                else continue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        scan.close();
        
        // new N02JdbcTest07().menu();
    }

    // public void menu() {
    //     System.out.println(""+
    //     "=== 작업 선택 ===\n "+
    //     "1. 자료 추가\n      "+
    //     "2. 자료 삭제\n      "+
    //     "3. 자료 수정\n      "+
    //     "4. 전체 자료 출력\n "+
    //     "0. 작업 끝\n       "+
    //     "==================");

    //     int choice = scan.nextInt();
    //     switch (choice) {
    //         case 1:
    //             memInsert();
    //             break;
    //         case 2:
    //             memDelete();
    //             break;
    //         case 3:
    //             memUpdate();
    //             break;
    //         case 4:
    //             memList();
    //             break;
    //         case 0:
    //             System.out.println("종료");
    //             System.exit(0);
    //         default:
    //             menu();
    //     }
    // }

    // public void memInsert() {

    // }
    // public void memDelete() {

    // }
    // public void memUpdate() {

    // }
    // public void memList() {

    // }
}
