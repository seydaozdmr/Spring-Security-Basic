package com.security.demo.Examples.Siniflar.CalculatorExample;

import java.util.ArrayList;
import java.util.List;

public class Argument implements Arguments{
    private List<Double> myArguments;
    private int argumentAmount;

    public Argument(double ... args) {
        this.myArguments = new ArrayList<>();
        for(int i=0;i<args.length;i++){
            myArguments.add(args[i]);
            argumentAmount++;
        }
    }

    @Override
    public int getArgumentAmount() {
        return this.argumentAmount;
    }

    @Override
    public List<Double> getArguments() {
        return this.myArguments;
    }

}
