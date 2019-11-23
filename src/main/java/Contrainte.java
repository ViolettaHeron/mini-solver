import java.util.ArrayList;
import java.util.Arrays;

public abstract class Contrainte {
    // contrainte binaire
    private Variable x_; // premiere var
    private Variable y_; // seconde var
    int[][] table_; // faire une structure de table [valforX,valforY]

    public Contrainte(Variable x, Variable y) {
        x_ = x;
        y_ = y;
    }

    public Contrainte(Variable x, Variable y, int[][] binaryR) {
        this(x, y);
        table_ = Arrays.copyOf(binaryR, binaryR.length);
    }

    public Variable getX_() {
        return x_;
    }

    public Variable getY_() {
        return y_;
    }

    public int[][] getTable_() {
        return table_;
    }

    public ArrayList<Integer> getSupportInX(int value){
        ArrayList<Integer> support = new ArrayList<>();
        for(int[] cable : table_){
            if(cable[1] == value && x_.is_in_domain(cable[0])){
                support.add(cable[0]);
            }
        }
        return support;
    }

    public ArrayList<Integer> getSupportInY(int value){
        ArrayList<Integer> support = new ArrayList<>();
        for(int[] cable : table_){
            if(cable[0] == value && y_.is_in_domain(cable[1])){
                support.add(cable[1]);
            }
        }
        return support;
    }

    // implement in child classes with AC strategy
    public abstract boolean filter_from(Variable x); // Cette fonction retourne faux si on  a vidé un domaine !

    /*
     L'idee générale est :
        if (x==x_){
             on filtre a partir du domaine de x_, donc on doit filter y_
        } else {
             on filtre a partir du domaine de y_, donc on doit filter x_
        }
    */
}