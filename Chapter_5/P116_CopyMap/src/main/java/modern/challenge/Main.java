package modern.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Anna");
        map.put(2, "George");
        
        Map<Integer, String> shallowMap1 = Maps.shallowCopyV1(map);        
        System.out.println("Shallow copy 1: " + shallowMap1);
        
        Map<Integer, String> shallowMap2 = Maps.shallowCopyV2(map);        
        System.out.println("Shallow copy 2: " + shallowMap2);
        
        List<A> lista = Arrays.asList(new A(1), new A(2));
        List<B> listb = Arrays.asList(new B(new A(3), 1), new B(new A(4), 2));
        Map<List<A>, List<B>> mapab = new HashMap<>();
        mapab.put(lista, listb);
        
        Map<List<A>, List<B>> deepMap = Maps.deepCopy(mapab);        
        System.out.println("Deep copy: \n" + mapab + " \n" + deepMap);
    }
    
}
