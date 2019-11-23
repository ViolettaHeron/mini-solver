import java.util.ArrayList;

public class Variable {
    private String identifiant;

    private DoubleLinkedList domain_;
    // private int delta_; // (le delta n'est-il pas dans la dll du domaine ?) Ici on met le delta : todo déterminer si le delta est utile et son type
    private Propagation p_;// Définir ici un pointeur vers la fonction de propagation : quand une var est modifiee on l'ajoute dans la queue si elle n'y est pas deja

    public Variable(String id) {
        domain_ = new DoubleLinkedList();
        identifiant = id;
    }

    public Variable() {
        this("noname");
    }

    public Variable(String id, int[] domain) {
        this(id);
        for (int val : domain) {
            domain_.chain(val);
        }
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public DoubleLinkedList getDomain_() {
        return domain_;
    }

    public boolean is_in_domain(int a) {
        // retourne vraie si a est dans le domaine et faux sinon
        return domain_.findInDDL(a) != null;
    }

    // quand on enlève une valeur du domaine de y, on doit filtrer à nouveau
    public boolean remove_value(int a) { // Cette fonction retourne faux si on supprime le dernier element du domaine
        if (is_in_domain(a)) {
            // Pour simplifier on peut considerer que les valeurs vont de 0 à d
            add_to_delta(a); // on ajoute a dans le delta de la variable
            p_.add_to_queue(this);
        }
        return domain_.isEmpty();
    }

    public void add_to_delta(int a) {
        try {
            domain_.removeElement(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // retourne vrai si le delta est vide et faux sinon
    public boolean is_delta_empty() {
        return !domain_.areThereDeletedElements();
    }

    public void reset_delta() {
        // cette fonction remet le delta à 0
        domain_.putBackAll();
    }

    public void setPropagation(Propagation propagation) {
        this.p_ = propagation;
    }

    public String toString() {
        return identifiant + " | domain: " + domain_.toString();
    }
}
