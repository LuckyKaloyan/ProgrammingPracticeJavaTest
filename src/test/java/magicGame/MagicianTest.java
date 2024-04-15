package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MagicianTest {

    private Magic magicOne;
    private Magic magicTwo;
    private Magician magician;


    @Before
    public void setUp(){
        magicOne = new Magic("WindStrike", 20);
        magicTwo = new Magic ("IceBolt", 30);
        magician = new Magician("Saronite", 300);
    }

    @Test
    public void setUsernameTestSuccess(){
        setUp();
        Assert.assertEquals(magician.getUsername(),"Saronite");
    }
    @Test(expected = NullPointerException.class)
    public void setUsernameTestFail(){
        magician = new Magician(null, 300);
    }

    @Test
    public void gettersTests(){
        setUp();
        magician.addMagic(magicOne);
        magician.addMagic(magicTwo);
        Assert.assertEquals(magician.getUsername(),"Saronite");
        Assert.assertEquals(magician.getHealth(),300);
        List<Magic> magecs = new ArrayList<>();
        magecs.add(magicOne);
        magecs.add(magicTwo);
        Assert.assertEquals(magician.getMagics(),magecs);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setHealthFailTest(){
        magician = new Magician("Ivan", -5);
    }
    @Test
    public void setHealthSuccessTest(){
        magician = new Magician("Ivan",88);
    }
    @Test(expected = IllegalStateException.class)
    public void takeDamageFailTest(){
        setUp();
        magician.takeDamage(500);
        magician.takeDamage(500);
    }

    @Test
    public void takeDamageSuccessTest(){
        setUp();
        magician.takeDamage(100);
        Assert.assertEquals(magician.getHealth(),200);
        magician.takeDamage(30000);
        Assert.assertEquals(magician.getHealth(),0);
    }

    @Test
    public void addMagicSuccessTest(){
        setUp();
        Magic magicThree = new Magic("GRANADE",9999);
        magician.addMagic(magicThree);
        Assert.assertTrue(magician.getMagics().contains(magicThree));
    }
    @Test(expected = NullPointerException.class)
    public void addMagicFailTest(){
        setUp();
        magician.addMagic(null);
    }

    @Test
    public void removeMagicSuccessTest(){
        setUp();
        magician.addMagic(magicOne);
        magician.addMagic(magicTwo);
        Magic magec = new Magic("Ivan",1);
        Assert.assertTrue(magician.removeMagic(magicOne));
        Assert.assertFalse(magician.removeMagic(magec));
    }

    @Test
    public void getMagicSuccessTest(){
        setUp();
        magician.addMagic(magicOne);
        magician.addMagic(magicTwo);

        Assert.assertEquals(magician.getMagic("WindStrike"),magicOne);

    }

}
