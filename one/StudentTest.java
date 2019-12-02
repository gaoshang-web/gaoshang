package one;

public class StudentTest {
	public static void main(String[] args) {
//		Student s = new Student();
//		s.setName("李四");
//		s.setAge(13);
//		s.setSex('男');
//		s.setClassNo("1902B");
//		s.setStuNo(15);
		Student s = new Student("李四12111", '男', 45, 2, "1902B");
		System.out.println(s.getName()+"性别"+s.getSex()+"，"+s.getAge()+"岁了，是"+s.getClassNo()+"班的"+s.getStuNo()+"号");
		s.study();
		s.eat();
	}
}
