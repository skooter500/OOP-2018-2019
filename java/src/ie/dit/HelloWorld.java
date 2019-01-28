package ie.dit;

public class HelloWorld
{
    public static void main(String[] args) {
        System.out.println("Hello world");    

        Animal misty = new Dog(); // Polymorphism

        misty.setName("Misty");
        System.out.println(misty.getName());  
        misty.speak();  

        misty = new Cat();
        misty.speak();

        Animal garfield = new Cat();
        garfield.setName("Garfield");

        misty = garfield;

        garfield.setName("Felix");

        System.out.println(misty.getName());

    }
}