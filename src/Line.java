public record Line(Point from, Point to) {
    public Line(Point from, Point to) {
        this.from = new Point(from);
        this.to = new Point(to);
    }

    public void printLine() {
        this.from.printPoint();
        System.out.print("-->");
        this.to.printPoint();
        System.out.println();
    }
}