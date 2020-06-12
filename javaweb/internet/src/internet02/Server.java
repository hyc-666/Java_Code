package internet02;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hyc
 * @date 2020/6/4
 */
public class Server {
    public static int PORT = 9966;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket client = serverSocket.accept();
        threadPool.submit(new ServerTask(client));
    }
    private static class ServerTask implements Runnable{
        private Socket client;

        public ServerTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {

        }
    }
}
