package analyzer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static final int masSize = 100_000;
    static final int stringSizePlus = 10_000;
    static final String symbol = "abc";
    static final int lengthQueue = 100;
    static BlockingQueue <String> queueA = new ArrayBlockingQueue(lengthQueue);
    static BlockingQueue <String> queueB = new ArrayBlockingQueue(lengthQueue);
    static BlockingQueue <String> queueC = new ArrayBlockingQueue(lengthQueue);
    static int quantityA = 0;
    static int quantityB = 0;
    static int quantityC = 0;
    static String resultA;
    static String resultB;
    static String resultC;
    static int swapA = 0;
    static int swapB = 0;
    static int swapC = 0;
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        new Thread(() -> {
            for (int i = 0; i < masSize; i++) {
                String s = generateText(symbol, stringSizePlus);
                try {
                    queueA.put(s);
                    queueB.put(s);
                    queueC.put(s);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        Thread counterA = new CounterA();
        counterA.start();
        Thread counterB = new CounterB();
        counterB.start();
        Thread counterC = new CounterC();
        counterC.start();


    }

    static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}