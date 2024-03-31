package RPG_LAB;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class AxeTest  {

    private static final int DEFAULT_EXP = 1000;
    private static final int DEFAULT_DUMMY_HEALTH = 10;
    private static final int DEFAULT_AXE_DURABILITY = 10;
    private static final int DEFAULT_AXE_ATTACK_POINTS = 10;

    Axe axe;
    Dummy dummy;

    @Before
    public void setUp(){
        axe = new Axe(DEFAULT_AXE_ATTACK_POINTS,DEFAULT_AXE_DURABILITY);
        dummy  = new Dummy(DEFAULT_DUMMY_HEALTH,DEFAULT_EXP);

    }


    @Test
    public void testGetAttackPoints() {
        setUp();
        Assert.assertEquals("AxeAttackPointsDoNotMatch",10,axe.getAttackPoints());
    }

    @Test
    public void testGetDurabilityPoints() {
        setUp();
        Assert.assertEquals("AxeDurabilityAfterAttackDoesn'tMatch",10,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        Axe axe1 = new Axe(10, 1);
        Dummy dummy1 = new Dummy(10, 10);
        axe1.attack(dummy1);
        axe1.attack(dummy1);
    }
}