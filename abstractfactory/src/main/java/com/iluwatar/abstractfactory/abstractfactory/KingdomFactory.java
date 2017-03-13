package com.iluwatar.abstractfactory.abstractfactory;

/**
 * Created by starhq on 2017/3/10.
 */
public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();
}
