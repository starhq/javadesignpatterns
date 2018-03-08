package com.iluwatar.prototype;

public class HeroFactoryImpl implements HeroFactory {

    private Mage mage;
    private Warlord warlord;
    private Beast beast;

    /**
     * Constructor
     */
    public HeroFactoryImpl(Mage mage, Warlord warlord, Beast beast) {
        this.mage = mage;
        this.warlord = warlord;
        this.beast = beast;
    }

    /**
     * Create mage
     */
    @Override
    public Mage createMage() {
        try {
            return mage.copy();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Create warlord
     */
    @Override
    public Warlord createWarlord() {
        try {
            return warlord.copy();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Create beast
     */
    @Override
    public Beast createBeast() {
        try {
            return beast.copy();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
