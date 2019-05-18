package modern.challenge;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        // Avoid 
        //var bin = Bins.fetchBinContent();

        // Prefer
        File bin = Bins.fetchBinContent();
    }

}
