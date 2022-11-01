package arabian;

import java.util.TreeMap;

class Converter {
    TreeMap<String, Integer> romanKeyMap = new TreeMap<>();
// [1,10] in Roman
    public Converter() {
        romanKeyMap.put("I", 1);
        romanKeyMap.put("II", 2);
        romanKeyMap.put("III", 3);
        romanKeyMap.put("IV", 4);
        romanKeyMap.put("V", 5);
        romanKeyMap.put("VI", 6);
        romanKeyMap.put("VII", 7);
        romanKeyMap.put("VIII", 8);
        romanKeyMap.put("IX", 9);
        romanKeyMap.put("X", 10);
    }
    public Integer RomanDigit(String num) {
        return romanKeyMap.get(num);
    } // (num.charAt(0)

    public boolean isRoman(String number){
        return romanKeyMap.containsKey(number);//"I"->'I'
    }

}

