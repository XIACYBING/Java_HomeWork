package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class VIP implements FinalPrice {

	@Override
	public double finalPrice(double originalPrice) {
		// TODO Auto-generated method stub
		return originalPrice*0.9;
	}

}
