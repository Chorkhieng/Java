import java.util.Map;
import java.util.TreeMap;

public class Utilities {

    // Your code goes here
    public static Map<String, Integer> createReverseIndex(StateData[] StateData){
        Map<String, Integer> data = new TreeMap<>();
        for (int i = 0; i < StateData.length; i++){
            data.put(StateData[i].getName(), i);
        }
        return data;
    }

}
