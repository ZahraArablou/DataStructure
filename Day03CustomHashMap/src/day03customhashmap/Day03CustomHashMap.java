package day03customhashmap;

public class Day03CustomHashMap {

    public static void main(String[] args) {

        CustomHashMapStringString map = new CustomHashMapStringString();
        map.putValue("Jerry", "ff");
        map.putValue("Jerr", "ffl");
        map.putValue("Jerry", "ll");
        map.putValue("Jerry1", "dd");
        map.putValue("Bwery", "hh");
        map.putValue("Maru", "ffl");
        map.putValue("Lili", "ll");
        map.putValue("Bery", "hh");
        map.putValue("Maru", "ffl");
        map.putValue("Bery", "hh");
        map.putValue("Maru", "ffl");
        map.putValue("Lili", "ll");

        System.out.println(map.toString());
        System.out.println(map.hasKey("Bery") + " " + map.hasKey("jj"));
        //  System.out.println(map.deleteByKey("Bwery") + " " + map.deleteByKey("jj"));
        System.out.println(map.toString());
        map.printDebug();
        System.out.println("All Keys:" + String.join(",", map.getAllKeys()));
        System.out.println(map);
          map.putValue("Jery", "ff");
        map.putValue("Daiel", "ffl");
        map.putValue("Jery", "ll");
        map.putValue("Jo", "dd");
        map.putValue("Jhn", "hh");
        map.putValue("Mry", "ffl");
        map.putValue("Lli", "ll");
        map.putValue("Bry", "hh");
        map.putValue("Mry", "ffl");
        map.putValue("erry", "ff");
        map.putValue("aniel", "ffl");
        map.putValue("erry", "ll");
        map.putValue("oe", "dd");
        map.putValue("ohn", "hh");
        map.putValue("ary", "ffl");
        map.putValue("ili", "ll");
        map.putValue("ery", "hh");
        map.putValue("ary", "ffl");
        
        map.putValue("Ll", "ll");
        map.putValue("Br", "hh");
        map.putValue("Mr", "ffl");
        map.putValue("err", "ff");
        map.putValue("anil", "ffl");
     
        map.putValue("Li", "ll");
        map.putValue("By", "hh");
        map.putValue("My", "ffl");
        map.putValue("ery", "ff");
        map.putValue("aiel", "ffl");
       
        map.putValue("Lli", "ll");
        map.putValue("Bry", "hh");
        map.putValue("Mry", "ffl");
        map.putValue("erry", "ff");
        map.putValue("aniel", "ffl");
        
            map.printDebug();
    }

}
