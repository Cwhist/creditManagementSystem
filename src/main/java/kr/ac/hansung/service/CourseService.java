package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDao;
import kr.ac.hansung.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getCurrent() {
		return courseDao.getCourses();
	}

	public void insert(Course course) {
		
		courseDao.insert(course);
		
	}
	
	public List<String> getYears() {
		return courseDao.getYears();
	}

}
