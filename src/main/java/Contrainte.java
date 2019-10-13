public class Contrainte {
    // contrainte binaire
    private Variable x_; // premiere var
    private Variable y_; // seconde var
    // table_; // faire une structure de table [valforX,valforY]

    public boolean filter_from(Variable x){ // Cette fonction retourne faux si on  a vider un domaine !
        // L'idee générale est :
        if (x==x_){
            // on filtre a partir du domaine de x_, donc on doit filter y_
        } else {
            // on filtre a partir du domaine de y_, donc on doit filter x_

        }
        return true;
    }

}