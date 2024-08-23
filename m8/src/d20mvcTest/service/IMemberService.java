package d20mvcTest.service;

import java.util.List;

import d20mvcTest.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메소드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 * 받아온 결과를 Controller에게 보내주는 역할을 수행한다.
 * 
 * 보통 DAO의 메소드와 구조가 같게 만든다. // 꼭 그런건 아닌데 일단 그렇다.
 * 
 */
public interface IMemberService {

    /**
     * MemberVO에 저장된 자료를 DB에 insert하는 메소드
     * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
     * @return insert 작업 성공하면 1, 실패하면 0
     */
    public int insertMember(MemberVO memVo); // public 반환값 insertMember(매개변수); // 되도록이면 매개변수는 1개가 되는게 좋음.

    /**
     * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메소드
     * @param memId 삭제할 회원 ID
     * @return delete 작업 성공하면 1, 실패하면 0
     */
    public int deleteMember(String memId);
    
    /**
     * MemberVO자료를 이용하여 회원 정보를 수정하는 메소드
     * @param memVo update할 회원정보가 저장된 MemberVO객체
     * @return update 작업 성공하면 1, 실패하면 0
     */
    public int updateMember(MemberVO memVo);

    /**
     * DB의 전체 회원 정보를 List에 담아서 반환하는 메소드
     * @return MemberVO객체가 저장된 List객체
     */
    public List<MemberVO> getAllMember();

    /**
     * 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메소드
     * @param memId 검색할 회원ID
     * @return 검색된 회원ID의 개수
     */
    public int getMemberIdCount(String memId);

}
