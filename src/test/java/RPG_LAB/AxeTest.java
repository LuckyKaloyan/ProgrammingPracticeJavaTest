package RPG_LAB;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AxeTest extends TestCase {

    public void testGetAttackPoints() {
    }

    @Test
    public void testGetDurabilityPoints() {
        Axe axe = new Axe(10,10);
        Dummy dummy = new Dummy (10, 10);
        axe.attack(dummy);
        int durabilityAfterAxeAttack = axe.getDurabilityPoints();
        Assert.assertEquals("AxeDurabiltyAfterAttackDoesntMatch",9,durabilityAfterAxeAttack);
    }

    public void testAttack() {
    }
}