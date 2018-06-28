package designPattern.desingPatternAnalysis.FactoryPattern;

public class LowResolutionFactory implements ResolutionFactory {

	@Override
	public DisplayDriver getDisplayDriver() {
		// TODO �Զ����ɵķ������
		return new LowResolutionDisplayDriver();
	}

	@Override
	public PrinterDriver getPrinterDriver() {
		// TODO �Զ����ɵķ������
		return new LowResolutionPrinterDriver();
	}

}
