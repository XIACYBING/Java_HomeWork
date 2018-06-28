package designPattern.imooc.FactoryPattern;

public class HNFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO 自动生成的方法存根
		return new HNBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO 自动生成的方法存根
		return new HNGirl();
	}

}
