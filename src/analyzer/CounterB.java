package analyzer;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class CounterB extends Thread{
    @Override
    public void run(){
        String s = null;
        for (int i = 0; i < masSize; i++) {
            try {
                s = queueB.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counting(s, 'b');
            if(swapB < quantityB.get()){
                swapB = quantityB.get();
                resultB = s;
            }
            quantityB.set(0);
        }
        System.out.println("Максимальное количество символов \'b\' в строке = " + swapB + "\nТак выглядит строка:\n" + resultB + "\n");

    }
}
