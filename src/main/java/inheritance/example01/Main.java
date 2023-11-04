package inheritance.example01;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("somePersonName", 10, "Dark brown");
        Dad dad = new Dad("John", 45, "black");
        Boy boy = new Boy("Rob", 14, "blonde", "House on fire");

        person.eat();
        person.play();
        System.out.println(person.getName());

        System.out.println("======================");

        dad.eat();
        dad.play();
        dad.work();
        System.out.println(dad.getName());

        System.out.println("======================");
        boy.eat();
        boy.play();
        boy.work();
        boy.dance();
        System.out.println(boy.getFavouriteMusic());
    }
}
