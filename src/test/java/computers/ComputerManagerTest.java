package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTest {

    private Computer computerOne;
    private Computer computerTwo;
    private ComputerManager computerManager;

    @Before
    public void setUp() {
        computerOne = new Computer("ManufacturerOne", "ModelOne", 1000);
        computerTwo = new Computer("ManufacturerTwo", "ModelTwo", 2000);
        computerManager = new ComputerManager();
    }

    @Test
    public void testGetComputers() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerTwo);

        List<Computer> expectedComputers = new ArrayList<>();
        expectedComputers.add(computerOne);
        expectedComputers.add(computerTwo);

        Assert.assertEquals(computerManager.getComputers(), expectedComputers);
    }

    @Test
    public void testGetCount() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerTwo);

        Assert.assertEquals(computerManager.getCount(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateComputer() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingComputer() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.removeComputer("NonExistingManufacturer", "NonExistingModel");
    }

    @Test
    public void testRemoveComputer() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerTwo);

        Assert.assertEquals(computerManager.removeComputer("ManufacturerTwo", "ModelTwo"), computerTwo);
        Assert.assertEquals(computerManager.getCount(), 1);
    }

    @Test
    public void testGetComputer() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerTwo);

        Assert.assertEquals(computerManager.getComputer("ManufacturerOne", "ModelOne"), computerOne);
    }

    @Test
    public void testGetComputersByManufacturer() {
        setUp();
        computerManager.addComputer(computerOne);
        computerManager.addComputer(computerTwo);
        computerManager.addComputer(new Computer("ManufacturerTwo", "ModelThree", 3000));

        List<Computer> expectedComputers = new ArrayList<>();
        expectedComputers.add(computerTwo);
        expectedComputers.add(new Computer("ManufacturerTwo", "ModelThree", 3000));

        Assert.assertEquals(computerManager.getComputersByManufacturer("ManufacturerTwo"), expectedComputers);
    }
}
