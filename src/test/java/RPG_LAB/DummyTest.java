package RPG_LAB;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int DEFAULT_EXP = 1000;
    private static final int DEFAULT_DUMMY_HEALTH = 10;
    public static final String DEFAULT_HERONAME = "Hero";



    Dummy dummy;
    Hero hero;
    @Before
    public void setUp() {
     dummy = new Dummy(DEFAULT_DUMMY_HEALTH,DEFAULT_EXP);
     hero = new Hero(DEFAULT_HERONAME);
}




    @Test
    public void AliveDummyCantGiveXP() {
         setUp();
        Assert.assertEquals("Alive dummy should not give exp", 0,hero.getExperience());
    }

    @Test
    public void DummyLosesHealthWhenAttacked() {
        Dummy dummy = new Dummy(DEFAULT_DUMMY_HEALTH,DEFAULT_EXP);
        Axe axe = new Axe(10, 10);
        axe.attack(dummy);
        Assert.assertEquals("Dummy has issues with calculating health when attacked",0,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class )
    public void DeadDummyAttackedException() {
        Dummy dummy = new Dummy( DEFAULT_DUMMY_HEALTH, DEFAULT_EXP);
        Axe axe = new Axe(12,20);
        dummy.takeAttack(axe.getAttackPoints());
        dummy.takeAttack(axe.getAttackPoints());
    }

    @Test public void DeadDummyGiveExp() {
        Dummy dummy = new Dummy(DEFAULT_DUMMY_HEALTH,DEFAULT_EXP);
        Hero hero = new Hero(DEFAULT_HERONAME);
        hero.attack(dummy);
        Assert.assertEquals("Dummy has exp giving issues",1000, hero.getExperience());
    }

}