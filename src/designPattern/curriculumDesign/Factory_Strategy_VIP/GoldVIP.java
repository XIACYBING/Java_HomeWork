package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class GoldVIP implements FinalPrice {

	@Override
	public double finalPrice(double originalPrice) {
		// TODO Auto-generated method stub
		return originalPrice*0.7;
	}

}
