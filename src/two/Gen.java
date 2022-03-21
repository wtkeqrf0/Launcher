package two;

import java.util.concurrent.ForkJoinPool;

public class Gen {
    public static void main(String[] args) {
        new ForkJoinPool().invoke(new Setting());
    }
}