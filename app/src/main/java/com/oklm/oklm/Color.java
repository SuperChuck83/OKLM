package com.oklm.oklm;

/**
 * Created by aiello on 26/04/2016.
 */
public enum Color {
    // Eléments contenant une position définit par l'utilisateur

    Rouge(0), Bleu(1), Vert(2), Gris(3);
    // constructeur affectant la position
    private final int NumColor;
    private Color(int NumColor) {
        this.NumColor = NumColor;
    }
    // getter
    public int getNumColor() {
        return NumColor;
    }



}
