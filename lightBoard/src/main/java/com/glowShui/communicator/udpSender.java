package com.glowShui.communicator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by graney on 5/16/14.
 */
public class udpSender {
    public static Boolean sendPacket(String ip, Integer port, byte[] content) throws SocketException, UnknownHostException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = content;

        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket pack;
        pack = new DatagramPacket(data, data.length, address, port);
        try {
            socket.send(pack);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
