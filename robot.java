import java.util.Scanner;

public class robot {
	int height, weight ;
	int x, y, z;
	int aci;
	int batarya;
	public robot (int boy, int agirlik) {
		height = boy;
		weight = agirlik;
		x = 0; y = 0; z = 0;
		aci = 0;
		batarya = 10;
	}
	void rotate (int derece) {
		if (hareket (2, 360, derece))
			;
		else 
			msg("robot istediginiz olcude donus yapamaz, derecenizi kontrol edin");
		}
		
/*
	public void walk(int k_x, k_y) {
		if (x != k_x || y != k_y) hareket (1, k_x, k_y);
		else msg("robotunuz zaten ayni konumda, farkli bir konum girin");
	} 
*/
	
	boolean hareket(int secim, int k_x, int k_y) {
		double mesafe = Math.sqrt(Math.pow(k_x,2) + Math.pow(k_y,2));
		switch (secim) {
		case 1 : if (batarya >= mesafe) {	/* koordinat yonune hareket*/
					konum(k_x, k_y);
					return true;
				 }
				 else {
					msg("batarya gucu yetersiz");
				    return false;
				 }
		case 2 : if (k_y != 0 && k_y < 360 && k_x == 360) { /* k_y derece donme hareketi */
				 aci += k_y; 
				 return true ;
				 } 
				 else return false;
		}
		return true;
	}
		
	void konum(int k_x, int k_y) {
		boolean durum1 = true, durum2 = true;
		while (durum1 || durum2) {
			if (x < k_x ) x++; else if (x > k_x) x--; else durum1 = false;
			if (y < k_y ) y++; else if (y > k_y) y--; else durum2 = false;
			batarya-- ; 
		}
	}
	void state() {
		msg ("boy :" + height + ", agirlik :" + weight + "  durus yon acisi" + aci);
		msg ("konum-->  x:" + x + "  y:" + y + "  z:" + z);
	}
	
	void msg(String m) {
		System.out.println(m);
	}
	
	public static void main(String[] args) {
		robot r = new robot (175, 70);
		r.state();
		r.hareket(1, -3, 4);
		r.state();
		r.rotate(75);
		r.state();
		r.hareket(2, 360, 150);
		r.state();
		r.hareket(1,0,4);
		r.state();
	}
}
