package math;

import java.util.HashMap;

/**
 * @author tangkun
 * @date 2019-05-13
 */
public class Lesson12 {

    static  TreeNode NULL_NODE = new TreeNode('0', "", null);

    public static void main(String[] args) throws CloneNotSupportedException {


          String str = "geek";
          put(str, "", NULL_NODE);
            String str2 = "ageometry";
          put(str2, "", NULL_NODE);
        dfsByStack()
    }

    public static void put(String str, String pre, TreeNode parent){
        char[] c = str.toCharArray();

        if(parent.sons.containsKey(c[0])){
            parent = parent.sons.get(c[0]);
            if(c.length == 1){
                return;
            }

            str = str.substring(1);
            pre += c[0];
            put(str, pre, parent);
        }else{
            TreeNode son = new TreeNode(c[0], pre, "");
            parent.sons.put(c[0], son);
            if (c.length == 1){
                //已经结束
                return;
            }else {
                //新节点为当前的son节点，字符串匹配向后一步
                parent = son;
                str = str.substring(1);
                pre += c[0];
                put(str, pre, parent);
            }
        }
    }

    public static TreeNode dfsByStack(String str, TreeNode node){

        char[] c = str.toCharArray();


        if(node.getLabel() == c[0] && c.length == 0){
            return node;
        }

        if(node.getSons().containsKey(c[0])){
                node = node.sons.get(c[0]);
                str = str.substring(1);
                dfsByStack(str, node);
        }else {
            return null;
        }

        return null;
    }
}


class TreeNode{

    public char label;

    public HashMap<Character, TreeNode> sons = null;

    public String prefix = null;

    public String explanation = null;;

    public TreeNode(char l, String pre, String exp){
        label = l;
        prefix = pre;
        explanation = exp;
        sons = new HashMap<>();
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public HashMap<Character, TreeNode> getSons() {
        return sons;
    }

    public void setSons(HashMap<Character, TreeNode> sons) {
        this.sons = sons;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        TreeNode clone = (TreeNode)super.clone();
        clone.setExplanation(this.explanation);
        clone.setLabel(this.label);
        clone.setPrefix(this.prefix);
        clone.setSons(this.sons);

        return clone;
    }
}
