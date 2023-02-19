package analyzer;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class CounterC extends Thread {
    @Override
    public void run() {
        String s;
        String result = null;
        int swap = 0;
        for (int i = 0; i < masSize; i++) {
            try {
                s = queueC.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counting(s, 'c');
            if (swap < quantityC) {
                swap = quantityC;
                result = s;
            }
            quantityC = 0;
        }
        System.out.println("Максимальное количество символов 'c' в строке = " + swap + "\nТак выглядит строка:\n" + result + "\n");

    }
}
