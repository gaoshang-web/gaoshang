package five;

public class PigTest {
	public static void main(String[] args) {
		Pig p1 = new Pig("佩奇1", '女', 3, "粉色", 456.32, "高中");
		Pig p2 = new Pig("佩奇2", '男', 2, "黑色", 56.32, "高中");
		Pig p3 = new Pig("佩奇3", '女', 1, "蓝色",156.32, "初中");
		Pig p4 = new Pig("佩奇4", '女', 5, "彩色", 46.32, "大学");
		Pig p5 = new Pig("佩奇5", '男', 7, "粉色", 486.12, "硕士");
		Pig p6 = new Pig("乔治", '女', 8, "绿色", 986.32, "家里蹲");
//		p1.eat();
//		p1.sleep();
//		p1.work();
		
//		将猪都放数组中
		Pig[]  arr = {p1,p2,p3,p4,p5,p6};
//		假设第一个猪最重
		Pig max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max.getWeight()<arr[i].getWeight()){
				max = arr[i];
			}
		}
		System.out.println(max.getName());
	}
}
