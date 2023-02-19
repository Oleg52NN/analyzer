package analyzer;

import java.util.concurrent.BlockingQueue;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class Counter extends Thread {
    private final char symbol;
    private final BlockingQueue<String> queue;

    public Counter(char symbol, BlockingQueue<String> queue) {
        this.queue = queue;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        String s;
        String result = null;
        int swap = 0;
        for (int i = 0; i < masSize; i++) {
            try {
                s = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int quant = counting(s, symbol);
            if (swap < quant) {
                swap = quant;
                result = s;
            }
        }
        System.out.println("Максимальное количество символов '" + symbol + "' в строке = " + swap + "\nТак выглядит строка:\n" + result + "\n");
    }
}
