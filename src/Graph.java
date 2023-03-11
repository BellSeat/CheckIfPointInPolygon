import java.util.*;

public class Graph {
    private final List<Line> lines;

    public Graph(List<Point> points) {
        List<Point> points1 = new ArrayList<>(points);

        // 2. now, the Graph should transfer this points to line.

        lines = new ArrayList<>();
        for (int i = 0; i < points1.size() ; i++) {
            Point p1 = points1.get(i), p2;

            if (i + 1 < points1.size()) {
                p2 = points1.get(i + 1);
            } else {
                p2 = points1.get(0);
            }

            Line L = new Line(p1, p2);
            lines.add(L);
        }
    }


    public int size()
    {
        return lines.size();
    }
    public void printGraph()
    {
        if(this.lines == null){
            return;
        }
        for(Line l : this.lines){
            l.printLine();
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}