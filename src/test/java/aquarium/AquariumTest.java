package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTest {
    private Aquarium aquarium;
    private Fish fish1;
    private Fish fish2;

    @Before
    public void setUp() {
        aquarium = new Aquarium("My Aquarium", 3);
        fish1 = new Fish("Nemo");
        fish2 = new Fish("Dory");
    }

    @Test
    public void addFishTest() {
        aquarium.add(fish1);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test
    public void removeFishTest() {
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.remove("Nemo");
        Assert.assertEquals(1, aquarium.getCount());
        Assert.assertFalse(aquarium.report().contains("Nemo"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistentFishTest() {
        aquarium.remove("NonExistent");
    }

    @Test
    public void sellFishTest() {
        aquarium.add(fish1);
        Fish soldFish = aquarium.sellFish("Nemo");
        Assert.assertFalse(soldFish.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellNonExistentFishTest() {
        aquarium.sellFish("NonExistent");
    }

    @Test
    public void reportTest() {
        aquarium.add(fish1);
        aquarium.add(fish2);
        String report = aquarium.report();
        Assert.assertTrue(report.contains("Nemo"));
        Assert.assertTrue(report.contains("Dory"));
    }

    @Test(expected = NullPointerException.class)
    public void nullAquariumNameTest() {
        new Aquarium(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyAquariumNameTest() {
        new Aquarium("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeCapacityTest() {
        new Aquarium("Negative Capacity", -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFishToFullAquariumTest() {
        aquarium.add(new Fish("Marlin"));
        aquarium.add(new Fish("Bruce"));
        aquarium.add(new Fish("Squirt"));
        aquarium.add(new Fish("Nemo"));
    }
}
