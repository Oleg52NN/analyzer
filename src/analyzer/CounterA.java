package analyzer;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class CounterA extends Thread{
    @Override
    public void run(){
        String s = null;

        //System.out.println(queueA);
        for (int i = 0; i < masSize; i++) {
            try {
                s = queueA.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counting(s, 'a');
            if(swapA < quantityA.get()){
                swapA = quantityA.get();
                resultA = s;
            }
            quantityA.set(0);
        }
        System.out.println("Максимальное количество символов \'a\' в строке = " + swapA + "\nТак выглядит строка:\n" + resultA + "\n");
    }
}
