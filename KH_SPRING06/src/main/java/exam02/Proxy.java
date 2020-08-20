package exam02;

public class Proxy implements Pet{

	private Pet pet;
	
	public Proxy(Pet pet) {
		this.pet = pet;
	}
	
	@Override
	public void cry() {
		System.out.println("울기전");
		pet.cry();
		System.out.println("울기후");
	}
}
