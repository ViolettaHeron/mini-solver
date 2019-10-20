import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ContrainteTest {
    private Contrainte c1;

    @BeforeEach
    public void setup() {
        Variable q1 = new Variable("q1");
        Variable q2 = new Variable("q2");
        c1 = new AC3Contrainte(q1,q2, new int[][]{{1,3},{1,4},{2,4},{3,1},{4,1},{4,2}});
    }

}