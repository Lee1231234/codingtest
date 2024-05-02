import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
      int[] answer = new int[balls.length];

		for (int i = 0; i < balls.length; i++) {
			int targetX = balls[i][0];
			int targetY = balls[i][1];
             
            ArrayList<ArrayList<Integer>> tlist =new ArrayList<>();
			int curlen, len = Integer.MAX_VALUE;
        
 
			// 좌
			if (!(startY == targetY && startX > targetX)) {
                ArrayList<Integer> list = new ArrayList<>();
				list.add(targetX*-1);	
                list.add(targetY);
                tlist.add(list);
			}
			// 우
			if (!(startY == targetY && startX < targetX)) {
				ArrayList<Integer> list =new ArrayList<>();
				list.add(m+m-targetX);	
                list.add(targetY);	
                tlist.add(list);
			}
			// 상
			if (!(startX == targetX && startY < targetY)) {
                ArrayList<Integer> list =  new ArrayList<>();
				list.add(targetX);	
                list.add(n+n-targetY);	
                tlist.add(list);               
			}
			// 하
			if (!(startX == targetX && startY > targetY)) {				
                ArrayList<Integer> list = new ArrayList<>();
				list.add(targetX);	
                list.add(targetY*-1);	
                tlist.add(list);                              
			}
			for(ArrayList<Integer> k : tlist){
                int tmp = cal(k,startX,startY);
                len= Math.min(tmp,len);
            }
			answer[i] = len;
		}

		return answer;
    }
    
    int cal(ArrayList<Integer> k,int startX, int startY){
        int bigX = Math.max(startX, k.get(0));
        int smallX = Math.min(startX, k.get(0));
        int bigY = Math.max(startY, k.get(1));
        int smallY = Math.min(startY, k.get(1));

        return (int)Math.pow(bigX - smallX, 2) + (int)Math.pow(bigY - smallY, 2);
    }
    
}