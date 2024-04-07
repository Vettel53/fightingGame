abstract class Enemy {
    public abstract String enemyName();

    public abstract int enemyHealth();

    public abstract int enemyDamage();

}


class Ralph extends Enemy {
    public String enemyName() {
        return "Ralph";
    }

    public int enemyHealth() {
        return 200;
    }

    public int enemyDamage() {
        return 50;
    }
}

class FallenCaptain extends Enemy {
    public String enemyName() {
        return "Fallen Captain";
    }

    public int enemyHealth() {
        return 300;
    }

    public int enemyDamage() {
        return 40;
    }
}

class HiveKnight extends Enemy {
    public String enemyName() {
        return "Hive Knight";
    }

    public int enemyHealth() {
        return 400;
    }

    public int enemyDamage() {
        return 60;
    }

//    @Override
//    public String toString() {
//        return  "Enemy Name: " + enemyName() + ", Health: " + enemyHealth() + ", Damage: " + enemyDamage(); // Print correctly when printing directly using object
//    }
}

class CabalCenturion extends Enemy {
    public String enemyName() {
        return "Cabal Centurion";
    }

    public int enemyHealth() {
        return 500;
    }

    public int enemyDamage() {
        return 70;
    }
}

class VexMinotaur extends Enemy {
    public String enemyName() {
        return "Vex Minotaur";
    }

    public int enemyHealth() {
        return 450;
    }

    public int enemyDamage() {
        return 55;
    }
}

class ScornBaron extends Enemy {
    public String enemyName() {
        return "Scorn Baron";
    }

    public int enemyHealth() {
        return 600;
    }

    public int enemyDamage() {
        return 80;
    }
}