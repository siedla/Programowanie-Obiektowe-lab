package agh.cs.lab6;

import agh.cs.lab5.AbstractWorldMapElement;

import java.util.Comparator;

public class CompareByY implements Comparator<AbstractWorldMapElement> {
    @Override
    public int compare(AbstractWorldMapElement o1, AbstractWorldMapElement o2) {
        int k = o1.getPosition().y-o2.getPosition().y;
        if(k!=0){return k;}
        return o1.getPosition().x-o2.getPosition().x;
    }
}
