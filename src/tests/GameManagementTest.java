package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import management.AddGameScore;
import management.GameManager;

class GameManagementTest {

	@Test
	void gameManagementtest() {
		GameManager gameManager = GameManager.getInstance();
		
		ImageIcon shipIcon = new ImageIcon(GameManagementTest.class.getResource("/images/ship1.png"));
		
		gameManager.initializeManager(3, "Jefferson Starship", shipIcon);
		
		assertEquals(1, gameManager.getCurrentDay());
		assertEquals(0, gameManager.getGameScore());
		assertEquals(3, gameManager.getGameDuration());
		assertEquals(2, gameManager.getPartsToFind());
		assertEquals(0, gameManager.getPartsFound());
		assertEquals(false, gameManager.allPartsFound());
		gameManager.partFound();
		gameManager.partFound();
		assertEquals(true, gameManager.allPartsFound());
		
		new AddGameScore(100);
		assertEquals(100, gameManager.getGameScore());
		
		assertEquals(false, gameManager.endGame());
		gameManager.endGame(false, "lost");
		assertEquals("YOU LOSE!", gameManager.getGameResult());
		assertEquals("lost", gameManager.getGameComment());
		gameManager.endGame(true, "win");
		assertEquals("YOU WIN!", gameManager.getGameResult());
		assertEquals("win", gameManager.getGameComment());
		
		

	}

}
