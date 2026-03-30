import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Design methods to encode a list of strings into a single string,
// and decode that single string back into the original list.
//Example:
//
//Input: ["hello", "world"]
//Encode: turns it into one string somehow
//Decode: turns that one string back into ["hello", "world"]
public class EncodeAndDecodeStrings {
    static void main(String[] args) {
        String[] input = {"hi", "a#b", "test"};
//        String[] arr = new String[]{"A", "B"};
        String endcodedString = encode(input);
        System.out.println(endcodedString);
        List<String> decodedString = decode(endcodedString);
        System.out.println(decodedString);
    }
    static String encode(String[] list){
        StringBuilder s = new StringBuilder();
        for(String s1 : list){
            s.append(s1.length()).append("#").append(s1);
        }
        return s.toString();
    }

    //we can encode to be 2hi3a#b4test and decode them but
    //problem will happend when string is > 10
    //so we need # to fix this problem. keep reading number until we get #
    static List<String> decode(String string){
        List<String> result = new ArrayList<>();
        int i = 0;
        // find the # to get the length
        // read that many characters after #
        // add to result
        // move i forward
        while(i<string.length()){
            int mark = string.indexOf("#",i);
            int len = Integer.parseInt(string.substring(i,mark));
            int stringStart = mark+1;
            int stringEnd = mark+len+1;
            result.add(string.substring(stringStart,stringEnd));
            IO.print(len+" ");
            i= stringEnd;
        }
        IO.println("");

        return result;
    }
}
