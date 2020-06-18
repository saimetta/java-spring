package main.structural.adapter;

public class CsvFormatterAdapter implements TextFormattable {

	private final CsvFormattable csvFormatter;
	
	public CsvFormatterAdapter(CsvFormattable csvFormatter) {
		this.csvFormatter = csvFormatter;
	}
	
	@Override
	public String formatText(String text) {
		return csvFormatter.formatCsvText(text);
	}

}
