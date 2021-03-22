import java.util.Random;

public class u2 extends Rocket{

    public u2(){
        rocketCost = 120;
        rocketWeight = 18000;
        maxWeight = 29000;
        currentWeight = rocketWeight + 0; //dodać ładunek
        chanceLandingCrash =0.04;
        chanceLouchExplosion =0.08;

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
