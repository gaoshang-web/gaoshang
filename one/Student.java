package one;

public class Student {
//	�����������ԣ�	�������Ա����䣬ѧ�ţ��༶����ѧϰ�ͳԷ���˯������������
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
	 * ����һ���Է��ķ���
	 */
	public void eat(){
		System.out.println("�ҽ�"+name+"����Ҫȥ�Է���");
	}
	/**
	 * ����һ��˯���ķ���
	 */
	public void sleep(){
		
	}
	/**
	 * ����һ��ѧϰ�ķ���
	 */
	public void study(){
		System.out.println("����ѧϰ");
	}
	
}
