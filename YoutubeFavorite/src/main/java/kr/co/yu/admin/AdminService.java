package kr.co.yu.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.yu.admin.dao.AdminMapper;
import kr.co.yu.commons.ImgUtils;
import kr.co.yu.model.GalleryVO;
import kr.co.yu.model.UserVO;
import kr.co.yu.model.YoutubeVO;

@Service
public class AdminService {
	@Autowired
	private AdminMapper mapper;
	
	@Autowired 
	private BCryptPasswordEncoder bpe;
	
	public void join(UserVO vo) {		
		//TODO: 비멀번호 암호화
		
		String encodePassword = bpe.encode(vo.getU_pw());
		vo.setU_pw(encodePassword);
		
		mapper.join(vo);
	}
	
	public void insertURL(YoutubeVO vo) {		
		mapper.insertURL(vo);
		
	}
	
	public void insertGalleryVO(GalleryVO vo) {
		String g_path = ImgUtils.saveImgAndMakeThumb(this.getClass(), vo);
		System.out.println("g_path : " + g_path);
		
		vo.setG_path(g_path);
		mapper.insertGallery(vo);
	}
	
}
