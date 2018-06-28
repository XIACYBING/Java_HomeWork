package designPattern.desingPatternAnalysis.FactoryPattern;

public class Client {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ResolutionFactory lrf=new LowResolutionFactory();
		DisplayDriver lrdd=lrf.getDisplayDriver();
		lrdd.display();
		PrinterDriver lrpd=lrf.getPrinterDriver();
		lrpd.printer();
		ResolutionFactory hrf=new HighResolutionFactory();
		DisplayDriver hrdd=hrf.getDisplayDriver();
		hrdd.display();
		PrinterDriver hrpd=hrf.getPrinterDriver();
		hrpd.printer();
	}

}
