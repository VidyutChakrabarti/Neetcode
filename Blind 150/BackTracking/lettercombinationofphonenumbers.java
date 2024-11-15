class Solution {
    HashMap<Character, ArrayList<Character>>m = new HashMap<>();

    void harness(List<String> ans, StringBuilder curr, String digits, int i){
        if(curr.length() >= digits.length()){
            StringBuilder s = new StringBuilder(curr);
            String rs = s.toString();
            ans.add(rs);
            return;
        }
        char c = digits.charAt(i);
        ArrayList<Character> tbp = m.get(c);
        for(int l = 0; l<tbp.size(); l++){
            curr.append(tbp.get(l));
            harness(ans, curr, digits, i+1);
            System.out.println(i + " "+ curr + " " + l);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
    m.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
    m.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
    m.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
    m.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
    m.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
    m.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
    m.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
    m.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){return ans;}
        StringBuilder h = new StringBuilder(""); 
        harness(ans, h, digits, 0);
        return ans;
    }
}
