package sample.rpc.avro.client;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import sample.rpc.protocol.Calculator;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Mostafa Asgari
 * @website https://bigdatacode.wordpress.com/
 * @since 4/12/16
 */
public class Client {

    public static void main(String[] args) throws IOException {

        if( args.length == 0 )
        {
            System.err.println("please specify server port");
            System.exit(-1);
        }

        int serverPort = Integer.parseInt( args[0] );

        NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(serverPort));
        Calculator proxy = SpecificRequestor.getClient(Calculator.class, client);
        System.out.println("Client built, got proxy");

        int result = 0;

        System.out.println("Calling add method on server with a=7 and b=8");
        result = proxy.add(7,8);
        System.out.println("server replied = " + result);

        System.out.println("Calling multiply method on server with a=7 and b=8");
        result = proxy.multiply(7,8);
        System.out.println("server replied = " + result);

        System.out.println("Calling subtract method on server with a=24 and b=6");
        result = proxy.subtract(24,6);
        System.out.println("server replied = " + result);

        System.out.println("Calling divide method on server with a=24 and b=6");
        result = proxy.divide(24,6);
        System.out.println("server replied = " + result);

        System.out.println("Finish");
    }

}
