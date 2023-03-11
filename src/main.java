import java.util.*;

public class main {
    public static void main(String[] args){
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(3, 0);
        Point p2 = new Point(0,0);
        Point p3 = new Point(0,3);

        points.add(p1);
        points.add(p2);
        points.add(p3);

        Graph g1 = new Graph(points);

        g1.printGraph();

        List<Point> testPoints =  new ArrayList<>()
        {
            {
                add(new Point(1, 1));
                add(new Point(p1));
                add(new Point(p2));
                add(new Point(p3));
                add(new Point(2,2));
                add(new Point(3, 3));
            }

        };

        for(Point p : testPoints){
            test(g1, p);
        }

    }

    public static boolean online(Line l, Point p){
        Point p1 = l.from();
        Point p2 = l.to();

        return p.getX() <= Math.max(p1.getX(), p2.getX())
                && p.getX() >= Math.min(p1.getX(), p2.getX())
                && p.getY() <= Math.max(p1.getY(), p2.getY())
                && p.getY() >= Math.min(p1.getY(), p2.getY());
    }

    public static int direction(Point a, Point b, Point c){
        int val = (b.getY() - a.getY()) * (c.getX() - b.getX())
                - (b.getX() - a.getX()) * (c.getY() - b.getY());
        if(val == 0){
            return 0;
        }
        if(val < 0) {
            return 2;
        }
        return 1;
    }

    public static boolean isIntersect(Line l1, Line l2){
        int dir1 = direction(l1.from(), l1.to(), l2.from());
        int dir2 = direction(l1.from(), l1.to(), l2.to());
        int dir3 = direction(l2.from(), l2.to(), l1.from());
        int dir4 = direction(l2.from(), l2.to(), l1.to());

        if(dir1 != dir2 && dir3 != dir4)
        {
            return true;
        }

        if(dir1 == 0 && online(l1, l2.from())){
            return true;
        }

        if(dir2 == 0 && online(l1, l2.to())){
            return true;
        }

        if(dir3 == 0 && online(l2, l1.from())){
            return true;
        }

        return dir4 == 0 && online(l2, l1.to());
    }

    public static boolean checkInside(Graph g, Point p)
    {
        int n = g.size();
        if(n < 3) {
            return  false;
        }
        Point bound = new Point(9999, p.getY());
        Line pLine = new Line(p,bound);

        int count = 0;
        List<Line> lines = g.getLines();

        for(int i = 0; i < n; i++)
        {
            Line sideLine = lines.get(i);
           if(isIntersect(sideLine, pLine)){
               if(direction(sideLine.from(),p,sideLine.from()) == 0){
                   return online(sideLine, p);
               }
               ++count;
           }
        }

        return count % 2 == 1;
    }


    public static void test(Graph g, Point p)
    {
        System.out.print("the Point: ");
        p.printPoint();
        if(checkInside(g,p)){
            System.out.println(" is Inside");
        }else{
            System.out.println(" is Outside");
        }
    }
}

