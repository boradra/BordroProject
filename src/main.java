import Personel.*;
import Services.CsvReader;
import Services.CsvWriter;
import Services.Repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Calisan> calisanlar = Repo.getAll();
        for(Calisan calisan : calisanlar)
        {
            calisan.MaasUygula();
        }
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("C:\\\\Bordro_csv\\\\maas_bilgileri.csv"))) {
            bw.write("ID;AD;SOYAD;AVANS;SSK_Primi;Gelir_Vergisi;Net_Maas");
            bw.newLine();
            for (Calisan c : calisanlar) {
                bw.write(c.toString());               // DOSYAYA YAZ
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
