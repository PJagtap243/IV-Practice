package SuperKeyword;

public class BMW extends Car{
	
	@Override
	public void start() {
		System.out.println("BMW - start");
	}
	
	public void speed() {
		super.start();
		System.out.println("BMW - speed");
	}
}
