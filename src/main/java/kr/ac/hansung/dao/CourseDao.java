package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public int getRowCount() {
    	
    	String sqlStatement = "select count(*) from course";
    	return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    	
    }
    
    // cRud method
    // 쿼리하여 1개의 Course 리턴
    public Course getCourse(String name) {
    	
    	String sqlStatement = "select * from courses where name=?";
    	return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, 
    			new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setId(rs.getInt("id"));
				course.setYear(rs.getString("year"));
				course.setSemester(rs.getString("semester"));
				course.setName(rs.getString("name"));
				course.setType(rs.getString("type"));
				course.setProf(rs.getString("prof"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
    		
    	});
    	
    }
    
    // 쿼리하여 여러개의 Course 리턴
    public List<Course> getCourses() {
    	
    	String sqlStatement = "select * from courses";
    	return jdbcTemplate.query(sqlStatement,	new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setId(rs.getInt("id"));
				course.setYear(rs.getString("year"));
				course.setSemester(rs.getString("semester"));
				course.setName(rs.getString("name"));
				course.setType(rs.getString("type"));
				course.setProf(rs.getString("prof"));
				course.setCredit(rs.getInt("credit"));
				
				return course;
			}
    		
    	});
    	
    }
    
    // Crud method
    // 데이터 삽입
    public boolean insert(Course course) {
    	
    	String year = course.getYear();
		String semester = course.getSemester();
		String name = course.getName();
		String type = course.getType();
		String prof = course.getProf();
		int credit = course.getCredit();
    	
    	String sqlStatement = 
    			"insert into courses (year, semester, name, type, prof, credit) values (?,?,?,?,?,?)";
    	
    	return (jdbcTemplate.update(sqlStatement, new Object[] {year,semester,name,type,prof,credit}) == 1);
    }
    
    // crUd method
    // 데이터 수정
    public boolean update(Course course) {
    	
    	int id = course.getId();
    	String year = course.getYear();
		String semester = course.getSemester();
		String name = course.getName();
		String type = course.getType();
		String prof = course.getProf();
		int credit = course.getCredit();
    	
    	String sqlStatement = 
    			"update courses set year=?, semester=?, name=?, type=?, prof=?, credit=? where id=?";
    	
    	return (jdbcTemplate.update(sqlStatement, new Object[] {year,semester,name,type,prof,credit,id}) == 1);
    }
    
    // cruD method
    // 데이터 삭제
    public boolean delete(int id) {
    	
    	String sqlStatement = "delete from courses where id=?";
    	
    	return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }
    
    // 쿼리하여 여러개의 Course의 year속성 리턴
    public List<String> getYears() {
    	String sqlStatement = "select year from courses";
    	List<String> list = jdbcTemplate.query(sqlStatement,new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("year");
			}
    		
    	});
    	
    	//중복제거
    	HashSet<String> set = new HashSet<String>(list);
    	List<String> result = new ArrayList<String>(set);
    	
    	return result;
    }

}
