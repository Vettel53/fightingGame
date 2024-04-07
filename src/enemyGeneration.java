import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class enemyGeneration {

    public void combatSystem() {
        CombatSystem cSystem = new CombatSystem();

        List<Enemy> enemies = loadEnemies(); // Load all enemies into arraylist (FOLLOW loadEnemies method)

        Enemy randomEnemy = randomEnemy(enemies); // Store randomly picked enemy for combat
        System.out.println(randomEnemy); // Test randomly picked enemy

        String enemyName = randomEnemy.enemyName();
        int enemyHealth = randomEnemy.enemyHealth(); // Store Randomly picked enemies stats
        int enemyDamage = randomEnemy.enemyDamage();

        System.out.println("\nRandom Enemy Stats:");
        System.out.println("Name: " + enemyName);
        System.out.println("Health: " + enemyHealth); // Test print the random enemies stats
        System.out.println("Damage: " + enemyDamage);
        cSystem.combatStart(randomEnemy);
    }

    public List<Enemy> loadEnemies() {
        List<Enemy> enemiesArray = new ArrayList<>(); // Create ArrayList of enemies using class Enemy

        // Add all enemies to enemies Arraylist
        enemiesArray.add(new Ralph());
        enemiesArray.add(new FallenCaptain());
        enemiesArray.add(new HiveKnight());
        enemiesArray.add(new CabalCenturion());
        enemiesArray.add(new VexMinotaur());
        enemiesArray.add(new ScornBaron());
        // Add all enemies to enemies Arraylist

        return enemiesArray; // Return whole enemies ArrayList
    }

    public Enemy randomEnemy(List<Enemy> enemies) {

        Random random = new Random();

        int randomEnemyIndex = random.nextInt(enemies.size()); // Create random int specified by the size of enemies arraylist
        // Look at loadEnemies method for more information

        return enemies.get(randomEnemyIndex); // Return random enemy based on index
    }

}