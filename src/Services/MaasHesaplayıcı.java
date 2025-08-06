package Services;

import Personel.*;
import java.util.List;

public class MaasHesaplayıcı {

    public void hesapla(List<Calisan> calisanlar)
    {
        for(Calisan calisan : calisanlar)
        {
            calisan.MaasUygula();
        }
    }
}
