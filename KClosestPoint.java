public class CPPoint{
	
	public int x;
	public int y;
	
	public CPPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
}


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoint {

	public static void main(String[] args) {
		CPPoint a = new CPPoint(2, 3);
		CPPoint b = new CPPoint(1,1);
		CPPoint c = new CPPoint(8,5);
		CPPoint d = new CPPoint(2, 4);
		CPPoint f = new CPPoint(-1,0);
		
		CPPoint[] p = {a,b,c,d,f};
		System.out.println(findKClosest(p, 3));

	}
	public static List<CPPoint> findKClosest(CPPoint[] p, int k){
  
		PriorityQueue<CPPoint> pq = new PriorityQueue<CPPoint>(k,new Comparator<CPPoint>() {
			@Override
			public int compare(CPPoint a, CPPoint b){
				int dis= (a.x*a.x + a.y*a.y)-(b.x*b.x - b.y*b.y);
        //convert min priority queue to max priority queue.
				if(dis<0){
					return 1;
				}
				else{
					return -1;
				}
			}
		});
    
		for(int i =0; i<p.length;i++){
			if(i<k){
				pq.offer(p[i]);
			}else{
				CPPoint topPoint = pq.peek();
				if((p[i].x*p[i].x+ p[i].y*p[i].y)-(topPoint.x*topPoint.x + topPoint.y*topPoint.y)<0){
					pq.poll();
					pq.offer(p[i]);
				}
			}
		}
    
		List<CPPoint> result = new ArrayList<CPPoint>();
		while(!pq.isEmpty()){
			result.add(pq.poll());
		}
    
		return result;
    
	}
  
}
