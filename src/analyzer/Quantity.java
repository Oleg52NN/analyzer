package analyzer;

import static analyzer.Main.quantityA;
import static analyzer.Main.quantityB;
import static analyzer.Main.quantityC;

public class Quantity {
    public static void counting(String s, char symbol) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol) {
                switch (symbol) {
                    case 'a' -> quantityA++;
                    case 'b' -> quantityB++;
                    case 'c' -> quantityC++;
                }

            }
        }
    }
}
