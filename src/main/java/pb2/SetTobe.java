package pb2;

import java.util.Objects;

public class SetTobe extends InstrumentMuzical{
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe(String producator, double pret, TipTobe tip_tobe,int nr_tobe,int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe=nr_tobe;
        this.nr_cinele=nr_cinele;
    }
    public SetTobe(){

    }

    @Override
    public String toString() {
        return super.toString()+
                " tip_tobe=" + tip_tobe +
                " nr_tobe=" + nr_tobe +
                " nr_cinele=" + nr_cinele;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SetTobe setTobe)) return false;
        if (!super.equals(o)) return false;
        return nr_tobe == setTobe.nr_tobe && nr_cinele == setTobe.nr_cinele && tip_tobe == setTobe.tip_tobe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tip_tobe, nr_tobe, nr_cinele);
    }

    public TipTobe getTip_tobe() {
        return tip_tobe;
    }

    public void setTip_tobe(TipTobe tip_tobe) {
        this.tip_tobe = tip_tobe;
    }

    public int getNr_tobe() {
        return nr_tobe;
    }

    public void setNr_tobe(int nr_tobe) {
        this.nr_tobe = nr_tobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    public void setNr_cinele(int nr_cinele) {
        this.nr_cinele = nr_cinele;
    }
}
