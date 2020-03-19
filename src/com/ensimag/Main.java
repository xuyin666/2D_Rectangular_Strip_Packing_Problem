package com.ensimag;

import com.ensimag.Algorithms.BL2in1;
import com.ensimag.Algorithms.OptimizedSolver;
import com.ensimag.Files.FileIn;
import com.ensimag.Models.Plate;
import com.ensimag.Models.Rectangle;

public class Main {

    public static void main(String[] args) {
        FileIn myFileIn = new FileIn("entries.txt");
        myFileIn.loadEntries();

        BL2in1 myBL2in1v1 = new BL2in1(myFileIn);
        BL2in1 myBL2in1v2 = new BL2in1(myFileIn);
        OptimizedSolver myOptimizedSolver = new OptimizedSolver(myFileIn);

        myBL2in1v1.start(false);
        myBL2in1v2.start(true);

        myOptimizedSolver.start();

        //FileCheck myFileCheck = new FileCheck("resultsBL.txt");
        //myFileCheck.loadEntries();
        //Checker myChecker = new Checker(myFileCheck);
        //myChecker.start();
    }

    private static void printInventory(FileIn myFileIn) {
        System.out.println();
        for (Plate p : myFileIn.getPlates().keySet()) {
            System.out.println("Plaque H=" + p.getH() + " / W=" + p.getW() + " / Quantité=" + myFileIn.getPlates().get(p));
        }
        for (Rectangle p : myFileIn.getPieces().keySet()) {
            System.out.println("Pièce H=" + p.getH() + " / W=" + p.getW() + " / Quantité=" + myFileIn.getPieces().get(p));
        }
        System.out.println();
    }
}
