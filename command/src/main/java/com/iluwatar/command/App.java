package com.iluwatar.command;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();

        goblin.printStatus();

        wizard.castSpell(new ShrinkSpell(), goblin);
        goblin.printStatus();

        wizard.castSpell(new InvisibilitySpell(), goblin);
        goblin.printStatus();


        wizard.undoLast();
        goblin.printStatus();


        wizard.undoLast();
        goblin.printStatus();


        wizard.redoLast();
        goblin.printStatus();

        wizard.redoLast();
        goblin.printStatus();
    }
}
