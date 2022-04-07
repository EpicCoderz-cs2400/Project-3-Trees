/*
    Class for Junit testing. Still needs to import JUnit packages to work.
*/
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

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


    //Unit Cases of trees up to height < 3 (simple cases):
    //Case 1) Empty Tree
    @Test
    public void testTreeCase1Traverse() {
        //Create tree
        BinaryTree<String> emptyTree = new BinaryTree<>();

        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        emptyTree.postorderTraverse();

        assertEquals("", catcherStream.toString());
    }

    //Case 2) Tree with no children
    @Test
    public void testTreeCase2Traverse() {
        //create tree
        BinaryTree<String> treeCase2 = new BinaryTree<>("A");

        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase2.postorderTraverse();

        assertEquals("A ", catcherStream.toString());
    }

    //Case 3) Tree with only left child
    @Test
    public void testTreeCase3Traverse() {
        //create leaf
        BinaryTree<String>  bTree = new BinaryTree<>("B");

        //create tree
        BinaryTree<String> treeCase3 = new BinaryTree<>("A", bTree, null);

        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase3.postorderTraverse();

        assertEquals("B A ", catcherStream.toString());
    }

    //Case 4) Tree with only right child
    @Test
    public void testTreeCase4Traverse() {
        //create leaf
        BinaryTree<String>  cTree = new BinaryTree<>("C");

        //create tree
        BinaryTree<String> treeCase4 = new BinaryTree<>("A", null, cTree);

        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase4.postorderTraverse();

        assertEquals("C A ", catcherStream.toString());
    }

    //Case 5) Tree with both left and right children
    @Test
    public void testTreeCase5Traverse() {
        //create leaf
        BinaryTree<String>  bTree = new BinaryTree<>("B");
        BinaryTree<String>  cTree = new BinaryTree<>("C");

        //create tree
        BinaryTree<String> treeCase5 = new BinaryTree<>("A", bTree, cTree);

        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase5.postorderTraverse();

        assertEquals("B C A ", catcherStream.toString());
    }


    //Unit Cases of trees of height >= 3 (complex cases all built off of complete binary tree of height = 2):
    //Case 6) Left Subtree: only left child                   Right Subtree: no children
    //Case 7) Left Subtree: only right child                  Right Subtree: no children
    //Case 8) Left Subtree: both left and right children      Right Subtree: no children
    //Case 9) Left Subtree: no children                       Right Subtree: only left child
    //Case 10) Left Subtree: no children                       Right Subtree: only right child
    //Case 11) Left Subtree: no children                       Right Subtree: both left and right children
    //Case 12) Left Subtree: only left child                   Right Subtree: only left child
    //Case 13) Left Subtree: only right child                  Right Subtree: only right child
    //Case 14) Left Subtree: only left child                   Right Subtree: only right child
    //Case 15) Left Subtree: only right child                  Right Subtree: only left child
    //Case 16) Left Subtree: both left and right children      Right Subtree: only left child
    //Case 17) Left Subtree: both left and right children      Right Subtree: only right child
    //Case 18) Left Subtree: only left child                   Right Subtree: both left and right children
    //Case 19) Left Subtree: only right child                  Right Subtree: both left and right children
    //Case 20) Left Subtree: both left and right children      Right Subtree: both left and right children
}
