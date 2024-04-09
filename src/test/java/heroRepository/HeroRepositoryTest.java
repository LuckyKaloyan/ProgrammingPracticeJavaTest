package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hero1 = new Hero("Superman", 100);
        hero2 = new Hero("Batman", 90);
        hero3 = new Hero("Wonder Woman", 95);
    }

    @Test
    public void addHeroTest() {
        heroRepository.create(hero1);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test
    public void getHeroWithHighestLevelTest() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        Hero highestLevelHero = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero1, highestLevelHero);
    }

    @Test
    public void getHeroTest() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        Hero foundHero = heroRepository.getHero("Batman");
        Assert.assertEquals(hero2, foundHero);
    }

    @Test
    public void removeHeroTest() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        boolean isRemoved = heroRepository.remove("Batman");
        Assert.assertTrue(isRemoved);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test
    public void getHeroesTest() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        Collection<Hero> heroes = heroRepository.getHeroes();
        Assert.assertEquals(3, heroes.size());
    }

    @Test(expected = NullPointerException.class)
    public void addNullHeroTest() {
        heroRepository.create(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeNullHeroTest() {
        heroRepository.remove(null);
    }

    @Test
    public void removeNonExistingHeroTest() {
        boolean isRemoved = heroRepository.remove("Flash");
        Assert.assertFalse(isRemoved);
    }
}
