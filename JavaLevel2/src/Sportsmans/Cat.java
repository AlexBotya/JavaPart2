package Sportsmans;

public class Cat implements Sportsman, JumpAbility {
    private final int maxJumpHeight;


    public Cat(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(int height) {
        System.out.println("Cat is trying to jump..");
        return height <= maxJumpHeight;
    }
}
