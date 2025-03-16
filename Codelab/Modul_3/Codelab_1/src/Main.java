public class Main {
    public static void main(String[] args) {

        GameCharacter gameCharacter = new GameCharacter("General Character", 100);
        Hero hero = new Hero("Brimstone", 150);
        Enemy enemy = new Enemy("Viper", 200);

        GameCharacter hero1 = new Hero("Brimstone", 150);
        GameCharacter enemy1 = new Enemy("Viper", 200);

        System.out.println("Initial Status :");
        System.out.println(hero.getName() + " has health: " + hero.getHealth());
        System.out.println(enemy.getName() + " has health: " + enemy.getHealth());

        hero.attack(enemy);
        hero.attack(enemy);

        enemy.attack(hero);

    }
}
