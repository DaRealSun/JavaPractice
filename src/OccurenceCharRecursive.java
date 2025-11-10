public class OccurenceCharRecursive {
    public static void main(String[] args) {

        System.out.println(count("NarrowSoloBolo", 'r'));


    }

    public static int count(String s, char a) {
        return count(s, a, 0);
    }
    static int count;
    public static int count(String s, char a, int index) {

        if (index==s.length()){
            return count;
        }

        if (s.charAt(index) == a) {
            count++;
            count(s,a,index+1);

        } else {
            count(s,a,index+1);
        }
        return count;
    }
}
