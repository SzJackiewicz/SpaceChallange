public class Rocket implements SpaceShip {
int rocketCost;
int rocketWeight;
int maxWeight;
int currentWeight;
double chanceLouchExplosion;
double chanceLandingCrash;
int cargoWeight;


    @Override
    public boolean launch() { return true; }

    public boolean land() { return true; }

    @Override
    public boolean canCarry(Item item) {
        if (cargoWeight + rocketWeight <= maxWeight)
        {
        }    return true;

    }

    @Override
    public void carry(Item item) {cargoWeight +=item.weight;}
}

