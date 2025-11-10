import java.util.Arrays;

public class NumMaxSwap {
    public static void main(String[] args){
        String s = "12399";
        char[] ch =s.toCharArray();
        StringBuilder result = new StringBuilder("");
        char max1 = ch[0];
        char max2 = ch[0];
        int maxIndex=0;
        int maxIndex2=0;
        for (int i = 0; i < ch.length; i++) {
                if(ch[i]>max1){
                    max1=ch[i];
                    maxIndex=i;
                }
        }
        ch[maxIndex]=ch[0];
        ch[0]=max1;
        for (int i = 1; i < ch.length; i++) {
                if(ch[i]>max2&&ch[i]<=max1 ){
                    max2=ch[i];
                    maxIndex2=i;
                }
        }

        ch[maxIndex2]=ch[1];
        ch[1]=max2;



        System.out.println(Arrays.toString(ch));
        for (int i = 0; i < ch.length; i++) {
            result.append(ch[i]);
        }
        System.out.println("result = " + result);

    }
}
