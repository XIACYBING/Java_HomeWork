package designPattern.imooc.FactoryPattern;

public class MCFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		// TODO 自动生成的方法存根
		return new MCBoy();
	}

	@Override
	public Girl getGirl() {
		// TODO 自动生成的方法存根
		return new MCGirl();
	}

}
