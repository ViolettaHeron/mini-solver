public class Variable {
    private DoubleLinkedList domain_;
    private int delta_; // (le delta n'est-il pas dans la dll du domaine ?) Ici on met le delta : todo déterminer le type et déterminer si le delta est utile
    private Propagation p_;// Définir ici un pointeur vers la fonction de propagation : quand une var est modifiee on l'ajoute dans la queue si elle n'y est pas deja

    Variable(){
        p_ = new Propagation();
    }

    public boolean is_in_domain(int a) {
        // retourne vraie si a est dans le domaine et faux sinon
        return domain_.findInDDL(a) != null;
    }

    public boolean remove_value(int a) { // Cette fonction retourne faux si on supprime le dernier element du domaine
        if (is_in_domain(a)) {
            // Pour simplifier on peut considerer que les valeurs vont de 0 à d
            add_to_delta(a); // on ajoute a dans le delta de la variable
            p_.add_to_queue(this);

        }
        return true;
    }

    public void add_to_delta(int a) {
        try {
            domain_.removeElement(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // retourne vraie si le delta est vide et faux sinon
    public boolean is_delta_empty() {
        return domain_.areThereDeletedElements();
    }

    public void reset_delta() {
        // cette fonction remet le delta à 0
        domain_.putBackAll();
    }
}
