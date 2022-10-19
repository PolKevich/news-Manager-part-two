package by.htp.ex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.ex.bean.News;
import by.htp.ex.service.NewsService;
import by.htp.ex.service.ServiceException;

@Controller
public class FrontController {

	@Autowired
	private NewsService newsService;
	private static final int newsNumber = 3;

	@GetMapping("/basePage")
	public String listLatesNews(Model theModel) {

		try {
			List<News> latestNews = newsService.getLatestNews(newsNumber);
			theModel.addAttribute("user", "notActive");
			theModel.addAttribute("news", latestNews);
		} catch (ServiceException e) {
			return "error";
		}

		return "baseLayout";
	}

	@RequestMapping("/newsList")
	public String listAllNews(Model theModel) {

		try {
			List<News> newsList = newsService.getNews();
			theModel.addAttribute("news", newsList);
			theModel.addAttribute("user", "active");
			theModel.addAttribute("role", "admin");
			theModel.addAttribute("presentation", "newsList");
		} catch (ServiceException e) {
			return "error";
		}

		return "baseLayout";
	}

	@PostMapping("/saveNews")
	public String saveNews(@ModelAttribute("news") News theNews) {

		try {
			newsService.saveNews(theNews);
		} catch (ServiceException e) {
			return "error";
		}

		return "redirect:/newsList";
	}

	@RequestMapping("/addNews")
	public String addNews(Model theModel) {

		theModel.addAttribute("user", "active");
		theModel.addAttribute("role", "admin");
		theModel.addAttribute("news", "addNews");

		return "baseLayout";
	}

	@GetMapping("/deleteNews")
	public String deleteNews(HttpServletRequest request) {

		try {

			String[] idNews = request.getParameterValues("newsId");

			if (idNews != null) {
				newsService.deleteNews(idNews);
			}
		} catch (ServiceException e) {
			return "error";
		}

		return "redirect:/newsList";
	}

	@GetMapping("/editNews")
	public String editNews(@RequestParam("newsId") int theId, Model theModel) {

		try {
			News theNews = newsService.getNews(theId);
			theModel.addAttribute("user", "active");
			theModel.addAttribute("role", "admin");
			theModel.addAttribute("editnews", "active");
			theModel.addAttribute("news", theNews);
		} catch (ServiceException e) {
			return "error";
		}

		return "baseLayout";
	}

	@GetMapping("/viewNews")
	public String viewNews(@RequestParam("newsId") int theId, Model theModel) {

		try {
			News theNews = newsService.getNews(theId);
			theModel.addAttribute("user", "active");
			theModel.addAttribute("role", "admin");
			theModel.addAttribute("presentation", "viewNews");
			theModel.addAttribute("news", theNews);
		} catch (ServiceException e) {
			return "error";
		}

		return "baseLayout";
	}

	@GetMapping("/signIn")
	public String signIn(Model theModel) {

		try {
			List<News> theNews = newsService.getNews();
			theModel.addAttribute("news", theNews);
			theModel.addAttribute("user", "active");
			theModel.addAttribute("role", "admin");
			theModel.addAttribute("presentation", "newsList");
		} catch (ServiceException e) {
			return "error";
		}

		return "baseLayout";
	}

	@GetMapping("/signOut")
	public String signOut(Model theModel) {

		try {
			List<News> latestNews = newsService.getLatestNews(newsNumber);
			theModel.addAttribute("user", "notActive");
			theModel.addAttribute("news", latestNews);
		} catch (ServiceException e) {
			return "error";
		}

		return "baseLayout";
	}

}
