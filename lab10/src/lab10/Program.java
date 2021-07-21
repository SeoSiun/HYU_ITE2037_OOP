package lab10;

public class Program {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animal = new Animal[3];
		animal[0] = dog;
		animal[1] = tiger;
		animal[2] = turtle;
		
		Person person = new Person() {
			private int hp = 100;

			@Override
			public void control(Barkable b) {
				if(b.getClass() == Tiger.class) {
					this.hp -= 80;
				}
				else if(b.getClass() == Dog.class){
					this.hp -= 10;
				}
				Animal a = (Animal)b;
				System.out.println(a.getName() + "�� �����Ͽ����ϴ�.");
				
			}

			@Override
			public void showInfo() {
				System.out.println("��� HP : " + this.hp);		
			}
			
		};
		
		showResult(animal,person);
	}

	private static void showResult(Animal[] animal, Person person) {
		for(int i=0; i<animal.length; i++) {
			if(animal[i] instanceof Barkable) {
				System.out.println((i+1) + "��° ���� : " + animal[i].getName());
				Barkable b = (Barkable)animal[i];
				System.out.println((i+1) + "��° ���� �����Ҹ�: " + b.bark());
				person.control(b);
				person.showInfo();	
			}
		}
	}

}
