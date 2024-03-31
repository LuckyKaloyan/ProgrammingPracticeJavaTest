package RPG_LAB;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroTest  {

      public static final String HERONAME = "Hero";
    private static final int DEFAULT_EXP = 1000;
    private static final int DEFAULT_DUMMY_HEALTH = 10;
    Hero hero;
    Dummy dummy;
    @Before
    public void setHero(){
       hero = new Hero(HERONAME);
    }
    @Before public void setDummy(){
        dummy = new Dummy(DEFAULT_DUMMY_HEALTH,DEFAULT_EXP);
    }

    @Test
    public void GetName() {
        setHero();
        Assert.assertEquals(hero.getName(),HERONAME);
    }

    @Test
    public void GetExperience() {
        setHero();
        setDummy();
        hero.attack(dummy);
        Assert.assertEquals(10,hero.getExperience());
    }
    @Test
    public void GetWeapon() {
        setHero();
        Assert.assertEquals(10,hero.getWeapon().getAttackPoints());
    }

}