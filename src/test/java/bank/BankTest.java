package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
   private Bank bank;
   private Client clientOne;
   private Client clientTwo;

    String DEFAULT_BANK_NAME = "BestBank";
    int DEFAULT_CAPACITY = 10;

    @Before
    public void setUp(){
        bank = new Bank(DEFAULT_BANK_NAME,DEFAULT_CAPACITY);
        clientOne = new Client("Ivan");
        clientTwo = new Client("Georgi");
    }
    @Test(expected = NullPointerException.class)
    public void testNameSetter(){
        new Bank(null,10);
    }

    @Test
    public void constructorTest(){
        setUp();
        Assert.assertEquals(bank.getName(),"BestBank");
        Assert.assertEquals(bank.getCapacity(),10);
    }

    @Test
    public void getNameTest(){
        setUp();
        Assert.assertEquals(bank.getName(),"BestBank");
    }
    @Test(expected = IllegalArgumentException.class)
    public void setCapacityTest(){
        bank = new Bank("TestName", -5);
    }

    @Test
    public void getCountTest(){
        setUp();
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
        Assert.assertEquals(bank.getCount(),2);
    }

    @Test
    public void getCapacityTest(){
        setUp();
        Assert.assertEquals(bank.getCapacity(),10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addClientTest(){
        bank = new Bank("NewBank",3);
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNullTest(){
        setUp();
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
        bank.removeClient(clientOne.getName());
        bank.removeClient(clientOne.getName());
    }

    @Test
    public void removeClientSuccessTest() {
        bank.addClient(clientOne);
        bank.removeClient(clientOne.getName());
        Assert.assertEquals(0, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void loanWithdrawTest(){
        setUp();
        bank.loanWithdrawal("Kebab");
    }

    @Test
    public void getStatisticsTest(){
        setUp();
        bank.statistics();
    }








    }

