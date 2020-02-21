package com.ensimag;

import com.ensimag.Algorithms.BL;
import com.ensimag.Files.FileIn;
import com.ensimag.Models.Plate;
import com.ensimag.Models.Rectangle;

public class Main {

    public static void main(String[] args) {
        FileIn myFileIn = new FileIn("entries.txt");
        myFileIn.loadEntries();
        BL myBL = new BL(myFileIn);

        myBL.start();

        /*
        BLAdvanced myBLA = new BLAdvanced(myFileIn);
        printStatus(myFileIn);
        myBLA.start();
        printStatus(myFileIn);
        */
    }

    private static void printInventory(FileIn myFileIn) {
        System.out.println();
        for (Plate p : myFileIn.getPlates().keySet()) {
            System.out.println("Plaque H="+p.getH()+" / W="+p.getW()+" / Quantité="+myFileIn.getPlates().get(p));
        }
        for (Rectangle p : myFileIn.getPieces().keySet()) {
            System.out.println("Pièce H="+p.getH()+" / W="+p.getW()+" / Quantité="+myFileIn.getPieces().get(p));
        }
        System.out.println();
    }
}
