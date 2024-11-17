class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        wordList.add(beginWord);
        HashMap<String, List<String>> ps = new HashMap<>();
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }

        for(String word: wordList){
            for(int j = 0; j<word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                ps.computeIfAbsent(pattern, k->new ArrayList<>()).add(word);
            }
        }

            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            visited.add(beginWord);
            int res = 1;
            while(!q.isEmpty()){
                int s = q.size();
                for(int i = 0; i<s; i++){
                    String curr = q.poll();
                    if(curr.equals(endWord)){
                        return res;
                    }
                    for(int j = 0; j<curr.length(); j++){
                        String pat = curr.substring(0, j) + "*" + curr.substring(j+1);
                        for(String reachable: ps.getOrDefault(pat, Collections.emptyList())){
                            if(!visited.contains(reachable)){
                                visited.add(reachable);
                                q.offer(reachable);
                            }
                        }
                    }
                }
                res++;
            }
             return 0;
        }
    }

