package com.company.behavioral.chain_of_responsibility.dispenser;

public abstract class AbstractDispenseChain {
    private AbstractDispenseChain nextChain;
    protected int noteAmount;

    void setNextChain(AbstractDispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    void dispense(Currency currency) {
        if (currency.getAmount() >= noteAmount) {
            int _50DollarsNotesNumber = currency.getAmount() / noteAmount;
            int remainder = currency.getAmount() % noteAmount;

            System.out.println(
                    "Dispensing " + _50DollarsNotesNumber + " " + noteAmount + "$ note");

            if (remainder != 0) {
                this.nextChain.dispense(new Currency(remainder));
            }
        } else {
            this.nextChain.dispense(currency);
        }
    }
}

class Dollar50Dispenser extends AbstractDispenseChain {

    public Dollar50Dispenser() {
        this.noteAmount = 50;
    }
}

class Dollar20Dispenser extends AbstractDispenseChain {

    public Dollar20Dispenser() {
        this.noteAmount = 20;
    }
}

class Dollar10Dispenser extends AbstractDispenseChain {

    public Dollar10Dispenser() {
        this.noteAmount = 10;
    }
}