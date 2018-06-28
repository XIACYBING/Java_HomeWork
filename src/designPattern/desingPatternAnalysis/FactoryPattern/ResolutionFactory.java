package designPattern.desingPatternAnalysis.FactoryPattern;

public interface ResolutionFactory {
	
	public DisplayDriver getDisplayDriver();
	
	public PrinterDriver getPrinterDriver();
	
}
