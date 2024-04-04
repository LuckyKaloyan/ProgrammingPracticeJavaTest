package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertThrows;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(1, 2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void setLowerNumberOfElements() throws OperationNotSupportedException {
        new Database(1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElementToTheArray() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDatabase() throws OperationNotSupportedException {
        while (true) {
            database.remove();
        }
    }


}
