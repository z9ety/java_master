package chap6;

public class MainExe {
	public static void main(String[] args) {
		
		String[] strs = {"1.adk","2.dfsl","3.af","4.dag","5.saf"};
		int page = 1;
		int start = (page - 1) * 5;
		int end = page * 5;
		
		for(int i=0; i<strs.length; i++) {
			if(i>=0 && i<5) {
				System.out.println(strs[i]);
			}
		}
		int cnt = 32;
		
		int totalpage = (int)Math.ceil(cnt/5.0);
		System.out.println(totalpage);
		for(int i=1; i<=totalpage; i++) {
			System.out.print(i + " ");
		}
	}//end main
}//end class
