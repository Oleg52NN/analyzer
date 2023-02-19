package analyzer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main {
    public static final int masSize = 100_000;
    static final int stringSizePlus = 10_000;
    static final String symbol = "abc";
    static final int lengthQueue = 100;
    static BlockingQueue<String> queueA = new ArrayBlockingQueue<>(lengthQueue);
    static BlockingQueue<String> queueB = new ArrayBlockingQueue<>(lengthQueue);
    static BlockingQueue<String> queueC = new ArrayBlockingQueue<>(lengthQueue);


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < masSize; i++) {
                String s = generateText();
                try {
                    queueA.put(s);
                    queueB.put(s);
                    queueC.put(s);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        Thread counterA = new Counter('a', queueA);
        counterA.start();
        Thread counterB = new Counter('b', queueB);
        counterB.start();
        Thread counterC = new Counter('c', queueC);
        counterC.start();
    }

    static String generateText() {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < Main.stringSizePlus; i++) {
            text.append(Main.symbol.charAt(random.nextInt(Main.symbol.length())));
        }
        return text.toString();
    }
}