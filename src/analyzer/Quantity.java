package analyzer;

public class Quantity {
    public static int counting(String s, char symbol ) {
        int quant = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol) {
            quant++;
            }
        }
        return quant;
    }
}
