import Obstacles.Obstacle;
import Obstacles.Road;
import Obstacles.Wall;
import Sportsmans.*;


public class main {


    public static void main(String[] args) {
        Sportsman[] sportsmans = {
                new Human(2, 200),
                new Robot(10, 500),
                new Cat(20)
        };

        Obstacle[] obstacles = {
                new Road(200),
                new Wall(5)
        };

        for (int i = 0; i < sportsmans.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                System.out.println(obstacles[j].doIt(sportsmans[i]));

            }

        }

    }
}

