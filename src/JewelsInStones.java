import org.junit.Test;

/**
 * @author tangkun
 * @date 2018-11-26
 */
public class JewelsInStones {

    @Test
    public void testNumJewelsInStones(){
        String J = "z";
        String S = "ZZ";
        System.out.println(numJewelsInStones(J,S));
    }

    public int numJewelsInStones(String J,String S){

        int num =0;
        for (int i = 0; i < S.length(); i++) {
            if(J.indexOf(S.charAt(i)) != -1){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String S = "Z";
        System.out.println("zZ".indexOf(S.charAt(0)));
    }
}
