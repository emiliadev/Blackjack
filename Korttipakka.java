package Sprintti5BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Korttipakka {

    private ArrayList<Kortti> pakka;

    //konstruktori
    public Korttipakka() {
        this.pakka = new ArrayList();

        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("Ruutu ", i));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("Hertta ", i));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("Pata ", i));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("Risti ", i));
        }
    }

    //Sekoita metodi poistaa alkuperäisestä pakasta satunnaisesti kortin ja siirtää sen väliaikaiseen pakkaan. 
    //Tämä toistetaan pakan koon verran eli 52 kertaa.
    //Lopulta palautetaan sekoitetut kortit väliaiksesta pakasta alkuperäiseen pakkaan.
    public void Sekoita() {
        ArrayList<Kortti> ValiaikainenPakka = new ArrayList<Kortti>(); //luodaan väliaikainen pakka johon sekoitetut kortit siirretään yksitellen.
        Random random = new Random();//käytetään Random jotta saadaan luotua satunnaisia arvoja.
        int arvottuKorttiIndex = 0; // tämä edustaa arvottua korttia, asetaan alkuun nollaksi.
        int alkupKoko = this.pakka.size(); //tämä edustaa pakan kokoa, koska siirrämme kortteja alkuperäisestä väliaikaiseen.

        for (int i = 0; i < alkupKoko; i++) { // tämä toistaa 52 kertaa for:in sisään kirjatut toimenpiteet.
            arvottuKorttiIndex = random.nextInt((this.pakka.size() - 1 - 0) + 1) - 0;//luodaan Random Index syntaksi rand.nextInt((max-min)+1)+min; jolla saadaan satunnaisia numeroita haluamallamme välillä, joka on nyt 0-51 indeksit
            ValiaikainenPakka.add(this.pakka.get(arvottuKorttiIndex));   //lisätään väliaikaiseen pakkaan arvottu kortti.
            this.pakka.remove(arvottuKorttiIndex); //poistetaan alkuperäisestä pakasta arvottu kortti.
        }
        this.pakka = ValiaikainenPakka; //palautetaan sekoitetut kortit väliaikaisesta pakasta takaisin alkuperäiseen pakkaan.
    }

    //luo jaaKortti metodin, joka palauttaa pakan ekan kortin ja poistaa sen pakasta
    public Kortti jaaKortti() {
        Kortti k;
        k = this.pakka.get(0);
        this.pakka.remove(0);
        return k;
    }

    public Kortti jaaKuvakortti() {
        Kortti k;
        k = this.pakka.get(12);
        return k;
    }

    @Override
    public String toString() {
        return "" + this.pakka;
    }

}
