package d20mvcTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import d20mvcTest.util.DBUtil;
import d20mvcTest.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{
	
	// 싱글톤 해보기
	private static MemberDaoImpl singleMemDao;
	
	private MemberDaoImpl() {
		System.out.println("싱글톤 생성자 입니다");
	}
	
	public static MemberDaoImpl getInstance() {
		if(singleMemDao==null) singleMemDao = new MemberDaoImpl();
		return singleMemDao;
	}
	// 싱글톤 해보기 끝
	
	

    @Override
    public int insertMember(MemberVO memVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0; // 반환값 저장할 변수

        try {
            conn = DBUtil.getConnection();

            String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) "
			           + "values(?, ?, ?, ?, ?) ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memVo.getMem_id());
            pstmt.setString(2, memVo.getMem_pass());
            pstmt.setString(3, memVo.getMem_name());
            pstmt.setString(4, memVo.getMem_tel());
            pstmt.setString(5, memVo.getMem_addr());
            
            cnt = pstmt.executeUpdate();
            
        } catch (Exception e) {

        }
        
        return cnt;
    }
    
    @Override
    public int deleteMember(String memId) {
        return 0;
    }
    
    @Override
    public int updateMember(MemberVO memVo) {
        return 0;
    }
    
    @Override
    public List<MemberVO> getAllMember() {
        return null;
    }
    
    @Override
    public int getMemberIdCount(String memId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; // select문은 항상 resultset에 담아야함
        int cnt = 0; // 반환값 변수

        try {
            conn = DBUtil.getConnection();
            
			String sql = "select count(*) cnt from mymember where mem_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                cnt = rs.getInt("cnt");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
        }

        return cnt;
    }

}
