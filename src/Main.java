public class Main {
    public static void main(String[] args) {
        Enemy enemyRalph = new Ralph();
        Player playerNormal = new playerNormal();
        CombatSystem combatSystem = new CombatSystem();

        System.out.printf("%s's health is %d and his damage is %d.", enemyRalph.enemyName(), enemyRalph.enemyHealth(), enemyRalph.enemyDamage());
        System.out.printf("\n%s's health is %d and his damage is %d.", playerNormal.playerName(), playerNormal.playerHealth(), playerNormal.playerDamage());

        combatSystem.startMenu();

    }
}