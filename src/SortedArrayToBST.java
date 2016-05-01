
import java.util.Arrays;


public class SortedArrayToBST {
	private static int[] testArray0= new int[]{0, 2}; 
	private static int[] testArray1= new int[]{0}; 
	private static int[] testArray2= new int[]{0, 2, 5}; 
	private static int[] testArray3= new int[]{0, 2, 4, 5, 6, 9, 12, 15, 18, 29, 32, 39, 42}; 
	private static int[] testArray4= new int[]{0, 2, 4, 5, 6, 39, 42}; 
	private static int[] testArray5= new int[]{0, 2, 4, 6, 39, 42}; 
	private static int[] testArray6= new int[]{}; 
	
	//Given a sorted array of unique numbers, this algorithm runs in O(log n) time.
	public static void main(String[] args){
		Node answer=findCenterNode(testArray5);
		if(answer==null)
			System.out.println("Empty BST");
		else
			System.out.println(answer.toString());
	}
	private static Node findCenterNode(int[] array){
		if(array==null||array.length==0){
			return null;
		}else if(array.length==1){
			return new Node(array[0], null, null);
		}else if(array.length==2){
			Node left= new Node(array[0], null, null);
			Node center= new Node(array[1], left, null);
			return center;
		}else{
			//Find center value 
			int centerPos= (array.length/2);
			int[] leftArray= Arrays.copyOfRange(array, 0, centerPos); 
			int[] rightArray= Arrays.copyOfRange(array, centerPos+1, array.length); 
			Node center= new Node(array[centerPos], findCenterNode(leftArray), findCenterNode(rightArray));
			return center;
		}
	}
	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value, Node leftNode, Node rightNode){
			this.value=value;
			left=leftNode;
			right=rightNode;
		}
		public String toString(){
			StringBuilder result= new StringBuilder();
			result.append("Value: "+value+" ");
			if(left!=null)
				result.append("Left: "+left.toString()+" ");
			if(right!=null)
				result.append("Right: "+right.toString()+" ");
			return result.toString();
		}
	}
}
