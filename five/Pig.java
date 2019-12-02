package five;

public class Pig {
	private String name;
	private char sex;
	private int age;
	private String color;
	private double weight;
	private String xueLi;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getXueLi() {
		return xueLi;
	}
	public void setXueLi(String xueLi) {
		this.xueLi = xueLi;
	}
	public Pig() {
		super();
	}
	public Pig(String name, char sex, int age, String color, double weight,
			String xueLi) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.color = color;
		this.weight = weight;
		this.xueLi = xueLi;
	}
	
	
	public void eat(){
		System.out.println("³Ô");
	}
	public void sleep(){
		System.out.println("Ë¯");
	}
	public void work(){
		System.out.println("¹¤×÷");
	}
	
}
