import java.util.*;

public class gobackn {
    public static void main(String []args) {
        Random random = new Random();
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter Total Frames:");
        int totalframe=scan.nextInt();
        System.out.println("Enter WindowSize:");
        int windowsize=scan.nextInt();

        int totaltransmission=0;
        int i=1;
        while(i<=totalframe) {
            int z=0;//ack counter
            for(int k=i;k<=windowsize +i && k<=totalframe;k++) {
                System.out.println("Starting Transfer of Frame"+k);
                totaltransmission++;
            }
            for(int k=i;k<=windowsize+i && k<=totalframe;k++) {
                boolean ackrecieved=random.nextBoolean();
                if(!ackrecieved) {
                    System.out.println("Timeout Frame Number "+k+" Not Received");
                    break;
                }
                else {
                    System.out.println("Frame Number "+k+" Received");
                    z++;
                }
            }
            i=i+z;
            System.out.println(" ");
        }
        System.out.println("Total Frame Transmitted = +"+ totalframe );
        scan.close();
    }
}