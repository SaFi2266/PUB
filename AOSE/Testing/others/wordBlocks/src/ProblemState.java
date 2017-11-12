import java.util.ArrayList;

public class ProblemState implements Comparable<Object> {
    ProblemState parent;
    ArrayList<Predicate> world;
    Action actionTaken;
    int g, h;

    public ProblemState(ProblemState parent, ArrayList<Predicate> world, Action actionTaken, int g, int h) {
        this.parent = parent;
        this.world = world;
        this.actionTaken = actionTaken;
        this.g = g;
        this.h = h;
    }

    public int getF() {
        return g + h;
    }

    public int compareTo(Object o) {
        ProblemState other = (ProblemState) o;
        return Integer.compare(this.getF(), other.getF());
    }
}
