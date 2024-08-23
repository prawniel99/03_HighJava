package d20mvcTest.service;

import java.util.List;

import d20mvcTest.dao.IMemberDao;
import d20mvcTest.dao.MemberDaoImpl;
import d20mvcTest.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
    private IMemberDao dao; // Dao 객체가 저장될 변수 선언
    private static MemberServiceImpl singleMemService;

    // 생성자
    private MemberServiceImpl() {
//        dao = new MemberDaoImpl();
    	dao = MemberDaoImpl.getInstance();
    }
    
    public static MemberServiceImpl getInstance() {
    	if(singleMemService==null) singleMemService = new MemberServiceImpl();
    	return singleMemService;
    }

    @Override
    public int insertMember(MemberVO memVo) {
        return dao.insertMember(memVo);
    }
    
    @Override
    public int deleteMember(String memId) {
        return dao.deleteMember(memId);
    }
    
    @Override
    public int updateMember(MemberVO memVo) {
        return dao.updateMember(memVo);
    }
    
    @Override
    public List<MemberVO> getAllMember() {
        return dao.getAllMember();
    }
    
    @Override
    public int getMemberIdCount(String memId) {
        return dao.getMemberIdCount(memId);
    }

}
