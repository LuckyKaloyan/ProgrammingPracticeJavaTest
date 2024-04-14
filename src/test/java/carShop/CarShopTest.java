package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CarShopTest {

    private Car CarOne;
    private Car CarTwo;
    private CarShop carShop;


    @Before
    public void setUp(){
        CarOne = new Car("ModelOne",100,1000);
        CarTwo = new Car("ModelTwo", 200, 2000);
        carShop = new CarShop();
    }

    @Test
    public void getCarsTest(){
        setUp();
        carShop.add(CarOne);
        carShop.add(CarTwo);

        List<Car> check = new ArrayList<>();
        check.add(CarOne);
        check.add(CarTwo);
        Assert.assertEquals(carShop.getCars(), Collections.unmodifiableList(check));
        carShop.getCars();
    }

    @Test
    public void getCountTest(){
        setUp();
        carShop.add(CarOne);
        carShop.add(CarOne);
        carShop.add(CarOne); carShop.add(CarOne);
        Assert.assertEquals(carShop.getCount(),4);
    }

    @Test
    public void findAllCarsWithMaxHorsePower(){
        setUp();
        carShop.add(CarOne);
        carShop.add(CarTwo);
        carShop.add(CarOne);
        CarShop carShopTwo = new CarShop();
        carShopTwo.add(CarOne);
        carShopTwo.add(CarTwo);
        carShopTwo.add(CarOne);
        carShop.add(new Car("GT",0,3));
        carShop.add(new Car("GT",1,3));
        carShop.add(new Car("GT",2,3));

        Assert.assertEquals(carShop.findAllCarsWithMaxHorsePower(55),carShopTwo.getCars());
    }

    @Test(expected = NullPointerException.class)
    public void addCarFailTest(){
        carShop.add(null);
    }

    @Test
    public void addCarSuccessTest(){
        carShop = new CarShop();
        Car car = new Car("X",1,1);
        carShop.add(CarOne);
        carShop.add(CarTwo);
        carShop.add(car);
        Assert.assertTrue(carShop.getCars().contains(car));
    }

    @Test
    public void removeCarSuccessTest(){
        setUp();
        carShop.add(CarOne);
        carShop.add(CarTwo);
        Assert.assertTrue(carShop.getCars().contains(CarOne));
        Assert.assertTrue(carShop.getCars().contains(CarTwo));
        carShop.remove(CarOne);

        Assert.assertFalse(carShop.getCars().contains(CarOne));
        Assert.assertTrue(carShop.remove(CarTwo));
    }

    @Test
    public void getTheMostLuxuryCarTest(){
        setUp();
        carShop.add(CarOne);
        carShop.add(CarTwo);
        Car lamboto = new Car("Lamboto",999,999999);
        carShop.add(lamboto);

        Assert.assertEquals(carShop.getTheMostLuxuryCar(),lamboto);
    }


    @Test
    public void findAllCarsByModelTest(){
        setUp();
        carShop.add(CarOne);
        carShop.add(CarOne);
        carShop.add(CarTwo);
        Car car = new Car("K", 1,2);
        Car cartwo = new Car("K", 2, 4);

        carShop.add(car);
        carShop.add(cartwo);

        Collection<Car> newCollection = new ArrayList<>();
        newCollection.add(car);
        newCollection.add(cartwo);
        Assert.assertEquals(carShop.findAllCarByModel("K"),newCollection);

    }








}
