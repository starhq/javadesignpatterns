package com.iluwatar.command;

/**
 * Created by starhq on 2017/3/22.
 */
public abstract class Command {

    public abstract void execute(Target target);

    public abstract void undo();

    public abstract void redo();

    @Override
    public abstract String toString();
}
