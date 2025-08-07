package repository;

import factory.CalisanFactory;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Repo {
    static List<Calisan> calisanlar = new ArrayList<>();

    public static List<Calisan> getAll()
    {
            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\\\Bordro_csv\\\\kullanicilar_unvan.csv"))) {
                String line = br.readLine(); // başlık geç
                while ((line = br.readLine()) != null) {
                    String[] cols = line.split(";", -1);
                    String id = cols[0];
                    String ad = cols[1];
                    String soyad = cols[2];
                    int brutMaas = Integer.parseInt(cols[3]);
                    Cinsiyet cinsiyet = Cinsiyet.valueOf(cols[4]);
                    int avans = Integer.parseInt(cols[5]);
                    String unvan = cols[6].toUpperCase();
                    boolean hamile = cols[7].equalsIgnoreCase("EVET");
                    Cinsiyet cocukCinsiyeti = Cinsiyet.valueOf(cols[8]);
                    int cocukAylık = Integer.parseInt(cols[9]);
                    Calisan calisan = CalisanFactory.createCalisan(id, ad, soyad, brutMaas, cinsiyet, avans, hamile, cocukCinsiyeti, cocukAylık, unvan);
                    System.out.printf("%s %s %s %s (%s): maaş=%d₺, avans=%d₺, hamile mi=%s \n",
                            id, ad, soyad, cinsiyet, unvan, brutMaas, avans, hamile);
                    calisanlar.add(calisan);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        return calisanlar;
    }

   /* public static Calisan getById(String id)
    {
        System.out.println(getAll().size());
        for(Calisan c:getAll())
        {
            if (c.getId().trim().equals(id.trim()))
            {
                return c;
            }
        }
        return null;
    }*/



}
