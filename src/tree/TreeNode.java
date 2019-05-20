package tree;

import sort.MergeSort;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Objects;

/**
 * @author tangkun
 * @date 2018-12-04
 */
public class TreeNode {

    public static  TreeNode head ;
    Integer value;
    TreeNode left;
    TreeNode right;
    private String hash;
    private String leftHash;
    private String rightHash;
    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getHash() {
       return hash;
    }

    private String calculateHash(){
        String hash = "value=%s&leftHash=%s&rightHash=%s";
        hash = String.format(hash, Objects.toString(value, ""), Objects.toString(getLeftHash(), ""),
                Objects.toString(getRightHash(), ""));
        System.out.println("hash:"+hash);
        hash = getMD5(hash);
        System.out.println(String.format("value: %s hash:%s", value, hash));
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLeftHash() {
        if(Objects.isNull(hash) && Objects.nonNull(getLeft())){
            this.leftHash = getLeft().hash;
        }
        return leftHash;
    }

    public void setLeftHash(String leftHash) {
        this.leftHash = leftHash;
    }

    public String getRightHash() {
        if(Objects.isNull(hash) && Objects.nonNull(getRight())){
            this.rightHash = getRight().hash;
        }
        return rightHash;
    }

    public void setRightHash(String rightHash) {
        this.rightHash = rightHash;
    }

    public static TreeNode  setHead(Integer value){
        head = new TreeNode(value,null,null);
        return head;
    }

    /**
     * 按指定的数组构造二叉树
     *
     * @param intArr 指定的数组，数组第一个元素为head节点
     * @return 返回head节点
     */
    public static TreeNode buildTree(int[] intArr){

        TreeNode treeNode = setHead(intArr[0]);
        for (int i = 1; i < intArr.length; i++) {
            treeNode = treeNode.insert(intArr[i]);
        }

        return head;
    }

    private  String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密出现错误");
        }

    }

    /**
     * 添加一个指定元素到二叉树中，如果插入的元素值在书中不存在.
     * 1：如<tt>head<tt/>节点为空，则设置当前插入的节点为head节点，并将head节点返回；否则将head节点设置为当前<tt>currentNode<tt/>节点.
     * 2：插入元素小于<tt>currentNode<tt/>元素值，如果当前<tt>left<tt/>节点为空则设置插入节点为<tt>left<tt/>节点并返回<tt>left<tt/>节点.
     * 3: 插入元素小于<tt>currentNode<tt/>元素值，如果当前<tt>right<tt/>节点为空则设置插入节点为<tt>right<tt/>节点并返回<tt>right<tt/>节点.
     * 4：<strong>如插入元素值等于树中任意节点值则返回当前节点为null<strong/>
     *
     * @param value 插入的新元素
     * @return 返回新插入元素生成的节点
     */
    public TreeNode insert(Integer value){

        TreeNode currentNode = null;
        if(head == null){
            head = new TreeNode(value, null, null);
            return head;
        }
        currentNode = head;

        while (currentNode != null){

            if(value < currentNode.value){
                //left is null
                if (currentNode.getLeft() == null){
                    currentNode.left = new TreeNode(value,null,null);
                    return currentNode.left;
                }

                currentNode = currentNode.left;

            }else if (value > currentNode.value){
                //right is null
                if (currentNode.getRight() == null){
                    currentNode.right = new TreeNode(value,null,null);
                    return currentNode.right;
                }

                currentNode = currentNode.right;

            }else if (value.equals(currentNode.value)){
                //insert value can't existed in BT
                return null;
            }

        }

        //insert value can't existed in BT
        return null;
    }

    public boolean delete(Integer value){

        TreeNode targetNode = null;
        TreeNode currentNode = head;
        TreeNode nodeParent = head;
        boolean direction = false;
        while (targetNode == null){
            //走左边
            if(value < currentNode.getValue()){
                nodeParent = currentNode;
                currentNode = currentNode.left;
                direction = false;
                //走右边
            }else if(value > currentNode.getValue()){
                nodeParent = currentNode;
                currentNode = currentNode.right;
                direction = true;
            }else {
                //找到删除节点
                targetNode = currentNode;
                //单左
                if(targetNode.getLeft() != null && targetNode.getRight() == null){
                    nodeParent.left = null;
                    return true;
                }

                //单右
                if(targetNode.getLeft() == null && targetNode.getRight() != null){
                    nodeParent.right = null;
                    return true;
                }

                //既有左也有右
                if (targetNode.getLeft() != null && targetNode.getRight() != null){
                    TreeNode flowerNode = findFlowerNode(currentNode);
                    flowerNode.setLeft(currentNode.getLeft());
                    flowerNode.setRight(currentNode.getRight());
                    if(direction){
                        nodeParent.setRight(flowerNode);
                    }else {
                        nodeParent.setLeft(flowerNode);
                    }
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 寻找左列最低节点
     * @param currentNode 删除当前节点
     * @return
     */
    public  TreeNode findFlowerNode(TreeNode currentNode){

        while (currentNode.getLeft() != null){
            currentNode = currentNode.getLeft();
        }
        System.out.println("flower node "+currentNode.getValue());
        return  currentNode;
    }

    public TreeNode find(Integer value, List<TreeNode> recodeList){

        TreeNode current = head;
        while (current != null){
            if(current.getValue().equals(value)){
                //recodeList.add(current);
                return current;
            }
            recodeList.add(current);
            //左边
            if(value < current.getValue()){
                current = current.getLeft();
            }

            //右边
            if(value > current.getValue()){
                current = current.getRight();
            }
        }
        return null;
    }


    /**
     * 前序遍历
     * @param root
     * @param nodes
     */
    public static void preOrderTraversal(TreeNode root, List<TreeNode> nodes){
        System.out.println("root value:"+root);
        if(root != null){
            nodes.add(root);
            preOrderTraversal(root.getLeft(),nodes);
            preOrderTraversal(root.getRight(),nodes);
        }
    }


    public  void updateHash(TreeNode root){

          if(root != null) {
              updateHash(root.getLeft());
              updateHash(root.getRight());
              root.setHash(root.calculateHash());
          }
    }

//    public static void getRootHash(TreeNode root){
//        updateHash(root)
//    }

    /**
     * 中序遍历
     * @param root
     * @param nodes
     */
    public static void inOrderTraversal(TreeNode root, List<TreeNode> nodes){

        if(root != null){
            inOrderTraversal(root.getLeft(),nodes);
            nodes.add(root);
            inOrderTraversal(root.getRight(),nodes);
        }
    }
    /**
     * 后序遍历
     * @param root
     * @param nodes
     */
    public static void postOrderTraversal(TreeNode root, List<TreeNode> nodes){

        if(root != null){
            postOrderTraversal(root.getLeft(),nodes);
            postOrderTraversal(root.getRight(),nodes);
            nodes.add(root);
        }
    }

    public static boolean validateBST(TreeNode root){

        System.out.println("node value:"+root);
        if(root == null ){
            return true;
        }
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        if (left != null && left.getValue() > root.getValue()){
            return false;
        }
        if (right != null && right.getValue() < root.getValue()){
            return false;
        }

        boolean leftFlag = true, rightFlag=true;
        if(!validateBST(left)){
            leftFlag =  false;
        }
        if(!validateBST(right)){
            rightFlag =  false;
        }

        return leftFlag && rightFlag;
    }

    public boolean isBSTHelper(TreeNode node, Integer lower_limit, Integer upper_limit) {
        System.out.println("node :"+node);
        if ((lower_limit != null) && (node.getValue() <= lower_limit)) {
            return false;
        }
        if ((upper_limit != null) && (upper_limit <= node.getValue())) {
            return false;
        }
        //左子节点一直不
        boolean left = node.left != null ? isBSTHelper(node.left, lower_limit, node.getValue()) : true;
        System.out.println("left search");
        if (left) {
            boolean right = node.right != null ? isBSTHelper(node.right, node.getValue(), upper_limit) : true;
            System.out.println("right search");
            return right;
        } else {
            return false;
        }
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
