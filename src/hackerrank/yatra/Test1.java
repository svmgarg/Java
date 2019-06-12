package hackerrank.yatra;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Result {


    public static String smallestString(long weight) {

        Map<Integer, Long> chars = new HashMap<>();
        chars.put(65, 1L);
        for (int i = 66; i < 84; i++) {
            chars.put(i, (i - 64) * (chars.get(i - 1) + 1));
        }
        StringBuilder builder = new StringBuilder();
        int current = 83;
        long div = 0;
        while (weight != 0) {
            if (weight >= chars.get(current)) {
                div = weight / chars.get(current);
                for (int tt = 0; tt < div; tt++) {
                    builder.append((char) current);
                }
                weight = weight % chars.get(current);
            } else {
                current = current - 1;
            }

        }


        builder = builder.reverse();
        return builder.toString();
    }

}

public class Test1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String result = Result.smallestString(sc.nextInt());
        System.out.println(result);
    }
}
