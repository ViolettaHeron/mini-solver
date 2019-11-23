public class AC3Contrainte extends Contrainte {


    public AC3Contrainte(Variable x, Variable y) {
        super(x, y);
    }

    public AC3Contrainte(Variable x, Variable y, int[][] binaryR) {
        super(x, y, binaryR);
    }

    public boolean filter_from(Variable a) {

        if (a == getX_()) {
            // on filtre a partir du domaine de x_, donc on doit filter y_
            // AC3 : on revoit tout le domaine
            for (int val : getY_().getDomain_().toArray()) {
                if (this.getSupportInX(val).isEmpty()) {
                    // enlever la valeur du domaine (se charge de mettre y dans les variables à étudier)
                    getY_().remove_value(val);
                    if(getY_().getDomain_().isEmpty()) {
                        return false;
                    }
                }
            }

        } else if (a == getY_()) {
            //   on filtre a partir du domaine de y_, donc on doit filter x_

            for (int val : getX_().getDomain_().toArray()) {
                if (this.getSupportInY(val).isEmpty()) {
                    getX_().remove_value(val);
                    if(getX_().getDomain_().isEmpty()) {
                        return false;
                    }
                }
            }
        }

        // Cette fonction retourne faux si on  a vidé un domaine !
        return true;
    }
}
