import java.util.List;
import java.util.Random;
class Activity{
    synchronized static void Activity(List<String> fish) {
        Random rand = new Random();
        String [] f = {"M","F"};
        int random = new Random().nextInt(fish.size());
        int random2 = new Random().nextInt(fish.size());
        while(random == random2) {
            random2 = new Random().nextInt(fish.size());
        }
        System.out.println("Fish before : "+fish.size());
        System.out.println(fish.get(random) + " " + random);
        System.out.println(fish.get(random2) + " " + random2);
        if(fish.get(random).equals("M") && fish.get(random2).equals("F")) {
            fish.add(f[rand.nextInt(f.length)]);
            fish.add(f[rand.nextInt(f.length)]);
        }
        else if(fish.get(random).equals("F") && fish.get(random2).equals("M")) {
            fish.add(f[rand.nextInt(f.length)]);
            fish.add(f[rand.nextInt(f.length)]);
        }
        else if(fish.get(random).equals("F") && fish.get(random2).equals("F")) {
            fish.remove("F");
        }
        else if(fish.get(random).equals("M") && fish.get(random2).equals("M")) {
            fish.remove("M");
            fish.remove("M");
        }
        System.out.println("Fish after : "+fish.size());
        System.out.println(fish);
    }
}