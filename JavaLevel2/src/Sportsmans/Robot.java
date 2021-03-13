package Sportsmans;

public class Robot implements Sportsman, JumpAbility, RunAbility {

    private final int maxJumpHeight;
    private final int maxRunDistance;

    public Robot(int maxJumpHeight, int maxRunDistance) {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean run(int distance) {
        System.out.println("Robot is trying to run..");
        return distance <= maxRunDistance;

    }

    @Override
    public boolean jump(int height) {
        System.out.println("Robot is trying to jump..");
        return height <= maxJumpHeight;

    }
}
