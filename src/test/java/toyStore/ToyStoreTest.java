package toyStore;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyStoreTest {

    private ToyStore toyStore;
    private Toy toyA;
    private Toy toyB;

    @Before
    public void setUp() {
        toyStore = new ToyStore();
        toyA = new Toy("Car", "001");
        toyB = new Toy("Doll", "002");
    }

    @Test
    public void addToySuccessTest() throws OperationNotSupportedException {
        String shelf = "A";
        String result = toyStore.addToy(shelf, toyA);
        Assert.assertEquals("Toy:001 placed successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addToyInvalidShelfTest() throws OperationNotSupportedException {
        String shelf = "Z";
        toyStore.addToy(shelf, toyA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addToyOccupiedShelfTest() throws OperationNotSupportedException {
        String shelf = "A";
        toyStore.addToy(shelf, toyA);
        toyStore.addToy(shelf, toyB);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addToyAlreadyExistsTest() throws OperationNotSupportedException {
        String shelf = "A";
        toyStore.addToy(shelf, toyA);
        toyStore.addToy("B", toyA);
    }

    @Test
    public void removeToySuccessTest() throws OperationNotSupportedException {
        String shelf = "A";
        toyStore.addToy(shelf, toyA);
        String result = toyStore.removeToy(shelf, toyA);
        Assert.assertEquals("Remove toy:001 successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeToyInvalidShelfTest() {
        toyStore.removeToy("Z", toyA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeToyNonExistentToyTest() {
        toyStore.removeToy("A", toyA);
    }
}
