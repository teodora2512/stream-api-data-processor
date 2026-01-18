package pb2;

import java.util.Objects;

public class Chitara extends InstrumentMuzical{
    private TipChitara tip_chitara;
    private int nr_corzi;


    @Override
    public String toString() {
        return super.toString() +
                " tip_chitara=" + tip_chitara +
                " nr_corzi=" + nr_corzi;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chitara chitara)) return false;
        if (!super.equals(o)) return false;
        return nr_corzi == chitara.nr_corzi && tip_chitara == chitara.tip_chitara;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tip_chitara, nr_corzi);
    }

    public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }
    public Chitara(){

    }

    public TipChitara getTip_chitara() {
        return tip_chitara;
    }

    public void setTip_chitara(TipChitara tip_chitara) {
        this.tip_chitara = tip_chitara;
    }

    public int getNr_corzi() {
        return nr_corzi;
    }

    public void setNr_corzi(int nr_corzi) {
        this.nr_corzi = nr_corzi;
    }
}
