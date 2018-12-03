package kr.co.yu.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.yu.model.GalleryVO;
import kr.co.yu.model.YoutubeVO;

@Controller
@RequestMapping("client")
public class ClientContriller {
	@Autowired
	private ClientService service;
	
	@RequestMapping("jsonYoutubeList")
	@ResponseBody  // @ResponseBody를 넣고 데이터만 리턴하면 자동으로 json으로 변환해줌
	public List<YoutubeVO> jsonYoutubeList() {
		List<YoutubeVO> list = service.getList();
		return list;
	}
	
	@RequestMapping("jsonGalleryList")
	@ResponseBody  // @ResponseBody를 넣고 데이터만 리턴하면 자동으로 json으로 변환해줌
	public List<GalleryVO> jsonGalleryList() {
		return service.getGalleryList();
	}
		
	@RequestMapping("list")
	public String list(Model model) {
		
		List<YoutubeVO> list = service.getList();
		model.addAttribute("list", list);
		return "client/list";
	}
	
	@RequestMapping("galleryList")
	public String galleryList(Model model) {
		List<GalleryVO> list = service.getGalleryList();
		model.addAttribute("list", list);
		return "client/galleryList";
	}
	
	@RequestMapping("galleryDetail")
	public String galleryDetail(@RequestParam(name="g_no") int g_no , Model model) {
		GalleryVO vo = service.getGalleryDetail(g_no);
		model.addAttribute("vo", vo);
		return "client/galleryDetail";
	}
}
