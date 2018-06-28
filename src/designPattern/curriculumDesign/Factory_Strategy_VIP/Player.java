package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class Player {
	
	private double totalAmount;
	private double amount;
	private FinalPrice fp=new Original();
	
	public Player(){
		System.out.println("----------当当网--------");
	}
	
	public void buy(double amount){
		this.amount=amount;
		totalAmount+=amount;
		fp=VIPFactory.getVIP(this);
	}
	
	public String getFinalPrice(){
		return "你只需要付款"+fp.finalPrice(amount)+"元.就可以获得原价"+this.amount+"元的商品。";
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public double getAmount() {
		return amount;
	}

}
