import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
            
            String nama;
            int golongan, jam_kerja, jam_lembur, gaji_pokok, gaji_lembur, tunjangan;
            double pajak_gaji_pokok, pajak_lembur, total_pajak, gaji_bersih;

            System.out.println("\n");
            System.out.println("PROGRAM MENGHITUNG GAJI KARYAWAN");
            System.out.println("--------------------------------");

            System.out.print("Masukan Nama : ");
            nama = input.next();

            System.out.print("Masukan Golongan : ");
            golongan = input.nextInt();

            System.out.print("Masukan Jam Kerja : ");
            jam_kerja = input.nextInt();

            switch(golongan){
                case 1 : 
                        gaji_pokok=3000000;
                        tunjangan=250000;
                        break;
                case 2 :
                        gaji_pokok=3500000;
                        tunjangan=300000;
                        break;
                case 3 :
                        gaji_pokok=4000000;
                        tunjangan=350000;
                        break;
                case 4 :
                        gaji_pokok=4500000;
                        tunjangan=400000;
                        break;
                default :
                        gaji_pokok=0;
                        tunjangan=0;
            }

            if (jam_kerja > 173){
                jam_lembur = jam_kerja - 173;	
            }else{
                 jam_lembur = 0;
            }

            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);

            gaji_lembur = jam_lembur * 20000;
            pajak_gaji_pokok = 0.05 * gaji_pokok;
            pajak_lembur = 0.05 * gaji_lembur;
            total_pajak = pajak_gaji_pokok + pajak_lembur;
            gaji_bersih = ((gaji_pokok + tunjangan + gaji_lembur) - total_pajak);

            System.out.println("\n");
            System.out.println("Nama                 : " + nama);
            System.out.println("Gaji Pokok           : " + kursIndonesia.format(gaji_pokok));
            System.out.println("Gaji Lembur          : " + kursIndonesia.format(gaji_lembur));
            System.out.println("Pajak Gaji Pokok     : " + kursIndonesia.format(pajak_gaji_pokok));
            System.out.println("Pajak Lembur         : " + kursIndonesia.format(pajak_lembur));
            System.out.println("Total Pajak          : " + kursIndonesia.format(total_pajak));
            System.out.println("Tunjangan Pengabdian : " + kursIndonesia.format(tunjangan));
            System.out.println("Gaji Diterima        : " + kursIndonesia.format(gaji_bersih));
  }  
}
