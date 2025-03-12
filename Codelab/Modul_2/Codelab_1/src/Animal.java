public class Animal {
    //declare necessary variables
    String name;
    String type;
    String sound;

    //Set constructor with parameter inside such as name, type, and sound. The scope is on the called object (this.name)
    public Animal (String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    //create new method for displaying information that later called in main file
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Sound: " + sound);
        System.out.println();
    }
}
