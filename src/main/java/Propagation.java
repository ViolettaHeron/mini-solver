import java.util.ArrayDeque;
import java.util.ArrayList;

public class Propagation {
    private ArrayDeque<Variable> q;
    private ArrayList<Contrainte> consts;
    private ArrayList<Variable> vars;

    Propagation() {
        q = new ArrayDeque<>();
        consts = new ArrayList<>();
        vars = new ArrayList<>();
    }

    public void add_variable(Variable v) {
        v.setPropagation(this);
        vars.add(v);
        add_to_queue(v);
    }

    public void add_constraint(Contrainte c) {
        consts.add(c);
    }

    public void add_to_queue(Variable x) {
        // Cette fonction ajoute x dans la queue si x n'est pas déja dans la queue (on peut mettre un marqueuer dans Variable ou bien fait un tableau de marqueur
        if (!q.contains(x)) {
            q.push(x);
        }
    }

    public Variable pick_in_queue() {
        // cette fonction prend une var dans la queue et la supprime de la queue
        return q.pop();
    }

    public boolean run() { // propagation slide 7 cours

        while (!q.isEmpty()) {
            Variable x = pick_in_queue();
            for (Contrainte c : consts) { // for each constraint involving x
                if (c.getX_() == x || c.getY_() == x) {
                    if (!c.filter_from(x)) {
                        return false;
                    }
                }
            }
            x.reset_delta();
        }
        return true;
    }
}
 