package Obstacles;

import Sportsmans.RunAbility;
import Sportsmans.Sportsman;

public class Road implements Obstacle {
    private final int distance;

    public Road(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean doIt(Sportsman sportsman) {
        if (sportsman instanceof RunAbility) {
            return ((RunAbility) sportsman).run(distance);

        }
        return false;
    }
}



