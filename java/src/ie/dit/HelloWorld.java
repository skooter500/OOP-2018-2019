package ie.dit;  // Must be in the folder ie/dit

public class HelloWorld // public can be used outside the ie.dit package
{
    // static method is a method that 
    // doesnt require an instance of the class to be calledf
    public static void main(String[] args) {
        System.out.println("Hello world");  // print stuff  

        // The TYPE is of the superclass
        // The instance is of a subclass
        Animal misty = new Dog(); // Polymorphism

        // Calling a method
        misty.setName("Misty");

        // Calling a method and getting a return value
        System.out.println(misty.getName());  
        misty.speak();  

        misty = new Cat();
        misty.speak();

        Cat garfield = new Cat();
        garfield.setName("Garfield");

        misty = garfield;
        garfield.setName("Felix");
        System.out.println(misty.getName());

        while(garfield.getNumLives() > 0)
        {
            garfield.kill();
        }

    }
}