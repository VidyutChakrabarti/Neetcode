//Topological Sort for Alien Dictionary

class Solution {
    HashMap<Character, Boolean> visited;
    HashMap<Character, HashSet<Character>> g;
    String ordering;

    public String foreignDictionary(String[] words) {
        g = new HashMap<>();
        
        for(String w: words){
            for(int i = 0;i<w.length(); i++){
                g.computeIfAbsent(w.charAt(i), q->new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean ea = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    g.get(c1).add(c2);
                    ea = true;
                    break;
                }
            }

            if (!ea && w1.length() > w2.length()) {
                return "";
            }
        }

        System.out.println(g);

        visited = new HashMap<>();
        ordering = "";
        for (char c : g.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder(ordering);
        sb.reverse();
        String an = sb.toString();
    return an;
    }

    private boolean dfs(char ch) {
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }

        visited.put(ch, true);
        for (char next : g.get(ch)) {
            if (dfs(next)) {
                return true;
            }
        }
        visited.put(ch, false);
        ordering+=ch;
        return false;
    }
}
