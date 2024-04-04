package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTest {

    private Team team;
    private HandballPlayer player1;
    private HandballPlayer player2;

    @Before
    public void setUp() {
        team = new Team("Team A", 5);
        player1 = new HandballPlayer("John");
        player2 = new HandballPlayer("Alice");
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidName() {
        new Team(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPosition() {
        new Team("Team B", -1);
    }

    @Test
    public void testAddPlayer() {
        setUp();
        team.add(player1);
        Assert.assertEquals("Team should have 1 player", 1, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerToFullTeam() {
        setUp();
        for (int i = 0; i < 5; i++) {
            team.add(new HandballPlayer("Player " + (i + 1)));
        }
        team.add(new HandballPlayer("Player 6"));
    }

    @Test
    public void testRemovePlayer() {
        setUp();
        team.add(player1);
        team.add(player2);
        team.remove("John");
        Assert.assertEquals("Team should have 1 player after removal", 1, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingPlayer() {
        setUp();
        team.add(player1);
        team.remove("Alice");
    }

    @Test
    public void testPlayerForAnotherTeam() {
        setUp();
        team.add(player1);
        HandballPlayer removedPlayer = team.playerForAnotherTeam("John");
        Assert.assertFalse("Player should be inactive", removedPlayer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamNonExistingPlayer() {
        setUp();
        team.add(player1);
        team.playerForAnotherTeam("Alice");
    }

    @Test
    public void testGetStatistics() {
        setUp();
        team.add(player1);
        team.add(player2);
        String expectedStatistics = "The player John, Alice is in the team Team A.";
        Assert.assertEquals("Statistics should match", expectedStatistics, team.getStatistics());
    }
}
