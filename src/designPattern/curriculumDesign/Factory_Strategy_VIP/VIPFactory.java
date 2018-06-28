package designPattern.curriculumDesign.Factory_Strategy_VIP;

public class VIPFactory {
	
	public VIPFactory(){
		
	}
	
	public static FinalPrice getVIP(Player player){
		if(player.getTotalAmount()>=150000){		//���ѳ�����������ΪVIP�����������ȫ������
			System.out.println("��ӭGold��Ա���������������Żݣ�");
			return new GoldVIP();
		}else if(player.getTotalAmount()>=90000){		//���ѳ�����������Ϊ����VIP�����������ȫ������
			System.out.println("��ӭSuper��Ա���������ܰ����Żݣ�");
			return new SuperVIP();
		}else if(player.getTotalAmount()>=30000){		//���ѳ���ʮ��������Ϊ�ƽ�VIP�����������ȫ������
			System.out.println("��ӭVIP��Ա���������ܾ����Żݣ�");
			return new VIP();
		}else{
			System.out.println("��ӭ��ͨ��Ա��");
			return new Original();
		}
	}
	
}
