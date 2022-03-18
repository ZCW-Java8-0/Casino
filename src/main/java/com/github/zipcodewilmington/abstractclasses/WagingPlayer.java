package com.github.zipcodewilmington.abstractclasses;

import com.github.zipcodewilmington.interfaces.PlayerInterface;

public abstract class WagingPlayer extends Player implements PlayerInterface {


    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

}
