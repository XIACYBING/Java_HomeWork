package designPattern.imooc.FactoryPattern;

public class HNFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO �Զ����ɵķ������
		return new HNBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO �Զ����ɵķ������
		return new HNGirl();
	}

}
