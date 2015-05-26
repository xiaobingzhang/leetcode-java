 

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxPointsonaLine {
	public static void main(String[] args) {
		MaxPointsonaLine mol = new MaxPointsonaLine();
		Point[] points = { new Point(84, 250), new Point(0, 0),
				new Point(1, 0), new Point(0, -70), new Point(0, -70),
				new Point(1, -1), new Point(21, 10), new Point(42, 90),
				new Point(-42, -230) };
		Point[] array = { new Point(40, -23), new Point(9, 138),
				new Point(429, 115), new Point(50, -17), new Point(-3, 80),
				new Point(-10, 33), new Point(5, -21), new Point(-3, 80),
				new Point(-6, -65), new Point(-18, 26), new Point(-6, -65),
				new Point(5, 72), new Point(0, 77), new Point(-9, 86),
				new Point(10, -2), new Point(-8, 85), new Point(21, 130),
				new Point(18, -6), new Point(-18, 26), new Point(-1, -15),
				new Point(10, -2), new Point(8, 69), new Point(-4, 63),
				new Point(0, 3), new Point(-4, 40), new Point(-7, 84),
				new Point(-8, 7), new Point(30, 154), new Point(16, -5),
				new Point(6, 90), new Point(18, -6), new Point(5, 77),
				new Point(-4, 77), new Point(7, -13), new Point(-1, -45),
				new Point(16, -5), new Point(-9, 86), new Point(-16, 11),
				new Point(-7, 84), new Point(1, 76), new Point(3, 77),
				new Point(10, 67), new Point(1, -37), new Point(-10, -81),
				new Point(4, -11), new Point(-20, 13), new Point(-10, 77),
				new Point(6, -17), new Point(-27, 2), new Point(-10, -81),
				new Point(10, -1), new Point(-9, 1), new Point(-8, 43),
				new Point(2, 2), new Point(2, -21), new Point(3, 82),
				new Point(8, -1), new Point(10, -1), new Point(-9, 1),
				new Point(-12, 42), new Point(16, -5), new Point(-5, -61),
				new Point(20, -7), new Point(9, -35), new Point(10, 6),
				new Point(12, 106), new Point(5, -21), new Point(-5, 82),
				new Point(6, 71), new Point(-15, 34), new Point(-10, 87),
				new Point(-14, -12), new Point(12, 106), new Point(-5, 82),
				new Point(-46, -45), new Point(-4, 63), new Point(16, -5),
				new Point(4, 1), new Point(-3, -53), new Point(0, -17),
				new Point(9, 98), new Point(-18, 26), new Point(-9, 86),
				new Point(2, 77), new Point(-2, -49), new Point(1, 76),
				new Point(-3, -38), new Point(-8, 7), new Point(-17, -37),
				new Point(5, 72), new Point(10, -37), new Point(-4, -57),
				new Point(-3, -53), new Point(3, 74), new Point(-3, -11),
				new Point(-8, 7), new Point(1, 88), new Point(-12, 42),
				new Point(1, -37), new Point(2, 77), new Point(-6, 77),
				new Point(5, 72), new Point(-4, -57), new Point(-18, -33),
				new Point(-12, 42), new Point(-9, 86), new Point(2, 77),
				new Point(-8, 77), new Point(-3, 77), new Point(9, -42),
				new Point(16, 41), new Point(-29, -37), new Point(0, -41),
				new Point(-21, 18), new Point(-27, -34), new Point(0, 77),
				new Point(3, 74), new Point(-7, -69), new Point(-21, 18),
				new Point(27, 146), new Point(-20, 13), new Point(21, 130),
				new Point(-6, -65), new Point(14, -4), new Point(0, 3),
				new Point(9, -5), new Point(6, -29), new Point(-2, 73),
				new Point(-1, -15), new Point(1, 76), new Point(-4, 77),
				new Point(6, -29) };
		Point[] p  ={new Point(0,0)};
		Point[] p2  ={new Point(0,0),new Point(1,1)};
		Point[] p1  ={new Point(1,1),new Point(1,1),new Point(1,1)};
		int ret = mol.maxPoints2(p2);
		System.out.println(ret);
	}

	public int maxPoints2(Point[] points) {
		int ret= 0 ;
		for (int i = 0; i < points.length; i++) {
			Map<Float, Integer> map = new HashMap<Float, Integer>();
			map.put((float) Integer.MIN_VALUE, 0);
			int duplicate = 1;
			for (int j = 0; j < points.length; j++) {
				if(i == j){
					continue;
				}
				if(points[i].x==points[j].x&&points[i].y==points[j].y){
					duplicate++;
					continue;
				}
				float k = points[i].x == points[j].x ? Integer.MAX_VALUE : (float)(points[j].y-points[i].y)/(points[j].x-points[i].x);
				if(map.get(k) == null){
					map.put(k, 1);
				}else{
					map.put(k, map.get(k)+1);
				}
			}
			
			for(Float key :map.keySet()){
				if(map.get(key)+duplicate >ret){
					ret= map.get(key)+duplicate;
				}
			}
			
		}
		return ret;
	}

	public int maxPoints(Point[] points) {// TLE
		int ret = 0;
		if (points.length < 3) {
			return points.length;
		}
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					continue;
				}
				int sum = 0;
				for (int k = 0; k < points.length; k++) {
					float tmp1 = (float) (points[i].y - points[k].y)
							* (points[k].x - points[j].x);
					float tmp2 = (float) (points[k].y - points[j].y)
							* (points[i].x - points[k].x);
					if (tmp1 == tmp2) {
						sum++;
					}
				}
				ret = Math.max(sum, ret);
			}
		}
		return ret;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}