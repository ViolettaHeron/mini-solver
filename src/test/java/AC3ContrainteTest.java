import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC3ContrainteTest {
    private Contrainte c1;
    Variable x;
    Variable y;

    @BeforeEach
    public void setup() {
        x = new Variable("x", new int[]{1, 2, 3});
        y = new Variable("y", new int[]{1, 2, 3});
        c1 = new AC3Contrainte(x, y, new int[][]{{1, 1}, {1, 2}, {2, 3}, {3, 2}, {3,1}});

        Propagation p = new Propagation();
        x.setPropagation(p);
        y.setPropagation(p);

    }

    @Test
    public void testFilterEmptySupport() {
        x.remove_value(2); // the value 3 in y doesn't have a support anymore.
        c1.filter_from(x);

        assertFalse(y.is_in_domain(3));
        assertTrue(y.is_in_domain(2));
    }

    @Test
    public void testFilterNonEmptySupport(){
        x.remove_value(1); // this should have no inscidence on the support of any value of y
        c1.filter_from(x);

        assertTrue(y.is_in_domain(1));
        assertTrue(y.is_in_domain(2));
        assertTrue(y.is_in_domain(3));
    }


}
