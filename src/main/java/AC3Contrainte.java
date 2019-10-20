public class AC3Contrainte extends Contrainte {


    public AC3Contrainte(Variable x, Variable y) {
        super(x, y);
    }

    public AC3Contrainte(Variable x, Variable y, int[][] binaryR) {
        super(x, y, binaryR);
    }

    public boolean filter_from(Variable x) {

        if (x == getX_()) {
            //   on filtre a partir du domaine de x_, donc on doit filter y_

        } else if(x == getY_()) {
            //   on filtre a partir du domaine de y_, donc on doit filter x_
        }

        // Cette fonction retourne faux si on  a vidé un domaine !
        return false;
    }
}
