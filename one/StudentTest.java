package one;

public class StudentTest {
	public static void main(String[] args) {
//		Student s = new Student();
//		s.setName("����");
//		s.setAge(13);
//		s.setSex('��');
//		s.setClassNo("1902B");
//		s.setStuNo(15);
		Student s = new Student("����12111", '��', 45, 2, "1902B");
		System.out.println(s.getName()+"�Ա�"+s.getSex()+"��"+s.getAge()+"���ˣ���"+s.getClassNo()+"���"+s.getStuNo()+"��");
		s.study();
		s.eat();
	}
}
