import java.util.ArrayDeque;

public class Propagation {
    ArrayDeque<Variable> q;

    Propagation() {
        q = new ArrayDeque();
    }

    public void add_to_queue(Variable x) {
        // Cette fonction ajoute x dans la queue si x n'est pas déja dans la queue (on peut mettre un marqueuer dans Variable ou bien fait un tableau de marqueur
        q.push(x);
    }

    public Variable pick_in_queue() {
        // cette fonction prend une var dans la queue et la supprime de la queue
        return q.pop();
    }

    public void run() { // todo : déterminer type de retour
        // tant que queue_ n'est pas vide
        // prendre x dans queue_ avec pick in queue
        // pour chaque contrainte c impliquant x
        // bool ret=c->filter_from(x);
        // if (!ret) // on arrete l'algo: un domaine est vide
        // fin pour
        // x->reset_delta();
        // fn tant que
    }
}
 