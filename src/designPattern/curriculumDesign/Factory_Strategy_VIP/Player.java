package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class Player {
	
	private double totalAmount;
	private double amount;
	private FinalPrice fp=new Original();
	
	public Player(){
		System.out.println("----------������--------");
	}
	
	public void buy(double amount){
		this.amount=amount;
		totalAmount+=amount;
		fp=VIPFactory.getVIP(this);
	}
	
	public String getFinalPrice(){
		return "��ֻ��Ҫ����"+fp.finalPrice(amount)+"Ԫ.�Ϳ��Ի��ԭ��"+this.amount+"Ԫ����Ʒ��";
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public double getAmount() {
		return amount;
	}

}
