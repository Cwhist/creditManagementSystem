package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public String showCourses(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		List<String> years = courseService.getYears();
		model.addAttribute("years", years);
		
		return "courses";
	}
	
	@RequestMapping("/detailview")
	public String viewDetail(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "detailview";
	}
	

}
