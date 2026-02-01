package services;

import model.Calisan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RaporExporter {

    public static void exportRapor(List<Calisan> calisanlar) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("maas_bilgileri_base.csv"))) {
            bw.write("ID;AD;SOYAD;AVANS;SSK_Primi;Gelir_Vergisi;Net_Maas");
            bw.newLine();
            for (Calisan c : calisanlar) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
