package Personel;

public class Manager implements Calisan {
    private String id;
    private String isim;
    private String soyisim;
    private Cinsiyet cinsiyet;
    private Cinsiyet cocukCinsiyet;
    private int brutMaas;
    private int avans;
    private int bebekAylık;
    private boolean hamilelikDurumu;
    private double sskPrim, gelirVergisi, netMaas;

    public Manager(String id, String isim, String soyisim, Cinsiyet cinsiyet, int brutMaas, int avans, boolean hamilelikDurumu, Cinsiyet cocukCinsiyet, int bebekAylık) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.brutMaas = brutMaas;
        this.avans = avans;
        this.hamilelikDurumu = hamilelikDurumu;
        this.cocukCinsiyet = cocukCinsiyet;
        this.bebekAylık = bebekAylık;
    }

    public static class Builder {
        private String id;
        private String isim;
        private String soyisim;
        private Cinsiyet cinsiyet;
        private Cinsiyet cocukCinsiyet;
        private int brutMaas;
        private int avans;
        private int bebekAylık;
        private boolean hamilelikDurumu;

        public Builder(String id, String ad) {
            this.id = id;
            this.isim = ad;
        }

        public Builder isim(String isim) { this.isim = isim; return this; }
        public Builder soyİsim(String soyisim) { this.soyisim = soyisim; return this; }
        public Builder cinsiyet(Cinsiyet cinsiyet) { this.cinsiyet = cinsiyet; return this; }
        public Builder cocukCinsiyeti(Cinsiyet cocukCinsiyet) { this.cocukCinsiyet = cocukCinsiyet; return this; }
        public Builder brutMaas(int brutMaas) { this.brutMaas = brutMaas; return this; }
        public Builder avans(int avans) { this.avans = avans; return this; }
        public Builder hamilelikDurumu(boolean hamilelikDurumu) { this.hamilelikDurumu = hamilelikDurumu; return this; }
        public Builder bebekAylık(int bebekAylık) { this.bebekAylık = bebekAylık; return this; }

        public Manager build() {
            return new Manager(this);
        }
    }

    public Manager(Builder builder) {
        this.id = builder.id;
        this.isim = builder.isim;
        this.soyisim = builder.soyisim;
        this.cinsiyet = builder.cinsiyet;
        this.brutMaas = builder.brutMaas;
        this.avans = builder.avans;
        this.hamilelikDurumu = builder.hamilelikDurumu;
        this.cocukCinsiyet = builder.cocukCinsiyet;
        this.bebekAylık = builder.bebekAylık;
    }

    public double MaasUygula() {
        sskPrim = sskHesapla();
        int ekstra = cinsiyetBonusHesapla() + hamilelikBonusuHesapla();
        double vergiMatrahı = brutMaas - sskPrim + ekstra - avans;
        gelirVergisi = gelirVergisiHesapla(vergiMatrahı);
        netMaas = vergiMatrahı - gelirVergisi;
        return netMaas;
    }


    private double sskHesapla() {
        double oran = getSskOrani();
        return brutMaas * oran;
    }

    private double gelirVergisiHesapla(double vergiMatrahı) {
        double oran = 0.20;
        if (cinsiyet == Cinsiyet.KADIN) {
            oran -= 0.05;
        }
        return vergiMatrahı * oran;
    }

    private int cinsiyetBonusHesapla() {
        return cinsiyet == Cinsiyet.KADIN ? 100 : 0;
    }

    private int hamilelikBonusuHesapla() {
        return hamilelikDurumu ? 300 : 0;
    }

    public double getSskOrani() {
        double oran = 0.15;
        if (cinsiyet == Cinsiyet.KADIN && hamilelikDurumu && bebekAylık > 3 && cocukCinsiyet == Cinsiyet.KIZ) {
            oran = 0.13;
        }
        return oran;
    }


    @Override
    public String toString() {
        return String.join(";",
                id,
                isim,
                soyisim,
                String.valueOf(avans),
                String.format("%.2f", sskPrim),
                String.format("%.2f", gelirVergisi),
                String.format("%.2f", netMaas)
        );
    }

}
