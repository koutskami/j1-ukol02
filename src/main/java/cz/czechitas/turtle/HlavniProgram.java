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
        odchodVlevo(90, 350);
        zofka.turnRight(0);
        zofka.penDown();
        nakresliBarevnyRovnostrannyTrojuhelnik(150, new Color(0xF39F02));
        nakresliBarevneKolecko(150, new Color(0xBB67B4)); //zofka kouka vlevo

        //cast 2.2: snehulak
        odchodVpravo(180,400);
        Color barvaSnehulaka = new Color(0x6D99AF);
        nakresliBarevneKolecko(150,barvaSnehulaka);
        nakresliBarevneKolecko(50,barvaSnehulaka);
        odchodVlevo(180,200);
        nakresliBarevneKolecko(50,barvaSnehulaka);
        odchodVpravo(180,250/2);
        odchodVlevo(90,150/2);
        nakresliBarevneKolecko(100,barvaSnehulaka);
        odchodVpravo(180,250);
        nakresliBarevneKolecko(200,barvaSnehulaka);
        odchodVlevo(180,450/2);

        //cast 2.3: masinka
        odchodVpravo(90,400);

    }
    //metody:
    public void nakresliBarevnyRovnostrannyTrojuhelnik(double velikostStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
        for (int i = 0; i < 3; i++) {
            zofka.move(velikostStrany);
            zofka.turnLeft(120.0);
        }
    }
    public void nakresliBarevnyPravouhlyTrojuhelnik(double velikostStrany, Color barvaCary) {
        zofka.setPenColor(barvaCary);
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
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }
    public void nakresliBarevnyObdelnik(double delkaStranyA, double delkaStranyB, Color barvaCary) {
        int pravyUhel = 90;
        zofka.setPenColor(barvaCary);
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
     * @param pocetStran Počet stran mnohoúhelníku. Doporučeno volit číslo, které je celočíselným dělitelem 360.
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
        double uhel = 360 / pocetStran;

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
    public void odchodVlevo(int byAngle, int pixels) {
        zofka.penUp();
        zofka.turnLeft(byAngle);
        zofka.move(pixels);
    }
    public void odchodVpravo(int byAngle, int pixels) {
        zofka.penUp();
        zofka.turnRight(byAngle);
        zofka.move(pixels);
    }
}
