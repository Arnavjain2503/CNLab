import java.util.*;

class selectiverepeat {
    public static void main(String[] args) {
        Random rand=new Random();
        int totalpacket=10;
        int windowsize=3;
        
        int totaltransmission=0;
        int i=1;
        boolean[] ackrecieved=new boolean [totalpacket+1];
        while(i<=totalpacket){
            int z=0;
            for(int k=i;k<=windowsize+i && k<=totalpacket;k++){
                if(!ackrecieved[k]){
                    System.out.println("Sending Transmission for Packet"+k);
                    totaltransmission++;
                    z++;
                }
            }
            for(int k=i;k<=windowsize+i && k<=totalpacket;k++){
                if(!ackrecieved[k]){
                    boolean ack=rand.nextBoolean();
                    if(ack){
                        System.out.println("Frame Received "+k);
                        ackrecieved[k]=true;
                        z++;
                    }
                    else{
                        System.out.println("Retransmistting Frame"+k);
                    }
                }
            }
            while(i<=totalpacket &&ackrecieved[i]){
                i++;
            }
        }
    }
}