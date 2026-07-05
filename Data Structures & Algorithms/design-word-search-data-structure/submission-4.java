class WordDictionary {
    class Node {
        Node[] arr;
        boolean eow;
        Node() {
            arr = new Node[26];
            eow = false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        int len = word.length();
        Node tmp = root;
        for (int i = 0; i < len; i++) {
            if (tmp.arr[word.charAt(i) - 'a'] == null) {
                tmp.arr[word.charAt(i) - 'a'] = new Node();
            }
            tmp = tmp.arr[word.charAt(i) - 'a'];
        }
        tmp.eow = true;
    }

    public boolean dotSearch(int idx, String word, Node root) {
        boolean found = false;
        Node tmp = root;
        int len = word.length();
        for (int i = idx; i < len; i++) {
            if (word.charAt(i) == '.') {
                for (int k = 0; k < 26; k++) {
                    if (tmp.arr[k] != null)
                        found = found || dotSearch(i + 1, word, tmp.arr[k]);
                    if(found)
                        break;
                }
                return found;
            } else {
                if (tmp.arr[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                tmp = tmp.arr[word.charAt(i) - 'a'];
            }
        }
        return tmp.eow || found;
    }

    public boolean search(String word) {
        return dotSearch(0, word, root);
    }
}
