// package class04;
import java.util.ArrayList;
import java.util.HashMap;

class ArrList {
    private static ArrayList<Integer> nums;
    private static HashMap<String, Integer> h;
    public static void main(String args[]) throws exception {
        nums = new ArrayList<>();
        nums.add(10);
        nums.add(4);
        nums.remove(4);
        for(Integer x : nums) {
            System.out.print(x + " ");
        }
        h = new HashMap<>();
        h.put("haha what", new Integer(2));
        h.put("lol", new Integer(432));
        Integer v = h.get("lol");
        Integer n = h.get("xxx"); // will return null so check
        // h.put(3, "h");
    }
    public static void displayHaspMap() {
        FileReader fr = new FileReader("filename.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = fr.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
