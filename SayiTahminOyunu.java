import java.util.Scanner;
 
public class SayiTahminOyunu 
{
	public static int rand_sayi()
	{
		double rnd= Math.random(); /* 0 ile 1 arasında sayi */
		int sayi = (int)(rnd * 100); /* tahmin etmemiz gereken sayi */
		return sayi;
	}
	
	public static int tahmin (int sayi)
	{
		/* Konsoldan girdi alabilmek için */
		Scanner girdi = new Scanner(System.in);
		
		/* Bir tahminde bulunun */
		System.out.print("Bir tahminde bulun? : ");
		
		int tahmin_sayisi = 0, tahmin_hakki = 15;	
		
		/* tahmin hakki dolana kadar döngü devam edecek */
		while(tahmin_sayisi < tahmin_hakki) 
		{	
			int tahmin = girdi.nextInt();
			++tahmin_sayisi;
			
			if ( tahmin == sayi )
			{
				System.out.println("Tebrikler doğru tahmin ettin : " + tahmin +
										"\n tahmin sayisi : " + tahmin_sayisi);
				return 0;
			}
			else 
			{
				if(tahmin > sayi) 
					System.out.print( tahmin + "'den daha küçük bir sayı girmelisin!  : ");
				else
					System.out.print(tahmin + "'den daha büyük bir sayı girmelisin!  : ");
			}
			
		}/* while sonu */
		return 1;
		}
		
	public static void main(String[] args) {
		
		int sayi = rand_sayi();
		
		int tahmin = tahmin(sayi);
		if ( tahmin == 1)
			System.out.println("malesef " + 15 +
							" tahmin hakkiniz dolmustur :((");
		
	}
}
