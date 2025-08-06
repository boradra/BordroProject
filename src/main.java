import Personel.*;
import Services.CsvReader;
import Services.CsvWriter;
import Services.MaasHesaplayıcı;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Calisan> calisanlar = new ArrayList<>();
        CsvReader csvReader = new CsvReader();
        CsvWriter csvWriter = new CsvWriter();
        MaasHesaplayıcı maasHesaplayıcı = new MaasHesaplayıcı();

        csvReader.oku(calisanlar);

        for(Calisan calisan : calisanlar)
        {
            calisan.MaasUygula();
        }
        csvWriter.yaz(calisanlar);
    }
}
