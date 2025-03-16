public class Hero extends GameCharacter {

    public Hero(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {

        System.out.println(Hero.this.getName() + " attacks " + target.getName() + " using Orbital Strike!");

        this.setHealth(this.getHealth() - 20);
        System.out.println("Viper now has : " + this.getHealth() + " hp");

    }
}
