package designPattern.imooc.FactoryPattern;

public class MCFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO �Զ����ɵķ������
		return new MCBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO �Զ����ɵķ������
		return new MCGirl();
	}

}
