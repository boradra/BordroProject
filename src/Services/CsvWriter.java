package Services;

import Personel.Calisan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvWriter {

    public void yaz(List<Calisan> calisanlar)
    {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("C:\\\\Bordro_csv\\\\maas_bilgileri.csv"))) {
            bw.write("ID;AD;SOYAD;AVANS;SSK_Primi;Gelir_Vergisi;Net_Maas");
            bw.newLine();
            for (Calisan c : calisanlar) {
                String satir = c.toCSVRow();
                bw.write(satir);               // DOSYAYA YAZ
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
