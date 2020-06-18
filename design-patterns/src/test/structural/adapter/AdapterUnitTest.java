package test.structural.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.structural.adapter.CsvFormatter;
import main.structural.adapter.CsvFormatterAdapter;
import main.structural.adapter.NewLineFormatter;
import main.structural.adapter.TextFormattable;

class AdapterUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void When_AdaptedFormatter_ThenCorrect() {
		String text = "Hey world. Bye world";
		TextFormattable newLinFormattable = new NewLineFormatter();
		assertEquals("Hey world\n Bye world", newLinFormattable.formatText(text));
		TextFormattable csvFormattable = new CsvFormatterAdapter(new CsvFormatter());
		assertEquals("Hey world, Bye world", csvFormattable.formatText(text));
	}

}
