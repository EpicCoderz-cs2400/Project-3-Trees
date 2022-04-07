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

    //Unit Cases of trees up to height < 3 (simple cases):
    //Empty Tree
    //Tree with no children
    //Tree with only left child
    //Tree with only right child
    //Tree with both left and right children

    //Unit Cases of trees of height >= 3 (complex cases all built off of complete binary tree of height = 2):
    //Left Subtree: only left child                   Right Subtree: no children
    //Left Subtree: only right child                  Right Subtree: no children
    //Left Subtree: both left and right children      Right Subtree: no children
    //Left Subtree: no children                       Right Subtree: only left child
    //Left Subtree: no children                       Right Subtree: only right child
    //Left Subtree: no children                       Right Subtree: both left and right children
    //Left Subtree: only left child                   Right Subtree: only left child
    //Left Subtree: only right child                  Right Subtree: only right child
    //Left Subtree: only left child                   Right Subtree: only right child
    //Left Subtree: only right child                  Right Subtree: only left child
    //Left Subtree: both left and right children      Right Subtree: only left child
    //Left Subtree: both left and right children      Right Subtree: only right child
    //Left Subtree: only left child                   Right Subtree: both left and right children
    //Left Subtree: only right child                  Right Subtree: both left and right children
    //Left Subtree: both left and right children      Right Subtree: both left and right children
}
