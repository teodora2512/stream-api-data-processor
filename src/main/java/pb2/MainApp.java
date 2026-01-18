package pb2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApp {
    public static void scriere(Set<InstrumentMuzical> set) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/instrumente.json");
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.writeValue(file,set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<InstrumentMuzical> citire() {
        try {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzical> intrumenteMuzicale = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>(){});
            return intrumenteMuzicale;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Set<InstrumentMuzical> setInstrumente=new HashSet<>();


        setInstrumente.add(new Chitara("Yamaha", 2000, TipChitara.ELECTRICA, 6));
        setInstrumente.add(new Chitara("Fender", 3500, TipChitara.ELECTRICA, 7));
        setInstrumente.add(new Chitara("Gibson", 4000, TipChitara.ACUSTICA, 12));


        setInstrumente.add(new SetTobe("Pearl", 3000, TipTobe.ACUSTICE, 5, 3));
        setInstrumente.add(new SetTobe("Tama", 2500, TipTobe.ELECTRONICE, 4, 2));
        setInstrumente.add(new SetTobe("Yamaha", 1800, TipTobe.ACUSTICE, 6, 4));

        //2.
    scriere(setInstrumente);

        //3.
        Set<InstrumentMuzical> setInstrumenteCitit=citire();
        if (setInstrumenteCitit==null){
            System.out.println("Eroare la citirea din fisier");
        }
        else{
            setInstrumenteCitit.forEach(System.out::println);

        }

        // 4. afișare implementare Set
        System.out.println("Implementarea Set utilizată: " + setInstrumenteCitit.getClass());

        // 5.
        boolean dublura=setInstrumenteCitit.add(new Chitara("Gibson", 4000, TipChitara.ACUSTICA, 12));
        //System.out.println(dublura);
        if(!dublura){
            System.out.println("Nu putem avea duplicate in SET! ");
        }
        else{
            System.out.println("OK");
        }

        //6.
        //setInstrumenteCitit.removeIf(i->i.getPret()>3000);
        /*System.out.println("\nInstrumente dupa eliminarea celor > 3000");
        setInstrumenteCitit.forEach(System.out::println); */

        //7.
        System.out.println("\nInstrumente muzica de tip CHITARA: ");
        setInstrumenteCitit.stream().filter(i->i instanceof Chitara).forEach(System.out::println);

        //8.
        System.out.println("\nInstrumente muzica de set tobe: ");
        setInstrumenteCitit.stream().filter(i->i.getClass()== SetTobe.class).forEach(System.out::println);

        //9.

        setInstrumenteCitit.stream().filter(i->i instanceof Chitara)
                .map(i->((Chitara) i))
                .max(Comparator.comparingInt(Chitara::getNr_corzi))
                .ifPresent(c->  System.out.println("\nChitara cu cele mai multe corzi: "+c));

        //10.
        System.out.println("\nDate tobe acustic ordonate dupa nr tobe: ");
        setInstrumenteCitit.stream().filter(i->i instanceof SetTobe)
                .map(i->((SetTobe) i))
                .filter(t->t.getTip_tobe()==TipTobe.ACUSTICE)
                .sorted(Comparator.comparingInt(SetTobe::getNr_tobe))
                .forEach(System.out::println);
    }
}
