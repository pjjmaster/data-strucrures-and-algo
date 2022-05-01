package com.practice.google;

class Trie {
    
    private TrieNode root;
   
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if(node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;            
    }
}

class TrieNode{
    
    private TrieNode[] links;
    
    private final int R = 26;
    
    private boolean isEnd ;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    
    public TrieNode get(char c) {
        return links[c - 'a'];
    }
    
    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
}
