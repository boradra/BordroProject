package Services;

import Personel.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader {



    public void oku(List<Calisan> calisanlar)
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
                Calisan calisan = switch (unvan) {
                    case "WORKER" -> new Worker.Builder(id, ad)
                            .soyİsim(soyad)
                            .cinsiyet(cinsiyet)
                            .brutMaas(brutMaas)
                            .avans(avans)
                            .hamilelikDurumu(hamile)
                            .cocukCinsiyeti(cocukCinsiyeti)
                            .bebekAylık(cocukAylık)
                            .build();
                    case "MANAGER" -> new Manager.Builder(id, ad)
                            .soyİsim(soyad)
                            .cinsiyet(cinsiyet)
                            .brutMaas(brutMaas)
                            .avans(avans)
                            .hamilelikDurumu(hamile)
                            .cocukCinsiyeti(cocukCinsiyeti)
                            .bebekAylık(cocukAylık)
                            .build();
                    case "SERVANT" -> new Servant.Builder(id, ad)
                            .soyİsim(soyad)
                            .cinsiyet(cinsiyet)
                            .brutMaas(brutMaas)
                            .avans(avans)
                            .hamilelikDurumu(hamile)
                            .cocukCinsiyeti(cocukCinsiyeti)
                            .bebekAylık(cocukAylık)
                            .build();
                    default -> throw new IllegalArgumentException("Bilinmeyen unvan: " + unvan);
                };
                System.out.printf("%s %s %s %s (%s): maaş=%d₺, avans=%d₺, hamile mi=%s \n",
                        id, ad, soyad, cinsiyet, unvan, brutMaas, avans, hamile);
                calisanlar.add(calisan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
