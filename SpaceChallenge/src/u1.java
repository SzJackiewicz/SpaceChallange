import java.util.Random;

public class u1 extends Rocket {

    public u1() {
        rocketCost = 100;
        rocketWeight = 10000;
        maxWeight = 18000;
        currentWeight = rocketWeight + 0; //dodać ładunek
        chanceLandingCrash = 0.05;
        chanceLouchExplosion = 0.01;
    }

    @Override
    public boolean launch() {
        Random rand = new Random();
        int rno = rand.nextInt(101);
        return chanceLouchExplosion<rno;
    }

    @Override
    public boolean land() {
        double chance_of_crash_landing = chanceLandingCrash * cargoWeight/maxWeight;
        Random rand = new Random();
        int rno = rand.nextInt(101);
        return chance_of_crash_landing<rno;
    }

}
