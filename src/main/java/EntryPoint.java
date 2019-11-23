public class EntryPoint {

    public static void main(String[] args) {
        Propagation fourQueensDomReduction = new Propagation();

        Variable r1 = new Variable("r1", new int[]{1, 2, 3, 4});
        Variable r2 = new Variable("r2", new int[]{1, 2, 3, 4});
        Variable r3 = new Variable("r3", new int[]{1, 2, 3, 4});
        Variable r4 = new Variable("r4", new int[]{1, 2, 3, 4});

        Contrainte r1r2 = new AC3Contrainte(r1, r2, new int[][]{{1, 3}, {1, 4}, {2, 4}, {3, 1}, {4, 1}, {4, 2}});
        Contrainte r1r3 = new AC3Contrainte(r1, r3, new int[][]{{1, 2}, {1, 4}, {2, 1}, {2, 3}, {3, 2}, {3, 4}, {4, 1}, {4, 3}});
        Contrainte r1r4 = new AC3Contrainte(r1, r4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {2, 4}, {3, 1}, {3, 2}, {3, 4}, {4, 2}, {4, 3}});
        Contrainte r2r3 = new AC3Contrainte(r2, r3, new int[][]{{1, 3}, {1, 4}, {2, 4}, {3, 1}, {4, 1}, {4, 2}});
        Contrainte r2r4 = new AC3Contrainte(r2, r4, new int[][]{{1, 2}, {1, 4}, {2, 1}, {2, 3}, {3, 2}, {3, 4}, {4, 1}, {4, 3}});
        Contrainte r3r4 = new AC3Contrainte(r3, r4, new int[][]{{1, 3}, {1, 4}, {2, 4}, {3, 1}, {4, 1}, {4, 2}});

        fourQueensDomReduction.add_variable(r1);
        fourQueensDomReduction.add_variable(r2);
        fourQueensDomReduction.add_variable(r3);
        fourQueensDomReduction.add_variable(r4);

        fourQueensDomReduction.add_constraint(r1r2);
        fourQueensDomReduction.add_constraint(r1r3);
        fourQueensDomReduction.add_constraint(r1r4);
        fourQueensDomReduction.add_constraint(r2r3);
        fourQueensDomReduction.add_constraint(r2r4);
        fourQueensDomReduction.add_constraint(r3r4);

        fourQueensDomReduction.run();

        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        System.out.println(r4.toString());
    }
}
