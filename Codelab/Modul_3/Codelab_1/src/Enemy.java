public class Enemy extends GameCharacter{

    public Enemy(String name, int health){
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {

        System.out.println(Enemy.this.getName() + " attacked " + target.getName() + " using Snake Bite");

        this.setHealth(this.getHealth() - 15);
        System.out.println("Brimstone now has :  " + this.getHealth() + " hp");

    }
}
