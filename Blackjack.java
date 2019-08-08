package Sprintti5BlackJack;

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Korttipakka pakka = new Korttipakka();
        Scanner lukija = new Scanner(System.in);
        pakka.Sekoita();

        while (true) {
            Kasi pelaaja = new Kasi();  //luodaan pelaajan käsi
            Kasi jakaja = new Kasi();   // luodaan jakajan käsi

            System.out.println("Hei! Tervetuloa pelaamaan blackjackia.");
            System.out.println("Tässä pelissä tasatilanteissa minä voitan. Onnea peliin! \n");
            System.out.println("Aloitetaan jakamalla sinulle kaksi korttia.");

            pelaaja.otaKortti(pakka.jaaKortti());
            pelaaja.otaKortti(pakka.jaaKortti());
            System.out.println("Korttisi ovat:" + pelaaja + "\n");

            if (pelaaja.tarkistaBlackjack() == true) { 
                System.out.println("Korttiesi summa on " + pelaaja.selvitaSumma() + ". Sait blackjackin! \n");
            } else { 
                System.out.println("Korttiesi summa on " + pelaaja.selvitaSumma() + ". Valitettavasti et saanut blackjackia.");

                while (true) { 
                    System.out.println("Haluaisitko (1)nostaa kortin vai (2)jäädä tähän?");
                    int vastaus = Integer.parseInt(lukija.nextLine());

                    if (vastaus == 1) { 
                        Kortti nostettu = pakka.jaaKortti();
                        System.out.println("Nostit kortin " + nostettu);
                        pelaaja.otaKortti(nostettu);
                        System.out.println("Korttisi ovat nyt" + pelaaja + ", ja niiden summa on " + pelaaja.selvitaSumma() + ".");

                        if (pelaaja.selvitaSumma() > 21) {
                            break;
                        }
                    }
                    else if (vastaus == 2) { 
                        System.out.println("Selvä, jäät summaan " + pelaaja.selvitaSumma() + ". \n");
                        break;
                    }
                }
            }
            if (pelaaja.selvitaSumma() <= 21) { 
                System.out.println("Jaan nyt itselleni kaksi korttia.");
                jakaja.otaKortti(pakka.jaaKortti());
                jakaja.otaKortti(pakka.jaaKortti());
                System.out.println("Sain kortit:" + jakaja);

                while (true) {
                    if (jakaja.tarkistaBlackjack() == true) { 
                        System.out.println("Korttieni summa on " + jakaja.selvitaSumma() + "Eli sain Blackjackin.");
                    } else { 
                        System.out.println("Korttieni summa on " + jakaja.selvitaSumma() + ".");
                        if (jakaja.selvitaSumma() < 15) { 
                            jakaja.otaKortti(pakka.jaaKortti());
                            System.out.println("Nostan kortin. Korttini ovat:" + jakaja + "\n");
                        } else { 
                            break;
                        }
                    }
                }
                System.out.println("Sinun korttiesi summa oli " + pelaaja.selvitaSumma() + ".");
                if (pelaaja.selvitaSumma() < jakaja.selvitaSumma() && jakaja.selvitaSumma() <= 21) {
                    System.out.println("Valitettavasti sinä hävisit tämän pelin.");
                }
                if (pelaaja.selvitaSumma() == jakaja.selvitaSumma() && pelaaja.selvitaSumma() <= 21) {
                    System.out.println("Valitettavasti sinä hävisit tämän pelin, sillä tasatilanteissa minä voitan.");
                }
                if (jakaja.selvitaSumma() < pelaaja.selvitaSumma() && pelaaja.selvitaSumma() <= 21) {
                    System.out.println("Onneksi olkoon, voitit tämän pelin!");
                }
                if (jakaja.selvitaSumma() > 21 && pelaaja.selvitaSumma() <= 21) {
                    System.out.println("Summani ylitti rajan 21. Onneksi olkoon, voitit tämän pelin!");
                }
            }
            else if (pelaaja.selvitaSumma() > 21) {
                System.out.println("Se ylittää rajan 21, joten valitettavasti hävisit.");
            }

            System.out.println("Haluatko pelata uuden pelin? k=kyllä e=ei");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("e")) {
                break;
            }
        }
    }
}
