package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class VIPFactory {
	
	public VIPFactory(){
		
	}
	
	public static FinalPrice getVIP(Player player){
		if(player.getTotalAmount()>=150000){		//消费超过三万，升级为VIP，往后的消费全部九折
			System.out.println("欢迎Gold会员！您将享受七折优惠！");
			return new GoldVIP();
		}else if(player.getTotalAmount()>=90000){		//消费超过九万，升级为超级VIP，往后的消费全部八折
			System.out.println("欢迎Super会员！您将享受八折优惠！");
			return new SuperVIP();
		}else if(player.getTotalAmount()>=30000){		//消费超过十五万，升级为黄金VIP，往后的消费全部七折
			System.out.println("欢迎VIP会员！您将享受九折优惠！");
			return new VIP();
		}else{
			System.out.println("欢迎普通会员！");
			return new Original();
		}
	}
	
}
