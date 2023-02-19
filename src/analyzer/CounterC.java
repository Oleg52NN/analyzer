package analyzer;

import static analyzer.Main.*;
import static analyzer.Quantity.counting;

public class CounterC extends Thread{
    @Override
    public void run(){
        String s = null;
        for (int i = 0; i < masSize; i++) {
            try {
                s = queueC.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counting(s, 'c');
            if(swapC < quantityC){
                swapC = quantityC;
                resultC = s;
            }
            quantityC = 0;
        }
        System.out.println("Максимальное количество символов \'c\' в строке = " + swapC + "\nТак выглядит строка:\n" + resultC + "\n");

    }
}
