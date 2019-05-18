package modern.challenge;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // is not important what this code does,
        // the focus is on naming variables in case of type inference
    }

    // Example 1
    public Object fetchTransferableDataWithoutVar(String data)
            throws UnsupportedFlavorException, IOException {

        StringSelection ss = new StringSelection(data);
        DataFlavor[] df = ss.getTransferDataFlavors();
        Object obj = ss.getTransferData(df[0]);

        return obj;
    }

    public Object fetchTransferableDataWithVar(String data)
            throws UnsupportedFlavorException, IOException {

        var stringSelection = new StringSelection(data);
        var dataFlavorsArray = stringSelection.getTransferDataFlavors();
        var obj = stringSelection.getTransferData(dataFlavorsArray[0]);

        return obj;
    }
}
