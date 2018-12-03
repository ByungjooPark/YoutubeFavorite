package kr.co.yu.admin.dao;

import kr.co.yu.model.GalleryVO;
import kr.co.yu.model.UserVO;
import kr.co.yu.model.YoutubeVO;

public interface AdminMapper {
	public void join(UserVO vo);
	public void insertURL(YoutubeVO vo);
	public void insertGallery(GalleryVO vo);
}
