package kr.ac.hansung.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
	
	@Size(min=2, max=30, message="Name must be between 2 and 30 chars")
	@NotEmpty(message="The course name cannot be empty")
	private String name;
	
	@Size(min=2, max=10, message="Name must be between 2 and 10 chars")
	@NotEmpty(message="The type infomation cannot be empty")
	private String type;
	
	@Size(min=2, max=10, message="Name must be between 2 and 10 chars")
	@NotEmpty(message="The prof infomation cannot be empty")
	private String prof;
	
	@DecimalMin(value="2", message="Credit must be higher than 2")
	@DecimalMax(value="12", message="Credit must be lower than 12")
	private int credit;

}
