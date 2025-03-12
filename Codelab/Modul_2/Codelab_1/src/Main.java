public class Main {

    public static void main(String[] args) {

        //Calling another class in another file named "Animal" and declared as animal1 and animal2 and pass the necessary parameters
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~");
        Animal animal2 = new Animal("Dog", "Mammal", "Woof Woof");

        //Call the displayInfo() inside from the declared animal1 and animal2
        animal1.displayInfo();
        animal2.displayInfo();
    }
}
