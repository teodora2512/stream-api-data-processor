package pb1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
        public static void scriere(Map<Integer, Carte> map) {
            try {
                ObjectMapper mapper=new ObjectMapper();
                File file=new File("src/main/resources/cartiModificate.json");
                mapper.writeValue(file,map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static Map<Integer, Carte> citire() {
            try {
                File file=new File("src/main/resources/carti.json");
                ObjectMapper mapper=new ObjectMapper();
                Map<Integer, Carte> map = mapper
                        .readValue(file, new TypeReference<Map<Integer, Carte>>(){});
                return map;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, Carte> map = new HashMap<>();

        try {
            map = mapper.readValue(new File("src/main/resources/carti.json"), new TypeReference<Map<Integer, Carte>>() {
            });

        } catch (Exception e) {
            System.out.println("Nu s-a putut citi fișierul: " + e.getMessage());
        }
        ///1.
        System.out.println("\nColectia de carti: ");
        /*
        var entery=map.entrySet();
        var it=entery.iterator();
        while(it.hasNext()){
            var m=it.next();
            int key=m.getKey();
            Carte value=m.getValue();
            System.out.println("Cheie: "+key+" Valoare: "+value.toString());
        } */
        for (var entery1 : map.entrySet()) {
            System.out.println("ID: " + entery1.getKey() + "-> " + entery1.getValue());
        }
        ///2.
        map.remove(2);
        System.out.println("\nDupa stergere: ");
        map.forEach((k,v)-> System.out.println(k+"-> "+v));

        ///3.
        map.putIfAbsent(10,new Carte("Programare PJ","Otelariu Teodora",2025));

        /// 4.
        scriere(map);


        ///5.
        Set<Carte> setCartiYual=map.values().stream()
                .filter(c->c.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                .collect(Collectors.toSet());
        System.out.println("\nCărțile lui Yuval Noah Harari:");
        setCartiYual.forEach(System.out::println);

        ///6.
        System.out.println("\nCarțile afisate ordonat dupa titlul");
        setCartiYual.stream().sorted(Comparator.comparing(Carte::titlul)).forEach(System.out::println);//afis setul

        Set<Carte> setCartiOrdonate = new TreeSet<>(Comparator.comparing(Carte::titlul));

       // System.out.println("\nCarțile afisate ordonat dupa titlul");

        setCartiOrdonate.addAll(map.values());
        setCartiOrdonate.forEach(System.out::println);
      //  System.out.println("\nCarțile afisate ordonat dupa titlul");

        /// 7.
        map.values().stream().min(Comparator.comparingInt(Carte::anul))
                .ifPresentOrElse(c->System.out.println("\nCea mai veche carte: "+c), ()->System.out.println("Nu avem cea mai veche carte"))

        ;
    }
}
