package Obstacles;

import Sportsmans.JumpAbility;
import Sportsmans.Sportsman;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {

        this.height = height;
    }

    @Override
    public boolean doIt(Sportsman sportsman) {
        if (sportsman instanceof JumpAbility) {
            return ((JumpAbility) sportsman).jump(height);
        }
        return false;
    }
}
