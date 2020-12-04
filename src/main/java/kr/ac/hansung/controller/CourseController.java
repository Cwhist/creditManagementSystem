package kr.ac.hansung.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	// 학년/학기별 이수 총 학점
	@RequestMapping("/courses")
	public String showCourses(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		List<String> years = courseService.getYears();
		model.addAttribute("years", years);
		
		return "courses";
	}
	
	// 학기별 수강 내역
	@RequestMapping("/detailview")
	public String viewDetail(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "detailview";
	}
	
	
	// 수강신청
	@RequestMapping("/registercourse")
	public String registerCourse(Model model) {
		
		model.addAttribute("course", new Course());
		
		return "registercourse";
	}
	
	
	// 수강 신청 처리
	@RequestMapping("/doregister")
	public String doRegister(Model model, @Valid Course course, BindingResult result) {
		
		// utf-8로 인코딩하여 한글깨짐 문제 해결
		try {
			course.setName(new String(course.getName().getBytes("8859_1"), "utf-8"));
			course.setType(new String(course.getType().getBytes("8859_1"), "utf-8"));
			course.setProf(new String(course.getProf().getBytes("8859_1"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if(result.hasErrors()) {
			System.out.println("== Form data does not validated ==");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "registercourse";
		}
		
		courseService.insert(course);
		
		return "courseregistered";
	}
	
	// 수강 신청 내역 보기
	@RequestMapping("/showregister")
	public String showRegister(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "showregister";
	}
	

}
