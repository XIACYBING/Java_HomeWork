package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class Client {

	public static void main(String[] args){
		Player player=new Player();
		player.buy(100000);
		System.out.println(player.getFinalPrice());
	}
	
}
