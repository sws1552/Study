package s.w.s.board;

public class test {

	public static boolean isNumber(String test) {
		boolean flag = true;
		
		try {
			Double.parseDouble(test);
			flag = false;
			System.out.println("숫자 입니다.");
		}catch(NumberFormatException e) {
			flag = true;
			System.out.println("숫자가 아닙니다.");
		}
			
		
		
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("아아"));
	}

}
