import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class InfinitePond{
    static List<String> fish = new CopyOnWriteArrayList<String>();
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            fish.add("M");
            fish.add("F");
        }
        System.out.println(fish);
        System.out.println(fish.size());
        MultipleThread th1 = new MultipleThread(fish);
         MultipleThread th2 = new MultipleThread(fish);
         MultipleThread th3 = new MultipleThread(fish);
         MultipleThread th4 = new MultipleThread(fish);
         MultipleThread th5 = new MultipleThread(fish);
        th1.start();
         th2.start();
         th3.start();
         th4.start();
         th5.start();
    }
}