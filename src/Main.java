import model.*;
import services.RaporExporter;
import repository.Repo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Calisan> calisanlar = Repo.getAll();
        for(Calisan calisan : calisanlar)
        {
            calisan.maasUygula();
        }
        RaporExporter.exportRapor(calisanlar);
        /* Deneme */
       /* Calisan arananCalisan = Repo.getById("b79bffc4-21a4-4986-9602-0b59a4f7ce9c");
        List<Calisan> tekCalisanListesi = new ArrayList<>();
        tekCalisanListesi.add(arananCalisan);
        for(Calisan tekCalisan : tekCalisanListesi){
            tekCalisan.MaasUygula();
        }
        RaporExporter.exportRapor(tekCalisanListesi);
        */
    }
}
