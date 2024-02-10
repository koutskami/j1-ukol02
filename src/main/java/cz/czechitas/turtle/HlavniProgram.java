package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        Color barvaCary;

//        //cast 1: priprava
//        nakresliBarevnyRovnostrannyTrojuhelnik(70.0, new Color(0x0D519E));
//        nakresliBarevnyCtverec(70, new Color(0x9E0D8B));
//        nakresliBarevnyObdelnik(100,150, new Color(0x179E0D));
//        nakresliBarevneKolecko(30, 30, Color.orange);
//        nakresliBarevnyPravouhlyTrojuhelnik(50, Color.black);


        //Cast 2.1: zmrzlina
        double stranaPrumer = 200; //delka strany kornoutu, zaroven prumer kopecku zmrzliny - lze upravovat

        //nachystani pozice
        odchodVlevo(90, 400-stranaPrumer);
        zofka.turnRight(0);

        //vykresleni zmrzliny
        zofka.penDown();
        nakresliBarevnyRovnostrannyTrojuhelnik(stranaPrumer, new Color(0xF39F02));
        nakresliBarevneKolecko(stranaPrumer, new Color(0xBB67B4)); //Zofka kouka vlevo


        //cast 2.2: snehulak
        //promenne pro snehulaka
        Color barvaSnehulaka = new Color(0x6D99AF); //vyber barvu snehulaka
        double stredniKoule = 150; //zmen pro upravu velikosti snehulaka; u vyssich velikosti bohuzel hlava a zaklad nelicuji presne
        double malaKoule = stredniKoule / 3;
        double hlavaKoule = malaKoule * 2;
        double zakladniKoule = stredniKoule + malaKoule;
        double sirkaSnehulaka = zakladniKoule + malaKoule;
        double vyskaSnehukala = zakladniKoule + stredniKoule + hlavaKoule;

        //nachystani pozice
        odchodVpravo(180,350+malaKoule);

        //vykresleni snehulaka
        nakresliBarevneKolecko(stredniKoule,barvaSnehulaka); //stredni koule, konci na leve strane
        nakresliBarevneKolecko(malaKoule,barvaSnehulaka); //prava ruka
        odchodVlevo(180,stredniKoule + malaKoule); //Z se dostane na levy okraj
        nakresliBarevneKolecko(malaKoule,barvaSnehulaka);
        odchodVpravo(180, sirkaSnehulaka / 2); //Zofka jde na stred stredni koule
        odchodVlevo(90, stredniKoule / 2); //Zofka jde na horni okraj stredni koule
        nakresliBarevneKolecko(hlavaKoule,barvaSnehulaka); //snehulak ma hlavu
        odchodVpravo(180,hlavaKoule + stredniKoule); //soucet prumeru hlavy a stredni koule, Zofka je na dolnim okraji
        nakresliBarevneKolecko(zakladniKoule,barvaSnehulaka); //spodni koule Snehulaka
        odchodVlevo(180, vyskaSnehukala / 2); //polovina vysky snehulaka, tj. odchod do stredu, Z kouka nahoru


        //cast 2.3: masinka
        //promenne pro velikost masinky
        double vyskaBazeMasinky = 100; //zmen pro upravu velikosti masinky
        double prumerKola = vyskaBazeMasinky + (vyskaBazeMasinky/2);
        double polomerKola = prumerKola/2;
        double polomerKolecka = polomerKola/2;
        double sirkaBazeMasinky = 2 * vyskaBazeMasinky;
        double delkaMasinky = prumerKola + sirkaBazeMasinky;
        //zvol barvy casti masinky
        Color barvaKonstrukce = Color.black;
        Color barvaKol = Color.darkGray;
        Color barvaCumaku = new Color(0x700808);

        //nachystani pozice
        odchodVpravo(90,vyskaBazeMasinky + delkaMasinky); //Z kouka vpravo
        zofka.turnRight(90); // nachystani pozice

        //2.3: vykresleni masinky
        //vykresleni konstrukce
        nakresliBarevnyObdelnik(vyskaBazeMasinky,sirkaBazeMasinky,barvaKonstrukce); //Z zacina kreslit dolu stranu A
        zofka.penUp();
        zofka.move(vyskaBazeMasinky); //Z kouka dolu
        zofka.turnRight(180);
        nakresliBarevnyObdelnik(sirkaBazeMasinky,prumerKola,barvaKonstrukce); //Z zacina kreslit nahoru stranu A, na konci kouka nahoru
        //vykresleni hlavniho kola
        zofka.turnRight(90);
        nakresliBarevneKolecko(prumerKola,barvaKol); //mame kolo, Z kouka vpravo
        //vykresleni cumaku
        odchodVlevo(180,delkaMasinky); //Z kouka vlevo
        odchodVlevo(90, polomerKolecka); //Z kouka dolu
        zofka.turnRight(180);
        nakresliBarevnyPravouhlyTrojuhelnik(vyskaBazeMasinky, barvaCumaku); //Z kouka nahoru
        zofka.penUp();
        zofka.move(polomerKolecka);
        //vykresleni kolecek
        odchodVpravo(90, delkaMasinky / 6.2);
        zofka.turnRight(90);
        nakresliBarevneKolecko(polomerKola,barvaKol);
        odchodVlevo(180,polomerKola);
        odchodVpravo(90,delkaMasinky / 3.8);
        zofka.turnRight(90);
        nakresliBarevneKolecko(polomerKola,barvaKol);
        zofka.penUp();

        //odklizeni Z
        zofka.move(100);
    }
    //metody:
    public void nakresliBarevnyRovnostrannyTrojuhelnik(double velikostStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        zofka.penDown();
        for (int i = 0; i < 3; i++) {
            zofka.move(velikostStrany);
            zofka.turnLeft(120.0);
        }
    }
    public void nakresliBarevnyPravouhlyTrojuhelnik(double velikostStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        zofka.penDown();
        var velikostPrepony = Math.sqrt(2*Math.pow(velikostStrany, 2));
        zofka.move(velikostStrany);
        zofka.turnLeft(135.0);
        zofka.move(velikostPrepony);
        zofka.turnLeft(135.0);
        zofka.move(velikostStrany);
        zofka.turnLeft(90.0);
    }
    public void nakresliBarevnyCtverec(double delkaStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        zofka.penDown();
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }
    public void nakresliBarevnyObdelnik(double delkaStranyA, double delkaStranyB, Color barvaCary) {
        int pravyUhel = 90;
        zofka.setPenColor(barvaCary);
        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            zofka.move(delkaStranyA);
            zofka.turnRight(pravyUhel);
            zofka.move(delkaStranyB);
            zofka.turnRight(pravyUhel);
        }
    }
    /**
     * Nakreslí „kolečko“ – pravidelný mnohoúhelník se zadaným „poloměrem“ a počtem stran.
     *
     * Výpočet délky strany se provádí tak, že si mnohoúhelník rozdělím na trojúhelníky tvořené jednou
     * stranou mnohoúhelníku a spojnicí sousedních vrcholů se středem. Jde tedy o rovnoramenný trojúhelík.
     * Tento trojúhelník se rozdělí na dva shodné pravoúhlé trojúhelníky tím, že se vztyčí kolmice ze středu
     * strany mnohoúhelníku, které prochází středem trojúhelníku.
     * Přepona tohoto trojúhelníku je spojnice středu a vrcholu mnohoúhelníku, jedna přepona je polovina strany
     * mnohoúhelníku, druhá přepona je ona kolmice. Známý úhel je úhel u středu mnohoúhelníky, který je polovinou
     * středového úhlu mnohoúhelníku.
     *
     * @param prumer Průměr kolečka.
     * @param barvaCary Barva kolečka.
     */
    public void nakresliBarevneKolecko(double prumer, Color barvaCary) {
        int pocetStran = 30;
        zofka.penUp();
        zofka.move(prumer);
        zofka.penDown();
        zofka.setPenColor(barvaCary);

        // o kolik stupnů se musí želva otočit, když má kreslit další stranu mnohoúhelníku
        // zároven je to velikost úhlu, který má vrchol ve středu mnohoúhelníku a spojuje střed a dva sousedící vrcholy mnohoúhelníku
        double uhel = (double) 360 / pocetStran;

        // sinus úhlu = délka protilehlé odvěsny / délka přepony
        // úhel = polovina vnitřního úhlu
        // přepona = spojnice středu a vrcholu
        // odvěsna = polovina strany mnohoúhelníku
        double delkaStrany = (double) (Math.sin(Math.PI * (double) uhel / 360d) * prumer);

        zofka.turnRight(90);
        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
        zofka.turnLeft(90);
    }
    public void odchodVlevo(double byAngle, double pixels) {
        zofka.penUp();
        zofka.turnLeft(byAngle);
        zofka.move(pixels);
    }
    public void odchodVpravo(double byAngle, double pixels) {
        zofka.penUp();
        zofka.turnRight(byAngle);
        zofka.move(pixels);
    }
}
