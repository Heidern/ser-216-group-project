package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.*;

public class StatsIntegrationTest {

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
		
	}

}
