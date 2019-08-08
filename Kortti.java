package Sprintti5BlackJack;

public class Kortti {

    private int arvo;   
    private String maa;  

    //konstruktori
    public Kortti(String maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public int getArvo() {
        return this.arvo;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    @Override
    public String toString() {
        return this.maa + this.arvo;
    }

}
