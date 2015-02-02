package com.glowShui.communicator.zones;

import com.glowShui.communicator.interfaces.IColorZone;
import com.glowShui.communicator.udpSender;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by graney on 3/31/14.
 */
public class RgbwZone implements IColorZone{

    public RgbwZone(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    private String ip;

    private Integer port;

    @Override
    public boolean setColor(String color) {
        return false;
    }

    @Override
    public boolean setBrightness(int percent) {
        return false;
    }

    @Override
    public boolean turnOn() {
        try {
            return udpSender.sendPacket(ip, port, new byte[] {0x42, 0x00, 0x55});
        } catch (SocketException e) {
            e.printStackTrace();
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean turnOff() {
        try {
            return udpSender.sendPacket(ip, port, new byte[] {0x41, 0x00, 0x55});
        } catch (SocketException e) {
            e.printStackTrace();
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }
}
