package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    private BankVault bankVault;
    private Item itemOne;
    private Item itemTwo;

    @Before
    public void setUp() {
        bankVault = new BankVault();
        itemOne = new Item("ID001", "Watch");
        itemTwo = new Item("ID002", "Ring");
    }

    @Test
    public void addItemSuccessTest() throws OperationNotSupportedException {
        String cell = "A1";
        String result = bankVault.addItem(cell, itemOne);
        Assert.assertEquals("Item:ID001 saved successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemToNonexistentCellTest() throws OperationNotSupportedException {
        String cell = "Z9";
        bankVault.addItem(cell, itemOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemToOccupiedCellTest() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, itemOne);
        bankVault.addItem(cell, itemTwo);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addDuplicateItemTest() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, itemOne);
        bankVault.addItem("B1", itemOne);
    }

    @Test
    public void removeItemSuccessTest() {
        String cell = "A1";
        try {
            bankVault.addItem(cell, itemOne);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        String result = bankVault.removeItem(cell, itemOne);
        Assert.assertEquals("Remove item:ID001 successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemFromNonexistentCellTest() {
        String cell = "Z9";
        bankVault.removeItem(cell, itemOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonexistentItemFromCellTest() {
        String cell = "A1";
        bankVault.removeItem(cell, itemOne);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addDuplicateItemToDifferentCellTest() throws OperationNotSupportedException {
        String cell1 = "A1";
        String cell2 = "B1";
        bankVault.addItem(cell1, itemOne);
        bankVault.addItem(cell2, itemOne);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemToCellWithNonNullValueTest() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, itemOne);
        bankVault.addItem(cell, itemTwo);
    }

    @Test
    public void removeItemFromEmptyCellTest() {
        String cell = "A1";
        String result = bankVault.removeItem(cell, itemOne);
        Assert.assertEquals("Remove item:ID001 successfully!", result);
    }

    @Test
    public void removeItemWithSameReferenceFromCellTest() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, itemOne);
        String result = bankVault.removeItem(cell, itemOne);
        Assert.assertEquals("Remove item:ID001 successfully!", result);
    }

    @Test
    public void addItemAndGetVaultCellsTest() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, itemOne);
        Assert.assertEquals(itemOne, bankVault.getVaultCells().get(cell));
    }

    @Test
    public void removeItemAndGetVaultCellsTest() throws OperationNotSupportedException {
        String cell = "A1";
        bankVault.addItem(cell, itemOne);
        bankVault.removeItem(cell, itemOne);
        Assert.assertNull(bankVault.getVaultCells().get(cell));
    }
}
