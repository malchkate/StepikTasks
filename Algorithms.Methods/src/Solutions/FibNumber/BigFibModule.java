package Solutions.FibNumber;
/*
import org.apache.commons.math3.*;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Katerina on 09.04.2018.
 */
public class BigFibModule {


/*
    static ArrayList<RealMatrix> realMatrixArray;

    public static long fibNum(int n) { // recurcive, 20 and smth
        if ((n == 0) || (n == 1)) {
            return 1;
        } else {
            return fibNum(n - 1) + fibNum(n - 2);
        }
    }

    public static long fibNum_D(int n) {   //dynamic, 25 and smth
        List<Long> list = new ArrayList<Long>();
        list.add((long) 1);
        list.add((long) 1);
        for (int i = 0; i < n - 1; i++) {
            int lastInd = list.size() - 1;
            list.add(list.get(lastInd) + list.get(lastInd - 1));
        }
        return list.get(list.size() - 1);
    }

    public static int lastDigitFib(int n) { // why recursion didn't work here?
        if ((n == 0) || (n == 1)) {
            return 1;
        } else return (lastDigitFib(n - 1) + lastDigitFib(n - 2)) % 10;
    }

    public static int lastDigitFib_D(int N_stop) { // complexity -- 19
        int a = 1;
        int b = 1;
        for (int i = 1; i < N_stop; i++) {
            int temp = a + b;
            a = b;
            b = temp % 10;
        }
        return b;
    }


    public static long modMFib(long n, long m) {
        long a = 1;
        long b = 1;
        if (n <= 2) {
            return 1;
        }
        for (long i = 1; i < n - 1; i++) {
            long temp = a + b;
            a = b;
            b = temp % m;
        }
        return b;
    }


    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    public  static RealMatrix modMRealMatrix(RealMatrix x, int rows, int cols, long m){
        double[][] temp = x.getData();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                temp[i][j] %= m;
            }
        }
        return MatrixUtils.createRealMatrix(temp);
    }

    public static double modMMatrixFib(long n, long m){
        double[][] matrixData = new double[][]{{0,1},{1,1}};
        RealMatrix transMatrix =  MatrixUtils.createRealMatrix(matrixData);
        RealMatrix res = MatrixUtils.createRealIdentityMatrix(2);
        byte[] bytesN = longToBytes(n);
        for (int i = 0; i < bytesN.length; i++){
            transMatrix = transMatrix.multiply(transMatrix);
            if (bytesN[i] == 1){
                res = res.multiply(transMatrix);
            }
            transMatrix = modMRealMatrix(transMatrix, 2, 2, m);
            res = modMRealMatrix(res, 2, 2, m);
        }
        RealMatrix fibNum = MatrixUtils.createRowRealMatrix(new double[]{1, 1});
        RealMatrix multResFib = fibNum.multiply(res);
        double fibN = multResFib.getData()[0][0];
        return fibN;
    }


    public static void main(String[] args) {
        while (true) {
            Scanner scIn = new Scanner(System.in);
            long n = scIn.nextLong();
            long m = scIn.nextLong();
            //long res = fibNum(n-1);
            //long resFib = fibNum_D(n-1);
            //int lastDig = lastDigitFib_D(n-1);
            //long modM = modMFib(n, m);
            //System.out.println(modM);
            double modM = modMMatrixFib(n, m);
            System.out.println((int)modM);
        }
    }
*/}



