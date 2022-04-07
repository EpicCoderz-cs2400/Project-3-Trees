/*
    Class for Junit testing. Still needs to import JUnit packages to work.
*/
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class UnitTesting {

    //Case 0) bad input
    //Unit Cases of trees up to height < 3 (simple cases):
    //Case 1) Empty Tree
    //Case 2) Tree with no children
    //Case 3) Tree with only left child
    //Case 4) Tree with only right child
    //Case 5) Tree with both left and right children

    //Unit Cases of trees of height >= 3 (complex cases all built off of complete binary tree of height = 2):
    //Case 6) Left Subtree: only left child  
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


    //Creating trees for testing
    BinaryTree<String> noTree = new BinaryTree<>();
    BinaryTree<String> bTree = new BinaryTree<>("B");
    BinaryTree<String> cTree = new BinaryTree<>("C");
    BinaryTree<String> dTree = new BinaryTree<>("D");
    BinaryTree<String> eTree = new BinaryTree<>("E");
    BinaryTree<String> fTree = new BinaryTree<>("F");
    BinaryTree<String> gTree = new BinaryTree<>("G");

    BinaryTree<String> treeCase1 = noTree;
    BinaryTree<String> treeCase2 = new BinaryTree<>("A");
    BinaryTree<String> treeCase3 = new BinaryTree<>("A",bTree, null);
    BinaryTree<String> treeCase4 = new BinaryTree<>("A",null, cTree);
    BinaryTree<String> treeCase5 = new BinaryTree<>("A", bTree, cTree);

    BinaryTree<String> treeCase6 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, null), cTree);
    BinaryTree<String> treeCase7 = new BinaryTree<>("A", new BinaryTree<>("B", null, eTree), cTree);
    BinaryTree<String> treeCase8 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, eTree), cTree);
    BinaryTree<String> treeCase9 = new BinaryTree<>("A", bTree, new BinaryTree<>("C", fTree, null));
    BinaryTree<String> treeCase10 = new BinaryTree<>("A", bTree, new BinaryTree<>("C", null, gTree));
    BinaryTree<String> treeCase11 = new BinaryTree<>("A",  bTree, new BinaryTree<>("C", fTree, gTree));
    BinaryTree<String> treeCase12 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, null), new BinaryTree<>("C", fTree, null));
    BinaryTree<String> treeCase13 = new BinaryTree<>("A", new BinaryTree<>("B", null, eTree), new BinaryTree<>("C", null, gTree));
    BinaryTree<String> treeCase14 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, null), new BinaryTree<>("C", null, gTree));
    BinaryTree<String> treeCase15 = new BinaryTree<>("A", new BinaryTree<>("B", null, eTree), new BinaryTree<>("C", fTree, null));
    BinaryTree<String> treeCase16 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, eTree), new BinaryTree<>("C", fTree, null));
    BinaryTree<String> treeCase17 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, eTree), new BinaryTree<>("C", null, gTree));
    BinaryTree<String> treeCase18 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, null), new BinaryTree<>("C", fTree, gTree));
    BinaryTree<String> treeCase19 = new BinaryTree<>("A", new BinaryTree<>("B", null, eTree), new BinaryTree<>("C", fTree, gTree));
    BinaryTree<String> treeCase20 = new BinaryTree<>("A", new BinaryTree<>("B", dTree, eTree), new BinaryTree<>("C", fTree, gTree));


    //Taverse tests
    @Test
    public void testTaverseCase1() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase1.postorderTraverse();

        assertEquals("", catcherStream.toString());
    }

    @Test
    public void testTaverseCase2() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase2.postorderTraverse();

        assertEquals("A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase3() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase3.postorderTraverse();

        assertEquals("B A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase4() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase4.postorderTraverse();

        assertEquals("C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase5() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase5.postorderTraverse();

        assertEquals("B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase6(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase6.postorderTraverse();

        assertEquals("D B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase7(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase7.postorderTraverse();

        assertEquals("E B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase8(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase8.postorderTraverse();

        assertEquals("D E B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase9(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase9.postorderTraverse();

        assertEquals("B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase10(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase10.postorderTraverse();

        assertEquals("B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase11(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase11.postorderTraverse();

        assertEquals("B F G C A", catcherStream.toString());
    }

    @Test
    public void testTaverseCase12(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase12.postorderTraverse();

        assertEquals("D B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase13(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase13.postorderTraverse();

        assertEquals("E B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase14(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase14.postorderTraverse();

        assertEquals("D B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase15(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase15.postorderTraverse();

        assertEquals("E B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase16(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase16.postorderTraverse();

        assertEquals("D E B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase17(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase17.postorderTraverse();

        assertEquals("D E B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase18(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase18.postorderTraverse();

        assertEquals("D B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase19(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase19.postorderTraverse();

        assertEquals("E B F G C A", catcherStream.toString());
    }

    @Test
    public void testTaverseCase20(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase20.postorderTraverse();

        assertEquals("D E B F G C A ", catcherStream.toString());
    }

}
