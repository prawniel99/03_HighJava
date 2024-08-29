package kr.or.ddit.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{
	
	// 싱글톤 해보기
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
    @Override
    public int insertMember(MemberVO memVo) {
    	
    	SqlSession session = null;
    	int cnt = 0;
    	
    	try {
    		session = MybatisUtil.getSqlSession();
    		cnt = session.insert("mymember.insertMember", memVo);
    		
    		if
    		
    	} catch (Exception e) {
    		
    	}
    	
    	
    	

    	
    	
    	
    	Scanner scan = new Scanner(System.in);

		InputStream in = null; // 스트림 객체 변수 선언
		
		
		
		try {
			// 1-1. 환경 설정 파일을 읽어 올 스트림 객체를 생성한다.
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");

			// 1-2. 환경 설정 파일을 읽어와 환경 설정 작업을 수행하고 작업이 완료되면 SqlSessionFactory객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			System.out.println("MyBatis 초기화 실패");
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					
				}
		}
		// insert
		String memId;
		String memPass;
		String memName;
		String memTel;
		String memAddr;
		MemberVO lvo;
		
		SqlSession session = null;
		// 중복 확인하기
//		while(true) {
			System.out.println("memId 입력 >> ");
			memId = scan.next();
			
			System.out.println("memPass 입력 >> ");
			memPass = scan.next();
			
			System.out.println("memName 입력 >> ");
			memName = scan.next();
			
			System.out.println("memTel 입력 >> ");
			memTel = scan.next();
			
			System.out.println("memAddr 입력 >> ");
			memAddr = scan.next();
			
			
			// insert할 데이터들을 VO객체에 저장한다.
			lvo = new MemberVO();
			lvo.setMem_id(memId);
			lvo.setMem_pass(memPass);
			lvo.setMem_name(memName);
			lvo.setMem_tel(memTel);
			lvo.setMem_addr(memAddr);
			
			// 중복 확인하기
//			try {
				session = sqlSessionFactory.openSession();
//				if(session.selectOne("jdbc.checkLprod", lvo)==null) {
//					break;
//				} else {
//					System.out.println("gu값 중복, 다시 입력하세요");
//					continue;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			break;
//		}
		
		try {
			int insertCnt = session.insert("jdbc.insertMember", lvo);

			if(insertCnt>0){
				session.commit();
				System.out.println("insert 작업 성공");
			} else {
				System.out.println("insert 작업 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		scan.close();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
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
    	
    	SqlSession session = null;
    	int count = 0;
    	
    	try {
			session = MybatisUtil.getSqlSession();
			
		} catch (Exception e) {
			
		}
    	
    	
    	
    	
    	
    	
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
