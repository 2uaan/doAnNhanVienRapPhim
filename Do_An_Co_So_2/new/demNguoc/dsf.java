package demNguoc;

public class dsf {
	public static void main(String[] args) {
		String hthi ="";
		int h = 1, m = 0, s= 10;
		
		int soGiay = h*3600 + m*60 + s;
		
		while (soGiay >= 0) {
			hthi = "";
			if (h<10) 	hthi += "0" + h;
			else	hthi += h ;
			if (m<10) 	hthi += ":0" + m;
			else	hthi += ":" + m;
			if (s<10) 	hthi += ":0" + s;
			else	hthi +=  ":" + s;
			
			
			System.out.println(hthi);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			s--;
			soGiay--;
			if (s == -1) {
				s= 59;
				m--;
			}
			if (m == -1) {
				m =  59;
				h--;
			}
		}
	}
}
