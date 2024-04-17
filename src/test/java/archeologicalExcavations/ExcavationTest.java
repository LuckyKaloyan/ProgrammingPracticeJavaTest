package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTest {

    private Excavation excavation;
    private Archaeologist archaeologistOne;
    private Archaeologist archaeologistTwo;

    @Before
    public void setUp() {
        excavation = new Excavation("Excavation Site A", 3);
        archaeologistOne = new Archaeologist("Alice", 2);
        archaeologistTwo = new Archaeologist("Bob", 3);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(excavation.getName(), "Excavation Site A");
    }

    @Test
    public void getCapacityTest() {
        Assert.assertEquals(excavation.getCapacity(), 3);
    }

    @Test
    public void getCountTest() {
        Assert.assertEquals(excavation.getCount(), 0);
    }

    @Test
    public void addArchaeologistTest() {
        excavation.addArchaeologist(archaeologistOne);
        Assert.assertEquals(excavation.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistExceedCapacityTest() {
        setUp();
        excavation.addArchaeologist(archaeologistOne);
        excavation.addArchaeologist(archaeologistTwo);
        excavation.addArchaeologist(new Archaeologist("Charlie", 1));
        excavation.addArchaeologist(new Archaeologist("David", 1));
        excavation.addArchaeologist(new Archaeologist("Charlie", 1));
        excavation.addArchaeologist(new Archaeologist("David", 1)); }

    @Test(expected = IllegalArgumentException.class)
    public void addArchaeologistDuplicateTest() {
        excavation.addArchaeologist(archaeologistOne);
        excavation.addArchaeologist(archaeologistOne);
    }

    @Test
    public void removeArchaeologistTest() {
        excavation.addArchaeologist(archaeologistOne);
        excavation.addArchaeologist(archaeologistTwo);
        excavation.removeArchaeologist("Alice");
        Assert.assertEquals(excavation.getCount(), 1);
    }

    @Test
    public void removeArchaeologistNonExistentTest() {
        excavation.addArchaeologist(archaeologistOne);
        excavation.addArchaeologist(archaeologistTwo);
        Assert.assertFalse(excavation.removeArchaeologist("Charlie"));
    }
}
