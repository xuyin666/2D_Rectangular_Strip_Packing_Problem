package com.ensimag.Models;

import com.ensimag.Sorts.SortByCoords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by solokwal on 2/20/20.
 */
public class Cut {
    private int lost;
    private List<PieceWithCoords> info;

    public Cut() {
        this.lost = 0;
        this.info = new ArrayList<>();
    }

    public Cut(Cut clone) {
        this.lost = clone.getLost();
        this.info = new ArrayList<>();
        this.info.addAll(clone.getInfo());
    }

    public Cut(int _lost, List<PieceWithCoords> _info) {
        this.lost = _lost;
        this.info = new ArrayList<>();
        if (_info != null) {
            this.info.addAll(_info);
        }
    }

    public int getLost() {
        return this.lost;
    }

    public void addLost(int yes) { this.lost += yes; }

    public List<PieceWithCoords> getInfo() {
        return this.info;
    }

    public void addInfo(PieceWithCoords newInfo) {
        this.info.add(newInfo);
    }

    /**
     * Fonction qui écrit les pièces qui n'ont pas été utilisées et les pertes
     * @param pieces les pièces non utilisées
     * @param totalLost les pertes de toutes les plaques
     * @return une liste de string énoncant les pièces non utilisées et les pertes totales ( seconde partie du fichier de résultat )
     */
    public List<String> toStringEnd(Map<Piece, Integer> pieces, int totalLost){
        List<String> endResult = new ArrayList<>();
        endResult.add("Pièces restantes à couper :");
        String information = "";
        for (Piece p : pieces.keySet()) {
            if (pieces.get(p) > 0) {
                for (int i = 0; i < pieces.get(p); i++) {
                    information = information + p.getH() + " " + p.getW() + ", ";
                }
            }
        }
        if (information.equals("")) {
            information = "Aucune.";
        }
        endResult.add(information);
        endResult.add("Chutes :");
        endResult.add(String.valueOf(totalLost));
        return endResult;
    }

    /**
     * Fonction qui écrit la découpe de la plaque
     * @param plateNumber : le numéro de la plaque
     * @return une liste de string énoncant le positionnement de toutes les pièces découpées dans la plaque
     */
    public List<String> toString(int plateNumber){
        List<String> endResult = new ArrayList<>();
        if (this.getInfo().size() == 0) {
            endResult.add("Plaque " + plateNumber + " :");
            endResult.add("Pas utilisée.");
        } else {
            String information = "Plaque " + plateNumber + " :";
            int yCurrent = -1;
            this.sortInfo();
            for (PieceWithCoords plate : this.info) {
                if (plate.getY() > yCurrent) {
                    endResult.add(information);
                    endResult.add("LS=" + plate.getY());
                    yCurrent = plate.getY();
                    information = "";
                }
                information = information + plate.getX() + " " + plate.getH() + " " + plate.getW() + ", ";
            }
            endResult.add(information);
        }
        return endResult;
    }

    public void fusion(Cut toFusion) {
        if (toFusion.getInfo().size() > 0) {
            this.info.addAll(toFusion.getInfo());
        }
        this.lost = this.lost + toFusion.getLost();
    }

    private void sortInfo() {
        this.info.sort(new SortByCoords());
    }
}
