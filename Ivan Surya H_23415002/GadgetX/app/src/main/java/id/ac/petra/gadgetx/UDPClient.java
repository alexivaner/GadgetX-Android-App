package id.ac.petra.gadgetx;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class UDPClient {
    private DatagramPacket sPacket, rPacket;
    private DatagramSocket sock;
    public UDPClient() {
        try {
            sock = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(String s) {
        byte data[] = s.getBytes();
        InetAddress srv = null;
        try {
            srv = InetAddress.getByName("192.168.43.17");
            sPacket = new DatagramPacket(data, data.length, srv, 8000);
            sock.send(sPacket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receivePacket(String s) {
        String msg;
        byte data[] = new byte[512];
        rPacket = new DatagramPacket(data, data.length);
        try {
            sock.receive(rPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg = new String(rPacket.getData(),0,rPacket.getLength());
        return msg;
    }
}