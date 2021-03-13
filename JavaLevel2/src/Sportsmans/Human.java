package Sportsmans;

import Obstacles.Obstacle;

public class Human implements Sportsman, RunAbility, JumpAbility {
    private final int maxJumpHeight;
    private final int maxRunDistance;

    public Human(int maxJumpHeight, int maxRunDistance) {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean run(int distance) {
        System.out.println("Human is trying to run..");
        return distance <= maxRunDistance;

    }

    @Override
    public boolean jump(int height) {
        System.out.println("Human is trying to jump..");
        return height <= maxJumpHeight;

    }
}

