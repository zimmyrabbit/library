package com.spring.library.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.service.BookReviewService;

@Controller
public class BookReviewController {
	
	@Autowired
	BookReviewService bookReviewService;

	@RequestMapping(value="/bookReview/reviewList", method=RequestMethod.GET)
	public void reviewList() { }
	
	@RequestMapping(value="/bookReview/reviewRank", method=RequestMethod.GET)
	public void reviewRank() { }
	
	@RequestMapping(value="/bookReview/reviewWrite", method=RequestMethod.GET)
	public void bookReviewWrite(HttpServletRequest request, Model model) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", request.getParameter("title"));
		map.put("isbn", request.getParameter("isbn"));
		map.put("bookIntro", request.getParameter("bookIntro"));
		map.put("bookImg", request.getParameter("bookImg"));
		map.put("bookUrl", request.getParameter("bookUrl"));
		
		model.addAttribute("map", map);
		
	}
	
	@RequestMapping(value="/bookReview/reviewWrite", method=RequestMethod.POST)
	public String bookReviewWriteProc(HttpServletRequest request, Model model, HttpSession session) {
		
		HashMap<String,Object> sessionInfo = (HashMap<String,Object>) session.getAttribute("loginSession");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("title", request.getParameter("title"));
		map.put("isbn", request.getParameter("isbn"));
		map.put("bookIntro", request.getParameter("bookIntro"));
		map.put("bookImg", request.getParameter("bookImg"));
		map.put("bookUrl", request.getParameter("bookUrl"));
		map.put("bookRev", request.getParameter("bookRev"));
		map.put("userSeq", sessionInfo.get("userSeq"));
		
		bookReviewService.putBookReviewWrite(map);
		
		return "redirect:/bookReview/reviewList";
		
	}
}
