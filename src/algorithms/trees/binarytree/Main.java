package algorithms.trees.binarytree;

public class Main
{

	public static void main(String[] args)
	{
			bstTest();
			System.out.println();
			testLowestCommonAncestor();
			System.out.println();
			leveOrderTraversalTest();
			
	}

	private static void leveOrderTraversalTest()
	{
		BinaryTree tree = createBST();
		tree.levelOrderTraversal(tree.getRoot());
		
	}

	private static void testLowestCommonAncestor()
	{
		BinaryTree tree = createBST();
		LowestCommonAncestor lca = new LowestCommonAncestor();
		System.out.println(lca.lowestCommonAnsestor(tree.getRoot(), new Node<Integer>(15), new Node<Integer>(4)));
		
	}

	private static void bstTest()
	{
		BinaryTree tree = createBST();
		
//			tree.displayTree(tree.root, 5);
		
		tree.inorderTraversal(tree.getRoot());
//			System.out.println();
//			tree.preOrderTraversal(tree.root);
//			System.out.println();
//			tree.postOrderTraversal(tree.root);
		System.out.println();
		
		
		tree.deleteNode(tree.getRoot(), 10);
		tree.inorderTraversal(tree.getRoot());
		
//			System.out.println(tree.root);
	}
	
	
	private static BinaryTree createBST()
	{
		BinaryTree tree = new BinaryTree();
		
		tree.insertdata(5);
		tree.insertdata(3);
		tree.insertdata(10);
		tree.insertdata(8);
		tree.insertdata(7);
		tree.insertdata(9);
		tree.insertdata(6);
		tree.insertdata(12);
		tree.insertdata(2);
		tree.insertdata(4);
		tree.insertdata(15);
		tree.insertdata(11);
		return tree;
	}
}
