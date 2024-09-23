package kr.or.ddit.image.dao;

import kr.or.ddit.image.vo.ImageVO;
import kr.or.ddit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageDaoImpl implements IImageDao {

    // 싱글톤 패턴을 위한 private 생성자
    private ImageDaoImpl() {

    }

    private static IImageDao dao;  // 싱글톤 인스턴스 보관

    // 싱글톤 인스턴스를 반환하는 메서드
    public static IImageDao getInstance() {
        if (dao == null) {
            dao = new ImageDaoImpl();
        }
        return dao;
    }

    // 이미지 데이터를 DB에 삽입하는 메서드
    @Override
    public int insertImage(ImageVO image) {
        SqlSession session = MybatisUtil.getSqlSession();
        int count = 0;
        try {
            count = session.insert("image.insertImage", image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
        return count;
    }

    @Override
    public List<ImageVO> getImagesByTargetId(String targetId, String targetType) {
        SqlSession session = MybatisUtil.getSqlSession();
        List<ImageVO> imageList = null;
        try {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("targetId", targetId);
            paramMap.put("targetType", targetType);

            imageList = session.selectList("image.getImagesByTargetId", paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return imageList;
    }

    @Override
    public void deleteImage(int imageId) {
        SqlSession session = MybatisUtil.getSqlSession();
        try {
            session.delete("image.deleteImage", imageId);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }
    }

	@Override
	public ImageVO getImagesByImageId(int imageId) {
		SqlSession session = MybatisUtil.getSqlSession();
        ImageVO imageVo = null;
        try {
           imageVo = session.selectOne("image.getImagesByImageId", imageId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return imageVo;
	}

	@Override
	public void deleteImageForTargetId(String targetId) {
		SqlSession session = MybatisUtil.getSqlSession();
        try {
            session.delete("image.deleteImageForTargetId", targetId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }
	}

}
