package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@RequestMapping("")
	public String admin(Model model) {
		model.addAttribute("articulos", new String[] {
			"uno",
			"dos",
			"tres"
		});
		return "/WEB-INF/jsp/admin/index.jsp";
	}
}
