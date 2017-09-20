public class OverlapRectangleArea{

 public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int innerL = Math.max(A, E);
        int innerR = Math.max(innerL, Math.min(C, G));
        int innerT = Math.max(B, F);
        int innerB = Math.max(innerT, Math.min(D, H));
            return Math.abs((C - A) * (B - D) - (innerR - innerL) * (innerT - innerB) + (G -E) * (F - H));
    }
    
    public boolean doOverlap(CPPoint l1, CPPoint r1, CPPoint l2, CPPoint r2) {
    int area = computeArea(l1.x,l1.y,r1.x,r1.y,l2.x,l2.y,r2.x,r2.y);
		return ares>0;
	}
}
