package kr.co.yu.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.yu.model.YoutubeVO;

@Controller
@RequestMapping("client")
public class ClientContriller {
	@Autowired
	private ClientService service;
		
	@RequestMapping("list")
	public String list(Model model) {
		
		List<YoutubeVO> list = service.getList();
		model.addAttribute("list", list);
		return "client/list";
	}
}
