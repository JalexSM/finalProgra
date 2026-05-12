package model;

public class Course {
	
	private String code;
    private String CourseName;
    private String Credits;
    private String Quota;
	public Course(String code, String courseName, String credits, String quota) {
		super();
		this.code = code;
		CourseName = courseName;
		Credits = credits;
		Quota = quota;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCredits() {
		return Credits;
	}
	public void setCredits(String credits) {
		Credits = credits;
	}
	public String getQuota() {
		return Quota;
	}
	public void setQuota(String quota) {
		Quota = quota;
	}
	@Override
	public String toString() {
		return "Course [code=" + code + ", CourseName=" + CourseName + ", Credits=" + Credits + ", Quota=" + Quota
				+ "]";
	}
    
    
    
	

}
