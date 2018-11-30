package kr.co.yu.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.yu.model.GallaryVO;
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
	
	@RequestMapping("insertGallary")
	public String insertGallaryGet() {
		System.out.println("insertGallary GET");
		return "admin/insertGallary";
	}
	
	@RequestMapping(value="insertGallary", method=RequestMethod.POST)
	public String insertGallaryPost(GallaryVO vo) {
		System.out.println("insertGallary POST");
		System.out.println("title : " + vo.getTitle());
		System.out.println("file : " + vo.getImg());
		service.insertGallaryVO(vo);
		
		return "redirect:/client/gallaryList";
	}
}
