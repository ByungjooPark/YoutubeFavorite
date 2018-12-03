package kr.co.yu.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.yu.model.GalleryVO;
import kr.co.yu.model.UserVO;
import kr.co.yu.model.YoutubeVO;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService service; 
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "admin/loginForm";
	}
	
	@RequestMapping("main")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("accessDenied")
	public String accessDenied() {
		return "admin/accessDenied";
	}
	
	@RequestMapping("joinForm")
	public String joinGet() {
		return "admin/joinForm";
	}
	
	@RequestMapping(value="joinForm", method=RequestMethod.POST)
	public String joinPost(UserVO vo) {
		System.out.println("joinPOST");
		
		service.join(vo);
		return "redirect:loginForm";
	}
	
	@RequestMapping("insertURL")
	public String insertURLGet() {
		return "admin/insertURL";
	}
	
	@RequestMapping(value="insertURL", method=RequestMethod.POST)
	public String insertURLPost(YoutubeVO vo) {
		System.out.println("insert URL POST");
		service.insertURL(vo);
		return "redirect:main";
	}
	
	@RequestMapping("insertGallery")
	public String insertGallaryGet() {
		System.out.println("insertGallery GET");
		return "admin/insertGallery";
	}
	
	@RequestMapping(value="insertGallery", method=RequestMethod.POST)
	public String insertGallaryPost(GalleryVO vo) {
		System.out.println("insertGallery POST");
		System.out.println("title : " + vo.getG_title());
		System.out.println("file : " + vo.getImg());
		service.insertGalleryVO(vo);
		
		return "redirect:/client/galleryList";
	}
}
