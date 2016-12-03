package test;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.*;

public class SolitaireBoardIntegrationTest {

	private final String statsFilePath = System.getProperty("user.home") + System.getProperty("file.separator") + "frs-statistics.dat";
		
	private File statsFile;
	
	@Before
	public void setUp() throws Exception {
        statsFile = new File(statsFilePath);
        
        if (statsFile.exists ()) statsFile.delete ();
	}

	@After
	public void tearDown() throws Exception {			
		statsFile.delete ();
	}

	@Test
	public void recordGame_withLoss_shouldUpdateLossStats () {
		
		//create new instance of SolitaireBoard class		
		SolitaireBoard board = new SolitaireBoard (false);
		
		//set default difficulty and draw count		
		board.setDifficulty(2);
		board.setDrawCount(1);

		//record loss
		board.recordGame(SolitaireBoard.GAME_LOST);
		
		//make sure that stats file exists		
		assertTrue (statsFile.exists());
		
		try {
			//make sure loss was recorded properly
			DataInputStream input = new DataInputStream(new FileInputStream(statsFile));	
			
			int currentField = 0;
			
			while (input.available() > 0 && currentField < 31) {
				int value = input.readInt();
				
				switch (currentField) {
				case 0: assertTrue (value == -1); break; //first value should always be -1
				case 6: assertTrue (value == 1); break; //games played - medium
				case 7: assertTrue (value == 0); break; //games won
				case 8: assertTrue (value == 0); break; //win streak
				case 9: assertTrue (value == -1); break; //loss streak
				case 10: assertTrue (value == -1); break; //current streak
				default: break;
				}
				
				currentField++;
			}
			
			input.close();
		}
		catch (Exception e) {
			assertTrue (false);
		}
	}
	
	@Test
	public void recordGame_withResetStats_shouldResetStats () {
		
		//create new instance of SolitaireBoard class		
		SolitaireBoard board = new SolitaireBoard (false);
		
		//set default difficulty and draw count		
		board.setDifficulty(2);
		board.setDrawCount(1);

		//record loss
		board.recordGame(SolitaireBoard.RESET_STATS);
		
		//make sure that stats file exists		
		assertTrue (statsFile.exists());
		
		try {
			//make stats were reset properly
			DataInputStream input = new DataInputStream(new FileInputStream(statsFile));	
			
			int currentField = 0;
			
			while (input.available() > 0 && currentField < 31) {
				int value = input.readInt();
				
				switch (currentField) {
				case 0: assertTrue (value == -1); break; //first value should always be -1
				default: assertTrue (value == 0); break; //all values should be set to 0
				}
				
				currentField++;
			}
			
			input.close();
		}
		catch (Exception e) {
			assertTrue (false);
		}
	}
	
	@Test
	public void recordGame_withWin_shouldUpdateWinStats () {
		
		//create new instance of SolitaireBoard class		
		SolitaireBoard board = new SolitaireBoard (false);
		
		//set default difficulty and draw count		
		board.setDifficulty(2);
		board.setDrawCount(1);

		//record loss
		board.recordGame(SolitaireBoard.GAME_WON);
		
		//make sure that stats file exists		
		assertTrue (statsFile.exists());
		
		try {
			//make sure win was recorded properly
			DataInputStream input = new DataInputStream(new FileInputStream(statsFile));	
			
			int currentField = 0;
			
			while (input.available() > 0 && currentField < 31) {
				int value = input.readInt();
				
				switch (currentField) {
				case 0: assertTrue (value == -1); break; //first value should always be -1
				case 6: assertTrue (value == 1); break; //games played - medium
				case 7: assertTrue (value == 1); break; //games won
				case 8: assertTrue (value == 1); break; //win streak
				case 9: assertTrue (value == 0); break; //loss streak
				case 10: assertTrue (value == 1); break; //current streak
				default: break;
				}
				
				currentField++;
			}
			
			input.close();
		}
		catch (Exception e) {
			assertTrue (false);
		}
	}
	
	@Test
	public void recordGame_withDoNothing_shouldCreateStatsFile () {
		
		//create new instance of SolitaireBoard class		
		SolitaireBoard board = new SolitaireBoard (false);
		
		//set default difficulty and draw count		
		board.setDifficulty(2);
		board.setDrawCount(1);

		//record loss
		board.recordGame(SolitaireBoard.DO_NOTHING);
		
		//make sure that stats file exists		
		assertTrue (statsFile.exists());
	}

}
