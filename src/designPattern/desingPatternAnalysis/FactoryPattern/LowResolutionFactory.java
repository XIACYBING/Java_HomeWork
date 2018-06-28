package designPattern.desingPatternAnalysis.FactoryPattern;

public class LowResolutionFactory implements ResolutionFactory {

	@Override
	public DisplayDriver getDisplayDriver() {
		// TODO 自动生成的方法存根
		return new LowResolutionDisplayDriver();
	}

	@Override
	public PrinterDriver getPrinterDriver() {
		// TODO 自动生成的方法存根
		return new LowResolutionPrinterDriver();
	}

}
