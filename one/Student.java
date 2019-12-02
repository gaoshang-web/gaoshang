package one;

public class Student {
//	具有以下属性：	姓名，性别，年龄，学号，班级，有学习和吃饭，睡觉这三个方法
	private String name;
	private char sex;
	private int age;
	private int stuNo;
	private String classNo;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	
	public Student(String name, char sex, int age, int stuNo, String classNo) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.stuNo = stuNo;
		this.classNo = classNo;
	}

	public Student() {
	}
	/**
	 * 这是一个吃饭的方法
	 */
	public void eat(){
		System.out.println("我叫"+name+"，我要去吃饭了");
	}
	/**
	 * 这是一个睡觉的方法
	 */
	public void sleep(){
		
	}
	/**
	 * 这是一个学习的方法
	 */
	public void study(){
		System.out.println("我在学习");
	}
	
}
