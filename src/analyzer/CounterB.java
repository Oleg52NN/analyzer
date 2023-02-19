package analyzer;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class CounterB extends Thread {
    @Override
    public void run() {
        String s;
        String result = null;
        int swap = 0;
        for (int i = 0; i < masSize; i++) {
            try {
                s = queueB.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counting(s, 'b');
            if (swap < quantityB) {
                swap = quantityB;
                result = s;
            }
            quantityB = 0;
        }
        System.out.println("Максимальное количество символов 'b' в строке = " + swap + "\nТак выглядит строка:\n" + result + "\n");

    }
}
