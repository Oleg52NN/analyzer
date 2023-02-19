package analyzer;

import static analyzer.Main.quantityA;
import static analyzer.Main.quantityB;

public class Quantity {
    public static void counting(String s, char symbol){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol){
                switch (symbol){
                    case 'a': quantityA.getAndIncrement();
                    break;
                    case 'b': quantityB.getAndIncrement();
                        break;
                    case 'c': Main.quantityC.getAndIncrement();
                        break;
                }

            }
        }
    }
}
