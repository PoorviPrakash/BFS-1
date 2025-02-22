class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> depMap = new HashMap<>();
        int[] depArray = new int[numCourses];
        Queue<Integer> bfs = new LinkedList<Integer>();

        for(int[] pre : prerequisites){
            if(depMap.containsKey(pre[1])){
                depMap.get(pre[1]).add(pre[0]);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(pre[0]);
                depMap.put(pre[1],temp);
            }
            depArray[pre[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(!depMap.containsKey(i)){
                ArrayList<Integer> temp = new ArrayList<>();
                depMap.put(i,temp);
            }
        }

        for(int i=0;i<depArray.length;i++){
            if(depArray[i]==0){
                bfs.add(i);
                depArray[i]--;
            }
        }

        while(!bfs.isEmpty()){
            int c = bfs.poll();

            for(int i=0;i<depMap.get(c).size();i++){
                depArray[depMap.get(c).get(i)]--;
            }

            for(int i=0;i<depArray.length;i++){
                if(depArray[i]==0){
                    bfs.add(i);
                    depArray[i]--;
                }
            }
        }

        for(int i:depArray){
            if(i>0) return false;
        }

        return true;

    }
}

//TC - O(M+N) where m is the edges and n are the number of nodes.
//SC - O(M+N) For the hashMap  + indegree array