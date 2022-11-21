import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
class MultipleThread extends Thread{
    List<String> fish = new CopyOnWriteArrayList<String>();
    public void run() {
        try {
            while(fish.size()>1) {
                Activity a = new Activity();
                a.Activity(fish);
                System.out.println("This operation is performed by : "+Thread.currentThread().getName());
                System.out.println();
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    MultipleThread(List<String> fish){
        this.fish = fish;
    }
}