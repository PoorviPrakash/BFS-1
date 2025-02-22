/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int size=0;
        if(root==null) return new ArrayList<>();
        res.add(Arrays.asList(root.val));
        if(root.left!=null){
            bfs.add(root.left);
        }
        if(root.right!=null){
            bfs.add(root.right);
        }
        while(!bfs.isEmpty()){
            size = bfs.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = bfs.poll();
                if(node.left!=null){
                    bfs.add(node.left);
                }
                if(node.right!=null){
                    bfs.add(node.right);
                }
                temp.add(node.val);
            }
            res.add(temp);
        }

        return res;
    }
}

//TC - O(N) //Traversing each node once
//SC - O(N) //Storing the nodes in the queue