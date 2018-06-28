package designPattern.desingPatternAnalysis.FactoryPattern;

public class HighResolutionFactory implements ResolutionFactory {

	@Override
	public DisplayDriver getDisplayDriver() {
		// TODO �Զ����ɵķ������
		return new HighResolutionDisplayDriver();
	}

	@Override
	public PrinterDriver getPrinterDriver() {
		// TODO �Զ����ɵķ������
		return new HighResolutionPrinterDriver();
	}

}
