package cn.nukkit.raknet.server;

/*import cn.nukkit.Server;
import cn.nukkit.utils.ThreadedLogger;*/

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class RakNetServer extends Thread {
    protected InetSocketAddress address;

    private ConcurrentLinkedQueue<byte[]> externalQueue;
    private ConcurrentLinkedQueue<byte[]> internalQueue;

    private boolean shutdown;

    public RakNetServer(InetSocketAddress address) {
        this.address = address;

        this.externalQueue = new ConcurrentLinkedQueue<>();
        this.internalQueue = new ConcurrentLinkedQueue<>();

        this.start();
    }

    InetSocketAddress getSocketAddress() {
        return address;
    }

    public boolean isShutdown() {
        return shutdown;
    }

    void shutdown() {
        this.shutdown = true;
    }

    public ConcurrentLinkedQueue<byte[]> getExternalQueue() {
        return externalQueue;
    }

    public ConcurrentLinkedQueue<byte[]> getInternalQueue() {
        return internalQueue;
    }

    void pushMainToThreadPacket(byte[] data) {
        this.internalQueue.add(data);
    }

    byte[] readMainToThreadPacket() {
        return this.internalQueue.poll();
    }

    void pushThreadToMainPacket(byte[] data) {
        this.externalQueue.add(data);
    }

    byte[] readThreadToMainPacket() {
        return this.externalQueue.poll();
    }

    private class ShutdownHandler extends Thread {
        public void run() {
            if (!shutdown) {
                //logger.emergency("RakNet crashed!");
            }
        }
    }

    @Override
    public void run() {
        this.setName("RakNet Thread #" + Thread.currentThread().getId());
        Runtime.getRuntime().addShutdownHook(new ShutdownHandler());
        UDPServerSocket socket = new UDPServerSocket(this.address);
        try {
            new SessionManager(this, socket);
        } catch (Exception e) {
            //Server.getInstance().getLogger().logException(e);
        }
    }
}
