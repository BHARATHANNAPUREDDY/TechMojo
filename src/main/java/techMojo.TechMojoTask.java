package techMojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TechMojoTask {
    public static int TOPHASHTAGCOUNT = 10;

    public static void main(String[] args) throws Exception {
        String tweet;
        Map<String, Integer> hm = new LinkedHashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        // Reads each line
        while ((tweet = sc.nextLine()) != null && !tweet.isEmpty()) {
            String string[] = tweet.toLowerCase().split(" ");
            for (String s : string) {
                if (s.startsWith("#")) {
                    Integer j = hm.get(s);
                    hm.put(s, (j == null) ? 1 : j + 1);
                }
            }
        }

        List<Entry<String, Integer>> sortedListt = new ArrayList<Entry<String, Integer>>(hm.entrySet());
        Collections.sort(sortedListt, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> h1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(h1.getValue());
            }
        });
        int count = 0;
        System.out.println("-----Top trending hashtags-----------------");
        for (Entry<String, Integer> entry : sortedListt) {
            if (count++ <= TOPHASHTAGCOUNT)
                System.out.println(entry.getKey());
            else
                break;
        }
        sc.close();

    }
}
