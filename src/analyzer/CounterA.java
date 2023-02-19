package analyzer;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class CounterA extends Thread {
    @Override
    public void run() {
        String s;
        String result = null;
        int swap = 0;
        for (int i = 0; i < masSize; i++) {
            try {
                s = queueA.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counting(s, 'a');
            if (swap < quantityA) {
                swap = quantityA;
                result = s;
            }
            quantityA = 0;
        }
        System.out.println("Максимальное количество символов 'a' в строке = " + swap + "\nТак выглядит строка:\n" + result + "\n");
    }
}
