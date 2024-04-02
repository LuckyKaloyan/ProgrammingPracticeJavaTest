package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTest {

    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Spaceship spaceship;

    @Before
    public void setUp() {
        astronaut1 = new Astronaut("John Doe", 50);
        astronaut2 = new Astronaut("Jane Smith", 60);
        spaceship = new Spaceship("Blue Origin", 2);
    }

    @Test
    public void addAstronautTest() {
        setUp();
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);

        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAstronautToFullSpaceshipTest() {
        setUp();
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(new Astronaut("Bob", 70));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateAstronautTest() {
        setUp();
        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    @Test
    public void removeAstronautTest() {
        setUp();
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.remove("John Doe");

        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void removeNonExistingAstronautTest() {
        setUp();
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);

        Assert.assertFalse(spaceship.remove("Non-existing astronaut"));
    }

    @Test
    public void getSpaceshipNameTest() {
        setUp();
        Assert.assertEquals("Blue Origin", spaceship.getName());
    }

    @Test
    public void getSpaceshipCapacityTest() {
        setUp();
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCapacityTest() {
        new Spaceship("Test", -1);
    }

    @Test(expected = NullPointerException.class)
    public void invalidSpaceshipNameTest() {
        new Spaceship(null, 5);
    }
}
