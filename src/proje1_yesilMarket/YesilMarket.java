package proje1_yesilMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {
	
	public static List<String> ürünler=new ArrayList<>();  // Global
	public static List<Double> fiyatlar=new ArrayList<>();
	
	public static List<String> sepetÜrünler=new ArrayList<>(); 
	public static List<Double> sepetKg=new ArrayList<>();
	public static List<Double> sepetFiyatlar=new ArrayList<>();
	
	public static void main(String[] args) {
		/* Yeşil Market alış-veriş programı.
         * 
         * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
         *          No      Ürün         Fiyat
                  ====  =======        =========
                    00   Domates       2.10 TL 
                    01   Patates       3.20 TL
                    02   Biber         1.50 TL
                    03   Soğan         2.30 TL
                    04   Havuç         3.10 TL
                    05   Elma          1.20 TL
                    06   Muz           1.90 TL
                    07   Çilek         6.10 TL
                    08   Kavun         4.30 TL
                    09   Üzüm          2.70 TL
                    10   Limon         0.50 TL
                    
         * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
         * 3. Adım: Kaç kg satın almak istediğini sorunuz.
         * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
         * 5. Başka bir ürün alıp almak istemediğini sorunuz.
         * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
         * 7. Eğer bitirmek istiyorsa ödeme kısmına geçiniz ve ödem sonrasında programı bitirinzi.
		 */
		Scanner scan=new Scanner(System.in);
		ürünler.addAll(Arrays.asList("Domates","Patates","Biber","Soğan","Havuc","Elma",
													"Muz","Cilek","Kavun","Üzüm","Limon"));
		fiyatlar.addAll(Arrays.asList(2.10,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50));
		
		double toplam=0;
		int sayac=0;
		String karar="";
		do {
			sayac++;
			ürünListele();

			System.out.println("Ürününüzü numaraya göre seciniz");
			int ürünNo=scan.nextInt();
				
			System.out.println("Almak istediginiz kilogrami giriniz");
			double kg=scan.nextDouble();

			sepeteEkle(ürünNo,kg);
			toplam+=sepetFiyatlar.get(0);
			
			System.out.println();
			
			System.out.println("Alisverise devam etmek istiyorsaniz 'E', istemiyorsaniz 'H' yaziniz");
			karar=scan.next();
			if (!karar.equalsIgnoreCase("E")&&!karar.equalsIgnoreCase("H")) {
				System.out.println("Hatali giris yaptiniz.");
			} 
		
		} while (karar.equalsIgnoreCase("E"));
				
			System.out.println("Ödemeniz gereken tutar= "+toplam+"$");
		
		
		
	}
	public static void ürünListele() {
		System.out.println("No\tÜrünler\t     Fiyatlar");
		System.out.println("==\t=======\t     ========");
		
		for (int i = 0; i < ürünler.size(); i++) {
			System.out.println(i+"\t"+ürünler.get(i)+"\t       "+fiyatlar.get(i));
		}
		
		
	}
	public static void sepeteEkle(int ürünNo, double kg) {
		
		sepetÜrünler.add(ürünler.get(ürünNo));
		sepetKg.add(kg);
		sepetFiyatlar.add(fiyatlar.get(ürünNo)*kg);
		System.out.println(sepetKg.get(0)+"kg "+sepetÜrünler.get(0)+"= "+sepetFiyatlar.get(0)+"$");
		
	}

}