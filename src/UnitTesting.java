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
    //Case 21) Left Subtree: both left and right children      Right Subtree: both left and right children
    //Case 22) Left Subtree: both left and right children      Right Subtree: both left and right children
    //Case 23) Left Subtree: both left and right children      Right Subtree: both left and right children
    //Case 24) Left Subtree: both left and right children      Right Subtree: both left and right children


    //Creating trees for testing
    BinaryTree<String> treeCase1 = new BinaryTree<>();
    BinaryTree<String> treeCase2 = new BinaryTree<>("A");
    BinaryTree<String> treeCase3 = new BinaryTree<>("A",new BinaryTree<>("B"), null);
    BinaryTree<String> treeCase4 = new BinaryTree<>("A",null, new BinaryTree<>("C"));
    BinaryTree<String> treeCase5 = new BinaryTree<>("A", new BinaryTree<>("B"), new BinaryTree<>("C"));

    BinaryTree<String> treeCase6 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), null), new BinaryTree<>("C"));
    BinaryTree<String> treeCase7 = new BinaryTree<>("A", new BinaryTree<>("B", null, new BinaryTree<>("E")), new BinaryTree<>("C"));
    BinaryTree<String> treeCase8 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), new BinaryTree<>("E")), new BinaryTree<>("C"));
    BinaryTree<String> treeCase9 = new BinaryTree<>("A", new BinaryTree<>("B"), new BinaryTree<>("C", new BinaryTree<>("F"), null));
    BinaryTree<String> treeCase10 = new BinaryTree<>("A", new BinaryTree<>("B"), new BinaryTree<>("C", null, new BinaryTree<>("G")));
    BinaryTree<String> treeCase11 = new BinaryTree<>("A",  new BinaryTree<>("B"), new BinaryTree<>("C", new BinaryTree<>("F"), new BinaryTree<>("G")));
    BinaryTree<String> treeCase12 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), null), new BinaryTree<>("C", new BinaryTree<>("F"), null));
    BinaryTree<String> treeCase13 = new BinaryTree<>("A", new BinaryTree<>("B", null, new BinaryTree<>("E")), new BinaryTree<>("C", null, new BinaryTree<>("G")));
    BinaryTree<String> treeCase14 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), null), new BinaryTree<>("C", null, new BinaryTree<>("G")));
    BinaryTree<String> treeCase15 = new BinaryTree<>("A", new BinaryTree<>("B", null, new BinaryTree<>("E")), new BinaryTree<>("C", new BinaryTree<>("F"), null));
    BinaryTree<String> treeCase16 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), new BinaryTree<>("E")), new BinaryTree<>("C", new BinaryTree<>("F"), null));
    BinaryTree<String> treeCase17 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), new BinaryTree<>("E")), new BinaryTree<>("C", null, new BinaryTree<>("G")));
    BinaryTree<String> treeCase18 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), null), new BinaryTree<>("C", new BinaryTree<>("F"), new BinaryTree<>("G")));
    BinaryTree<String> treeCase19 = new BinaryTree<>("A", new BinaryTree<>("B", null, new BinaryTree<>("E")), new BinaryTree<>("C", new BinaryTree<>("F"), new BinaryTree<>("G")));
    BinaryTree<String> treeCase20 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), new BinaryTree<>("E")), new BinaryTree<>("C", new BinaryTree<>("F"), new BinaryTree<>("G")));
    BinaryTree<String> treeCase21 = new BinaryTree<>("A", new BinaryTree<>("B", new BinaryTree<>("D"), null), null);
    BinaryTree<String> treeCase22 = new BinaryTree<>("A", new BinaryTree<>("B", null, new BinaryTree<>("E")), null);
    BinaryTree<String> treeCase23 = new BinaryTree<>("A", null, new BinaryTree<>("C", new BinaryTree<>("F"), null));
    BinaryTree<String> treeCase24 = new BinaryTree<>("A", null, new BinaryTree<>("C", null, new BinaryTree<>("G")));


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
        treeCase5.postorderTraverse();
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

        assertEquals("B F G C A ", catcherStream.toString());
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

        assertEquals("E B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase20(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase20.postorderTraverse();

        assertEquals("D E B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase21(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase21.postorderTraverse();

        assertEquals("D B A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase22(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase22.postorderTraverse();

        assertEquals("E B A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase23(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase23.postorderTraverse();

        assertEquals("F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseCase24(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase24.postorderTraverse();

        assertEquals("G C A ", catcherStream.toString());
    }




    //Traverse Binary tests
    @Test
    public void testTaverseBinaryCase1() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase1.postorderTraverse_callBinaryNodeMethod();

        assertEquals("", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase2() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase2.postorderTraverse_callBinaryNodeMethod();

        assertEquals("A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase3() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase3.postorderTraverse_callBinaryNodeMethod();

        assertEquals("B A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase4() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase4.postorderTraverse_callBinaryNodeMethod();

        assertEquals("C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase5() {
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase5.postorderTraverse_callBinaryNodeMethod();

        assertEquals("B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase6(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase6.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase7(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase7.postorderTraverse_callBinaryNodeMethod();

        assertEquals("E B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase8(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase8.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D E B C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase9(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase9.postorderTraverse_callBinaryNodeMethod();

        assertEquals("B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase10(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase10.postorderTraverse_callBinaryNodeMethod();

        assertEquals("B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase11(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase11.postorderTraverse_callBinaryNodeMethod();

        assertEquals("B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase12(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase12.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase13(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase13.postorderTraverse_callBinaryNodeMethod();

        assertEquals("E B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase14(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase14.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase15(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase15.postorderTraverse_callBinaryNodeMethod();

        assertEquals("E B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase16(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase16.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D E B F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase17(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase17.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D E B G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase18(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase18.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase19(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase19.postorderTraverse_callBinaryNodeMethod();

        assertEquals("E B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase20(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase20.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D E B F G C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase21(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase21.postorderTraverse_callBinaryNodeMethod();

        assertEquals("D B A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase22(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase22.postorderTraverse_callBinaryNodeMethod();

        assertEquals("E B A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase23(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase23.postorderTraverse_callBinaryNodeMethod();

        assertEquals("F C A ", catcherStream.toString());
    }

    @Test
    public void testTaverseBinaryCase24(){
        //Create printstream to catch output
        ByteArrayOutputStream catcherStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(catcherStream));

        treeCase24.postorderTraverse_callBinaryNodeMethod();

        assertEquals("G C A ", catcherStream.toString());
    }





    //Height Tests
    @Test
    public void testHeightCase1(){
        assertEquals(0, treeCase1.getHeight());
    }

    @Test
    public void testHeightCase2(){
        assertEquals(1, treeCase2.getHeight());
    }

    @Test
    public void testHeightCase3(){
        assertEquals(2, treeCase3.getHeight());
    }

    @Test
    public void testHeightCase4(){
        assertEquals(2, treeCase4.getHeight());
    }

    @Test
    public void testHeightCase5(){
        assertEquals(2, treeCase5.getHeight());
    }

    @Test
    public void testHeightCase6(){
        assertEquals(3, treeCase6.getHeight());
    }

    @Test
    public void testHeightCase7(){
        assertEquals(3, treeCase7.getHeight());
    }

    @Test
    public void testHeightCase8(){
        assertEquals(3, treeCase8.getHeight());
    }

    @Test
    public void testHeightCase9(){
        assertEquals(3, treeCase9.getHeight());
    }

    @Test
    public void testHeightCase10(){
        assertEquals(3, treeCase10.getHeight());
    }

    @Test
    public void testHeightCase11(){
        assertEquals(3, treeCase11.getHeight());
    }

    @Test
    public void testHeightCase12(){
        assertEquals(3, treeCase12.getHeight());
    }

    @Test
    public void testHeightCase13(){
        assertEquals(3, treeCase13.getHeight());
    }

    @Test
    public void testHeightCase14(){
        assertEquals(3, treeCase14.getHeight());
    }

    @Test
    public void testHeightCase15(){
        assertEquals(3, treeCase15.getHeight());
    }

    @Test
    public void testHeightCase16(){
        assertEquals(3, treeCase16.getHeight());
    }

    @Test
    public void testHeightCase17(){
        assertEquals(3, treeCase17.getHeight());
    }

    @Test
    public void testHeightCase18(){
        assertEquals(3, treeCase18.getHeight());
    }

    @Test
    public void testHeightCase19(){
        assertEquals(3, treeCase19.getHeight());
    }

    @Test
    public void testHeightCase20(){
        assertEquals(3, treeCase20.getHeight());
    }
    
    @Test
    public void testHeightCase21(){
        assertEquals(3, treeCase21.getHeight());
    }
    
    @Test
    public void testHeightCase22(){
        assertEquals(3, treeCase22.getHeight());
    }
    
    @Test
    public void testHeightCase23(){
        assertEquals(3, treeCase23.getHeight());
    }
    
    @Test
    public void testHeightCase24(){
        assertEquals(3, treeCase24.getHeight());
    }
    


    
    //Number of Node Tests
    @Test
    public void testNodeCase1(){
        assertEquals(0, treeCase1.getNumberOfNodes());
    }

    @Test
    public void testNodeCase2(){
        assertEquals(1, treeCase2.getNumberOfNodes());
    }

    @Test
    public void testNodeCase3(){
        assertEquals(2, treeCase3.getNumberOfNodes());
    }

    @Test
    public void testNodeCase4(){
        assertEquals(2, treeCase4.getNumberOfNodes());
    }

    @Test
    public void testNodeCase5(){
        assertEquals(3, treeCase5.getNumberOfNodes());
    }

    @Test
    public void testNodeCase6(){
        assertEquals(4, treeCase6.getNumberOfNodes());
    }

    @Test
    public void testNodeCase7(){
        assertEquals(4, treeCase7.getNumberOfNodes());
    }

    @Test
    public void testNodeCase8(){
        assertEquals(5, treeCase8.getNumberOfNodes());
    }

    @Test
    public void testNodeCase9(){
        assertEquals(4, treeCase9.getNumberOfNodes());
    }

    @Test
    public void testNodeCase10(){
        assertEquals(4, treeCase10.getNumberOfNodes());
    }

    @Test
    public void testNodeCase11(){
        assertEquals(5, treeCase11.getNumberOfNodes());
    }

    @Test
    public void testNodeCase12(){
        assertEquals(5, treeCase12.getNumberOfNodes());
    }

    @Test
    public void testNodeCase13(){
        assertEquals(5, treeCase13.getNumberOfNodes());
    }

    @Test
    public void testNodeCase14(){
        assertEquals(5, treeCase14.getNumberOfNodes());
    }

    @Test
    public void testNodeCase15(){
        assertEquals(5, treeCase15.getNumberOfNodes());
    }

    @Test
    public void testNodeCase16(){
        assertEquals(6, treeCase16.getNumberOfNodes());
    }

    @Test
    public void testNodeCase17(){
        assertEquals(6, treeCase17.getNumberOfNodes());
    }

    @Test
    public void testNodeCase18(){
        assertEquals(6, treeCase18.getNumberOfNodes());
    }

    @Test
    public void testNodeCase19(){
        assertEquals(6, treeCase19.getNumberOfNodes());
    }

    @Test
    public void testNodeCase21(){
        assertEquals(3, treeCase21.getNumberOfNodes());
    }

    @Test
    public void testNodeCase22(){
        assertEquals(3, treeCase22.getNumberOfNodes());
    }

    @Test
    public void testNodeCase23(){
        assertEquals(3, treeCase23.getNumberOfNodes());
    }

    @Test
    public void testNodeCase24(){
        assertEquals(3, treeCase24.getNumberOfNodes());
    }

    @Test
    public void testNodeCase20(){
        assertEquals(7, treeCase20.getNumberOfNodes());
    }

}
