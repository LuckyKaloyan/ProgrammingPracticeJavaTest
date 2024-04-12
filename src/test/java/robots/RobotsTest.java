package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class RobotsTest {

    private Robot robotOne;
    private Robot robotTwo;
    private Service service;

    private static int DEFAULT_CAPACITY_VALUE = 5;
    private static String DEFAULT_SERVICE_NAME = "Default_Service";
    private static String ROBOT_ONE_NAME = "RobotOne";
    private static String ROBOT_TWO_NAME = "RobotTwo";



    @Before
    public void setUp(){
        service = new Service(DEFAULT_SERVICE_NAME,DEFAULT_CAPACITY_VALUE);
        robotOne = new Robot(ROBOT_ONE_NAME);
        robotTwo = new Robot(ROBOT_TWO_NAME);
    }


    @Test
    public void constructorTest(){
        setUp();
        Assert.assertEquals(service.getName(),DEFAULT_SERVICE_NAME);
        Assert.assertEquals(service.getCapacity(),DEFAULT_CAPACITY_VALUE);
    }

    @Test(expected = NullPointerException.class)
    public void setNameTest(){
        service = new Service(null,5);
    }
    @Test
    public void getNameTest(){
        setUp();
        Assert.assertEquals( service.getName(),DEFAULT_SERVICE_NAME);
    }
    @Test
    public void getCapacityTest(){
        setUp();
        Assert.assertEquals(service.getCapacity(),DEFAULT_CAPACITY_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityTest(){
        service = new Service(DEFAULT_SERVICE_NAME,-5);
    }

    @Test
    public void getCountTest(){
        setUp();
        service.add(robotOne);
        service.add(robotTwo);

        Assert.assertEquals(service.getCount(),2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRobotTestFail(){
        setUp();
        service.add(robotOne);
        service.add(robotOne);
        service.add(robotOne);
        service.add(robotOne);
        service.add(robotOne);
        service.add(robotOne);
    }
    @Test
    public void addRobotTestSuccess(){
        setUp();
        service.add(robotOne);
        service.add(robotTwo);
        Assert.assertEquals(service.getCount(),2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeRobotTestFail(){
        setUp();
        service.remove(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeRobotTestFailTwo(){
        setUp();
        service.remove("kebabche");
    }

    @Test
    public void removeRobotTestSuccess(){
        setUp();
        service.add(robotOne);
        service.remove("RobotOne");
        Assert.assertEquals(service.getCount(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forSaleTestFail(){
        setUp();
        service.add(robotOne);
        service.add(robotTwo);
        service.forSale("RobotThree");
    }
    @Test
    public void forSaleTestSuccessful(){
        Service service = new Service(DEFAULT_SERVICE_NAME, 1);
        Robot robot = new Robot("RobotTest");
        service.add(robot);
        service.forSale("RobotTest");

        assertFalse(robot.isReadyForSale());
    }


    @Test
    public void reportTestSuccess(){
setUp();
service.add(robotOne);
service.add(robotTwo);
        String rightOutput = String.format("The robot RobotOne, RobotTwo is in the service %s!", service.getName());

Assert.assertEquals(rightOutput,service.report());

    }







}
