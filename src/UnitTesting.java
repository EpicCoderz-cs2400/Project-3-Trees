/*
    Class for Junit testing. Still needs to import JUnit packages to work.
*/

public class UnitTesting {
    
    public static void main(String[] args)
	{
		System.out.println("1st Testing Example:");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
        System.out.println("(binaryTree) post-order: ");
		aTree.postorderTraverse();
		System.out.println("");
    }
    
    //Testing a tree with only left subtree
    public static void createTree1(BinaryTree<String> tree)
	{ 
        // Leaves
		BinaryTree<String> eTree = new BinaryTree<>("E");

		// Subtrees:
		BinaryTree<String> dTree = new BinaryTree<>("D", eTree, null);
		BinaryTree<String> cTree = new BinaryTree<>("C", dTree, null);
		BinaryTree<String> bTree = new BinaryTree<>("B", null, cTree);

		tree.setTree("A", bTree, null);
		
        System.out.println("\nGiven Tree:\n");
        System.out.println("     A      ");
        System.out.println("   /     ");
        System.out.println("  B       ");
        System.out.println("   \\     ");
        System.out.println("    C     ");
        System.out.println("   /      ");
        System.out.println("   D        ");
        System.out.println("  /        ");
        System.out.println(" E        ");
        System.out.println();
	} // end createTree

    //@Test

    
}
