package sample.rpc.avro.server;

import org.apache.avro.AvroRemoteException;
import sample.rpc.protocol.Calculator;

/**
 * @author Mostafa Asgari
 * @website https://bigdatacode.wordpress.com/
 * @since 4/12/16
 */

public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) throws AvroRemoteException {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) throws AvroRemoteException {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) throws AvroRemoteException {
        return a*b;
    }

    @Override
    public int divide(int a, int b) throws AvroRemoteException {
        if( b == 0 )
            throw new AvroRemoteException("can not divide by zero");

        return a/b;
    }
}
