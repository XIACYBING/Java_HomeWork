package designPattern.imooc.FactoryPattern;

public class Client {
	
	public static void main(String[] args){
		PersonFactory hnfactory=new HNFactory();
		Boy hnb=hnfactory.getBoy();
		hnb.drawMan();
		Girl hng=hnfactory.getGirl();
		hng.drawWomen();
		PersonFactory mcfactory=new MCFactory();
		Boy mcb=mcfactory.getBoy();
		mcb.drawMan();
		Girl mcg=mcfactory.getGirl();
		mcg.drawWomen();
	}
	
}
