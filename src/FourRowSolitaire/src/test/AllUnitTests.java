package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AcePileTest.class, CardStackTest.class, CardTest.class, ChangeAppearanceTest.class,
		ChangeOptionsTest.class, ColumnTest.class, DealDeckTest.class, DeckTest.class, DiscardPileTest.class,
		FireworksDisplayTest.class, FourRowSolitaireTest.class, SingleCellTest.class })

public class AllUnitTests {

}
