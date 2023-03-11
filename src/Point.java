public class Point{
    private final int x;
    private final int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(Point original)
    {
        this.x = original.getX();
        this.y = original.getY();
    }

    public void printPoint()
    {
        System.out.print("(" + this.x + ", " + this.y + ")");
    }
}