package designPattern.desingPatternAnalysis.FactoryPattern;

public class HighResolutionFactory implements ResolutionFactory {

	@Override
	public DisplayDriver getDisplayDriver() {
		// TODO 自动生成的方法存根
		return new HighResolutionDisplayDriver();
	}

	@Override
	public PrinterDriver getPrinterDriver() {
		// TODO 自动生成的方法存根
		return new HighResolutionPrinterDriver();
	}

}
