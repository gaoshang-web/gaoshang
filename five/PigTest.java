package five;

public class PigTest {
	public static void main(String[] args) {
		Pig p1 = new Pig("����1", 'Ů', 3, "��ɫ", 456.32, "����");
		Pig p2 = new Pig("����2", '��', 2, "��ɫ", 56.32, "����");
		Pig p3 = new Pig("����3", 'Ů', 1, "��ɫ",156.32, "����");
		Pig p4 = new Pig("����4", 'Ů', 5, "��ɫ", 46.32, "��ѧ");
		Pig p5 = new Pig("����5", '��', 7, "��ɫ", 486.12, "˶ʿ");
		Pig p6 = new Pig("����", 'Ů', 8, "��ɫ", 986.32, "�����");
//		p1.eat();
//		p1.sleep();
//		p1.work();
		
//		������������
		Pig[]  arr = {p1,p2,p3,p4,p5,p6};
//		�����һ��������
		Pig max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max.getWeight()<arr[i].getWeight()){
				max = arr[i];
			}
		}
		System.out.println(max.getName());
	}
}
