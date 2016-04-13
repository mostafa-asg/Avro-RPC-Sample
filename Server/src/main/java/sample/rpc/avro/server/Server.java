package sample.rpc.avro.server;

import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;
import sample.rpc.protocol.Calculator;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Mostafa Asgari
 * @website https://bigdatacode.wordpress.com/
 * @since 4/12/16
 */
public class Server {

    public static void main(String[] args) throws IOException {

        if( args.length == 0 )
        {
            System.err.println("please specify port number");
            System.exit(-1);
        }

        int port = Integer.parseInt( args[0] );

        NettyServer server = new NettyServer(new SpecificResponder(Calculator.class,new CalculatorImpl()) , new InetSocketAddress(port));
        System.out.println("server started ...");

        System.out.println("please any key to exit");
        System.in.read();
        server.close();
        System.out.println("server closed ...");
    }

}
