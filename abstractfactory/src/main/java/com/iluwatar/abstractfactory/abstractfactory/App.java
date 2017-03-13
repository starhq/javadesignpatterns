package com.iluwatar.abstractfactory.abstractfactory;

/**
 * Hello world!
 */
public class App {

    private King king;
    private Army army;
    private Castle castle;

    public void createKingdom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setArmy(factory.createArmy());
        setCastle(factory.createCastle());
    }

    public King getKing(final KingdomFactory factory) {
        return factory.createKing();
    }

    public King getKing() {
        return king;
    }

    private void setKing(final King king) {
        this.king = king;
    }

    public Army getArmy(final KingdomFactory factory) {
        return factory.createArmy();
    }

    public Army getArmy() {
        return army;
    }

    private void setArmy(final Army army) {
        this.army = army;
    }

    public Castle getCastle(final KingdomFactory factory) {
        return factory.createCastle();
    }

    public Castle getCastle() {
        return castle;
    }

    private void setCastle(final Castle castle) {
        this.castle = castle;
    }

    public static void main(String[] args) {
        App app = new App();

        System.out.println("Elf Kingdom");
        app.createKingdom(new ElfKingdomFactory());
        System.out.println(app.getArmy().getDescription());
        System.out.println(app.getCastle().getDescription());
        System.out.println(app.getKing().getDescription());

        System.out.println("\nOrc Kingdom");
        app.createKingdom(new OrcKingdomFactory());
        System.out.println(app.getArmy().getDescription());
        System.out.println(app.getCastle().getDescription());
        System.out.println(app.getKing().getDescription());
    }
}
