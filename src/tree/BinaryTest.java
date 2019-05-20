package tree;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangkun
 * @date 2018-12-02
 */
public class BinaryTest extends TestCase{

    public int[] arr = {28,16,30,13,22,29,43};

    TreeNode headNode;

    List<TreeNode> nodes;


    @Override
    public void setUp(){
        nodes = new ArrayList<>();
        headNode = TreeNode.buildTree(arr);
    }

    @Test
    public void testPreOrderTraversal(){
        nodes.clear();
        TreeNode.preOrderTraversal(headNode,nodes);
        System.out.println("=============前序遍历=============");
        nodes.forEach(item-> System.out.println(item.getValue()));

    }

    @Test
    public void testInOrderTraversal(){
        nodes.clear();
        TreeNode.inOrderTraversal(headNode,nodes);
        System.out.println("=============中序遍历=============");
        nodes.forEach(item-> System.out.println(item.getValue()));
    }

    @Test
    public void testPostOrderTraversal(){
        nodes.clear();
        TreeNode.postOrderTraversal(headNode,nodes);
        System.out.println("=============后序遍历=============");
        nodes.forEach(item-> System.out.println(item.getValue()));

        headNode.updateHash(headNode);
    }

    @Test
    public void testGetRootHash(){

        headNode.updateHash(headNode);
        List<TreeNode> proofNodes = new ArrayList<>();
        TreeNode treeNode = headNode.find(29, proofNodes);
        proofNodes.forEach(item ->{
            System.out.println(item.value);
        });

        System.out.println(verifyProof(headNode.getHash(), treeNode, proofNodes));
    }

    public boolean verifyProof(String rootHash, TreeNode node, List<TreeNode> proofNodes){

        int size = proofNodes.size() - 1;
        boolean verifyFlag = false;
        TreeNode treeNode = proofNodes.get(size);
        while (!verifyFlag){

            if(node.getHash().equals( treeNode.getLeftHash() ) || node.getHash().equals( treeNode.getLeftHash() )){
                treeNode = proofNodes.get(--size);
                if(treeNode.getHash().equals(rootHash) && size == 0){
                    verifyFlag = true;
                }
            }else {
               break;
            }

        }

        return verifyFlag;
    }
}

