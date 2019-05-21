package modern.challenge;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        ViaBody vb = new ViaBody();
        vb.bodyExample();
        
        ViaHeaderBearer vhb = new ViaHeaderBearer();
        vhb.bearerExample();
    }

}
