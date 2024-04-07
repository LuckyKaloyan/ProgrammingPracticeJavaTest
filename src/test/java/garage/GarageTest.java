package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class GarageTest {
    private Garage garage;
    private Car car1;
    private Car car2;
    private Car car3;

    @Before
    public void setUp() {
        garage = new Garage();
        car1 = new Car("Toyota", 150, 20000);
        car2 = new Car("BMW", 200, 30000);
        car3 = new Car("Mercedes", 180, 25000);
    }

    @Test
    public void addCarTest() {
        garage.addCar(car1);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test
    public void findAllCarsWithMaxSpeedAboveTest() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> result = garage.findAllCarsWithMaxSpeedAbove(170);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(car2));
        Assert.assertTrue(result.contains(car3));
    }

    @Test
    public void getTheMostExpensiveCarTest() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals(car2, mostExpensiveCar);
    }

    @Test
    public void findAllCarsByBrandTest() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> result = garage.findAllCarsByBrand("BMW");
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(car2, result.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullCarTest() {
        garage.addCar(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAllCarsWithMaxSpeedAboveNegativeSpeedTest() {
        garage.findAllCarsWithMaxSpeedAbove(-100);
    }

    @Test
    public void getTheMostExpensiveCarEmptyGarageTest() {
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertNull(mostExpensiveCar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findAllCarsByBrandNullBrandTest() {
        garage.findAllCarsByBrand(null);
    }
}
