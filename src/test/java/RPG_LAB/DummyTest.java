package RPG_LAB;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DummyTest extends TestCase {

    private static final int DEFAULT_EXP = 1000;
    public static final String DEFAULT_HERONAME = "Hero";

    public void testAliveDummyCantGiveXP() {
        Dummy dummy = new Dummy( 11,DEFAULT_EXP);
        Hero hero = new Hero(DEFAULT_HERONAME);
       hero.attack(dummy);
       Assert.assertEquals("Alive dummy should not give exp", 0,hero.getExperience());
    }

    public void testDummyLosesHealthWhenAttacked() {
        Dummy dummy = new Dummy(20,DEFAULT_EXP);
        Axe axe = new Axe(10, 10);
        axe.attack(dummy);
        Assert.assertEquals("Dummy has issues with calculating health when attacked",10,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class )
    public void testDeadDummyAttackedException() {
        Dummy dummy = new Dummy( 20, DEFAULT_EXP);
        Axe axe = new Axe(12,20);
        dummy.takeAttack(axe.getAttackPoints());

    }

    @Test public void testDeadDummyGiveExp() {
        Dummy dummy = new Dummy(10,DEFAULT_EXP);
        Hero hero = new Hero(DEFAULT_HERONAME);
        hero.attack(dummy);

        Assert.assertEquals("Dummy has exp giving issues",1000, hero.getExperience());
    }
}