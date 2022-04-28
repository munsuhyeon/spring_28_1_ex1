package com.suhyeon.ex;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suhyeon.ex.dao.ContentDao;
import com.suhyeon.ex.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	ContentDao dao;
	
	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		
		ArrayList<ContentDto> dtos = dao.listDao();
		model.addAttribute("list", dtos);
		
		return "list";
	}
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		
		dao.writeDao(request.getParameter("mwriter"), request.getParameter("mcontent"));
		
		return "redirect:list";
	}
	@RequestMapping("/view")
	public String view(HttpServletRequest request , Model model) {
		
		ContentDto dto = dao.viewDao(request.getParameter("mid"));
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		dao.deleteDao(request.getParameter("mid"));
		
		return "redirect:list";
	}
}
