package Sprintti5BlackJack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author s1900012
 */
public class Kasi {

    private ArrayList<Kortti> kortit;

    //konstruktori luo Kasi luokasta kortit nimisen olion, joka on lista-tyyppiä
    public Kasi() {
        this.kortit = new ArrayList();
    }

    //metodi, jolla käteen lisätään kortti.
    public void otaKortti(Kortti nostettuKortti) {
        this.kortit.add(nostettuKortti);

    }

    public int selvitaSumma() {
        // selvittää kädessä olevien korttien summan.
        int korttienSumma = 0;
        int kortinArvo;
        int assienMaara = 0;

        for (int i = 0; i < this.kortit.size(); i++) { //i viittaa yhteen korttiin pelaajan kädessä.
            kortinArvo = this.kortit.get(i).getArvo();

            if (kortinArvo == 1) {//ässä
                assienMaara++;
                korttienSumma += 11;
            }
            if (kortinArvo > 10) {//kuvakortit
                korttienSumma += 10;
            } else {
                korttienSumma += kortinArvo;//tavalliset numero kortit
            }
        }
        //jos kaksi tai useampi ässä ja korttien summa on > 21, saa yksi ässä arvon 1 eli vähennetään 10 summasta.
        if (korttienSumma > 21 && assienMaara > 1) {
            korttienSumma -= 10;
        }
        return korttienSumma;
    }

    public boolean tarkistaBlackjack() {
        if (this.kortit.size() == 2 && selvitaSumma() == 21) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return " " + this.kortit;
    }

}
