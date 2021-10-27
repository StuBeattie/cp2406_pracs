import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Ch9p2 {


    public static void main(String[] args) {

        String outPath = "C:\\Users\\beatt\\IdeaProjects\\cp2406_pracs\\prac9\\src\\Ch0p2_text_out.txt";
        File file = new File("C:\\Users\\beatt\\IdeaProjects\\cp2406_pracs\\prac9\\src\\Ch9p2.java");

        BufferedReader br;
        ArrayList<String> arr = new ArrayList<>();
        TreeSet<String> set = new TreeSet<>();

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                StringTokenizer st = new StringTokenizer(line," \t(),\\[];{}.");
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    System.out.println(word);
                    arr.add(word);
                    set.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(arr.toArray()));
        Object[] arr2 = arr.toArray();
        Arrays.sort(arr2);

        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(arr2));

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outPath), StandardCharsets.UTF_8));

            for (Object word : arr2) {
                writer.write(word.toString());
                writer.write("\n");
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------- SET ---------------------");
        System.out.println(Arrays.toString(set.toArray()));
    }
}
