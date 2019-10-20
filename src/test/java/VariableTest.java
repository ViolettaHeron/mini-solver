import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VariableTest {
    Variable z;

    @BeforeEach
    public void setup() {
        z = new Variable("z", new int[]{1, 2, 5, 6});
    }

    @Test
    public void checkDomain() {
        assertTrue(z.is_in_domain(1), "1 should be in the domain of " + z);
        assertFalse(z.is_in_domain(3), "3 should not be in the domain of " + z);
    }

    @Test
    public void canAddValueToDelta() {
        assertTrue(z.is_delta_empty(), "the delta should be empty");
        z.add_to_delta(1);
        assertFalse(z.is_delta_empty(), "the delta should contain 1");
    }

    @Test
    public void canEmptyDelta() {
        z.add_to_delta(1);
        z.add_to_delta(2);
        z.reset_delta();
        assertTrue(z.is_delta_empty(), "data should have been pulled from delta");
    }
}
