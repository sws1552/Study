package s.w.s.board;

public class test {

	public static boolean isNumber(String test) {
		boolean flag = true;
		
		try {
			Double.parseDouble(test);
			flag = false;
			System.out.println("���� �Դϴ�.");
		}catch(NumberFormatException e) {
			flag = true;
			System.out.println("���ڰ� �ƴմϴ�.");
		}
			
		
		
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("�ƾ�"));
	}

}
