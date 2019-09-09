package modern.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {                       
              
        CircularByteBuffer cbb = new CircularByteBuffer(3);
               
        cbb.put(1);
        cbb.put(2);
        cbb.put(3);

        System.out.println("Available before get: " + cbb.available());
        System.out.println("get: " + cbb.get());
        System.out.println("Available after get: " + cbb.available());
        cbb.clear();
        System.out.println("Available after clear: " + cbb.available());
    }

}
