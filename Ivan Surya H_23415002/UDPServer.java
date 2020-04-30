import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;
import java.util.Scanner;

public class UDPServer {

    public static void main(String args[]) {
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(8000);

            byte[] buffer = new byte[65536];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

            System.out.println("socket server siap, menunggu user mengirim data dari smartphone");
			System.out.println("Developed by : Ivan Surya H");
			System.out.println("NRP : 23415002");
			
			int poin =0;
            while (true) {
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                String s = new String(data, 0, datagramPacket.getLength());
                System.out.println(datagramPacket.getAddress().getHostAddress() + " : " + datagramPacket.getPort() + " : " + s); 
	            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
	
	
  
  private static void log(String aMessage){
    System.out.println(aMessage);
  }
} 


