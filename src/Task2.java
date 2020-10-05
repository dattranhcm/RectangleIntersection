import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Rect r1 = new Rect(2, 3, 5, 6);
        Rect r2 = new Rect(3, 1, 4, 4);
        if (r1.isIntersect(r2)) {
            System.out.println("r1 and r2 have intersection");
        } else {
            System.out.println("r1 and r2 do not have intersection");
        }
        Rect u1 = r1.intersect(r2);
        System.out.println(u1);
        System.out.println("Overlapped area is: " + u1.calcArea());
    }
}

class Rect {
    private Integer x1;
    private Integer x2;
    private Integer y1;
    private Integer y2;
    private Integer width;
    private Integer height;

    public Rect() {}

    public Rect(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.width = x2 - x1;
        this.height = y2 - y1;
    }

    public Integer calcArea() {
        return this.width * this.height;
    }

    public Boolean isIntersect(Rect rect) {
        if ((rect.getY2() > this.y2 && rect.getY1() < this.y1)
                && (rect.getX1() < this.x2 && rect.getX2() < this.x2)) {
            return true;
        }

        int flag = 0;
        if ((rect.getX1() >= this.x1 && rect.getX1() <= this.x2)
                || (rect.getX2() >= this.x1 && rect.getX2() <= this.x2)) {
            flag = flag + 1;
        }
        if ((rect.getY1() >= this.y1 && rect.getY1() <= this.y2)
                || (rect.getY2() >= this.y1 && rect.getY2() <= this.y2)) {
            flag = flag + 1;
        }
        return (flag == 2) ? true: false;
    }

    public Rect intersect(Rect rect) {
        if (!isIntersect(rect)) {
            return new Rect(0, 0, 0, 0);
        }
        int minX = (this.x1 < rect.getX1()) ? this.x1 : rect.getX1();
        int maxX = (this.x2 > rect.getX2()) ? this.x2 : rect.getX2();
        int minY = (this.y1 < rect.getY1()) ? this.y1 : rect.getY1();
        int maxY = (this.y2 > rect.getY2()) ? this.y2 : rect.getY2();
        List<Integer> samePointX = new ArrayList<>();
        List<Integer> samePointY = new ArrayList<>();
        // found the points that belong to both of this rectangle X line and target rectangle X line
        for(int x = minX; x <= maxX; x++) {
            if ((x >= this.x1 && x <= this.x2) && (x >= rect.getX1() && x <= rect.getX2())) {
                samePointX.add(x);
            }
        }
        // found the points that belong to both of this rectangle Y line and target rectangle Y line
        for(int y = minY; y <= maxY; y++) {
            if ((y >= this.y1 && y <= this.y2) && (y >= rect.getY1() && y <= rect.getY2())) {
                samePointY.add(y);
            }
        }
        return new Rect(samePointX.get(0), samePointY.get(0), samePointX.get(samePointX.size()-1),samePointY.get(samePointY.size()-1));
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s)", x1, y1, x2, y2);
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }
}
