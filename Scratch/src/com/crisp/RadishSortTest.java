package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("Red", 1.0,2.2,3));
        radishes.add(new Radish("Black", 3.5,0.0,0));
        radishes.add(new Radish("Red", 0.75, 3.1, 7));
        radishes.add(new Radish("White", 1.0, 1.0,2));

        radishes.sort(null); //passing null means natural order
        System.out.println("natural Order Size:");
        dump(radishes);
        System.out.println();

        radishes.sort(new RadishColorComparator());
        System.out.println("Color:");
        dump(radishes);

        System.out.println("sort by tailLength");
        radishes.sort(new Comparator<Radish>() {

            @Override
            public int compare(Radish r1, Radish r2) {
                return Double.compare(r1.getTailLength(), r2.getTailLength());
            }
        } );
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}