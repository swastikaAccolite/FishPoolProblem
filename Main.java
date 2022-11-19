import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class MyThread implements Runnable{

    public void run(){}


}

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new MyThread(), "Male");
        Thread t2 = new Thread(new MyThread(), "Male");
        Thread t3 = new Thread(new MyThread(), "Male");
        Thread t4 = new Thread(new MyThread(), "Male");
        Thread t5 = new Thread(new MyThread(), "Male");
        Thread t6 = new Thread(new MyThread(), "Female");
        Thread t7 = new Thread(new MyThread(), "Female");
        Thread t8 = new Thread(new MyThread(), "Female");
        Thread t9 = new Thread(new MyThread(), "Female");
        Thread t10 = new Thread(new MyThread(), "Female");
        Thread t11 = new Thread(new MyThread(), "Male");
        Thread t12 = new Thread(new MyThread(), "Female");

        List<Thread> tl = new ArrayList<>();
        tl.add(t1);
        tl.add(t2);
        tl.add(t3);
        tl.add(t4);
        tl.add(t5);
        tl.add(t6);
        tl.add(t7);
        tl.add(t8);
        tl.add(t9);
        tl.add(t10);
        tl.add(t11);
        tl.add(t12);



        while (!tl.isEmpty() && tl.size()>1) {


            //CHOOSING RANDOM FISHES
            int fish1 = ThreadLocalRandom.current().nextInt(tl.size()) % tl.size();
            int fish2 = ThreadLocalRandom.current().nextInt(tl.size()) % tl.size();

            while(fish2==fish1){
                fish2 = ThreadLocalRandom.current().nextInt(tl.size()) % tl.size();
            }



            //PUTTING CONDITION BASED ON FISHES SELECTED


            //IF TWO MALE FISHES CAUGHT
            if (tl.get(fish1).getName() == "Male" && tl.get(fish2).getName()=="Male") {

                System.out.println("Kill Both Male");
                tl.get(fish1).start();
                tl.get(fish1).interrupt();
                tl.remove(fish1);

                if(fish1<fish2) {
                    tl.get(fish2-1).start();
                    tl.get(fish2-1).interrupt();
                    tl.remove(fish2 - 1);
                }
                else{
                    tl.get(fish2).start();
                    tl.get(fish2).interrupt();
                    tl.remove(fish2);
                }
            }

            //IF TWO FEMALE FISHES ARE CAUGHT
            else if(tl.get(fish1).getName() == "Female" && tl.get(fish2).getName()=="Female") {
                System.out.println("Kill one Female");
                tl.get(fish1).start();
                tl.get(fish1).interrupt();
                tl.remove(fish1);
            }


            //IF MALE AND FEMALE FISHES ARE CAUGHT
            else {
                System.out.println("Produce Baby Fishes");

                String[] s = {"Male","Female"};

                Random ran = new Random();
                String s_ran = s[ran.nextInt(s.length)];

                tl.add(new Thread(new MyThread(), s_ran));
                tl.add(new Thread(new MyThread(), s_ran));


            }
        }
    }
}

