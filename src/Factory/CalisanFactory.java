package Factory;
import Personel.*;

public class CalisanFactory {
    private String id;
    private String isim;
    private String soyisim;
    private Cinsiyet cinsiyet;
    private Cinsiyet cocukCinsiyet;
    private int brutMaas;
    private int avans;
    private int bebekAylık;
    private boolean hamilelikDurumu;
    public CalisanFactory(String id, String ad, String soyad, int brutMaas, Cinsiyet cinsiyet, int avans, boolean hamile, String cocukCinsiyeti, int bebekAylık, String unvan)
    {
        this.id=id;
        this.isim=ad;
        this.soyisim=soyad;
        this.cinsiyet=cinsiyet;
        this.brutMaas=brutMaas;
        this.avans=avans;
        this.hamilelikDurumu=hamile;
        this.cocukCinsiyet=cocukCinsiyet;
        this.bebekAylık = bebekAylık;

    }
    public static Calisan createCalisan(String id, String ad, String soyad, int brutMaas, Cinsiyet cinsiyet, int avans, boolean hamile, Cinsiyet cocukCinsiyeti, int bebekAylık, String unvan) {
        Calisan calisan = null;
        switch (unvan.toUpperCase())
        {
            case "WORKER":
                calisan = new Worker.Builder(id,ad)
                        .soyİsim(soyad)
                        .cinsiyet(cinsiyet)
                        .brutMaas(brutMaas)
                        .avans(avans)
                        .hamilelikDurumu(hamile)
                        .cocukCinsiyeti(cocukCinsiyeti)
                        .bebekAylık(bebekAylık)
                        .build();
                break;
            case "SERVANT":
                calisan = new Servant.Builder(id,ad)
                        .soyİsim(soyad)
                        .cinsiyet(cinsiyet)
                        .brutMaas(brutMaas)
                        .avans(avans)
                        .hamilelikDurumu(hamile)
                        .cocukCinsiyeti(cocukCinsiyeti)
                        .bebekAylık(bebekAylık)
                        .build();
                break;
            case "MANAGER":
                calisan = new Manager.Builder(id,ad)
                        .soyİsim(soyad)
                        .cinsiyet(cinsiyet)
                        .brutMaas(brutMaas)
                        .avans(avans)
                        .hamilelikDurumu(hamile)
                        .cocukCinsiyeti(cocukCinsiyeti)
                        .bebekAylık(bebekAylık)
                        .build();
                break;
            default:
                throw new IllegalArgumentException("Geçersiz unvan: " + unvan);
        }
        return calisan;
    }
}
