package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	private int id;
	
	@NotEmpty(message="The year infomation cannot be empty")
	private String year;
	
	@NotEmpty(message="The semester infomation cannot be empty")
	private String semester;
	
	@Size(min=2, max=100, message="Name must be between 2 and 30 chars")
	@NotEmpty(message="The course name cannot be empty")
	private String name;
	
	@NotEmpty(message="The type infomation cannot be empty")
	private String type;
	
	@NotEmpty(message="The prof infomation cannot be empty")
	private String prof;
	
	@NotEmpty(message="The credit infomation cannot be empty")
	private int credit;

}
