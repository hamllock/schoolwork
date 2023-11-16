package ProjExer14;

import java.util.Random;

public class IntSkipList {
    private int maxLevel;
    private IntSkipListNode[] root;
    private int[] powers;
    private Random rd = new Random();
    public int nodesChecked;

    IntSkipList() {
        this(4);
    }

    IntSkipList(int i) {
        maxLevel = i;
        root = new IntSkipListNode[maxLevel];
        powers = new int[maxLevel];
        for (int j = 0; j < maxLevel; j++)
            root[j] = null;
        choosePowers();
    }

    public boolean isEmpty() {
        return root[0] == null;
    }

    public void choosePowers() {
        powers[maxLevel - 1] = (2 << (maxLevel - 1)) - 1; // 2^maxLevel - 1
        for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++)
            powers[i] = powers[i + 1] - (2 << j); // 2^(j+1)
    }

    public int chooseLevel() {
        int i, r = Math.abs(rd.nextInt()) % powers[maxLevel - 1] + 1;
        for (i = 1; i < maxLevel; i++)
            if (r < powers[i])
                return i - 1; // return a level < the highest level;
        return i - 1; // return the highest level;
    }

    // make sure (with isEmpty()) that skipListSearch() is called for a
    // nonempty list;
    public int skipListSearch(int key) {
        int lvl;
        nodesChecked = 0;
        IntSkipListNode prev, curr; // find the highest non-null
        for (lvl = maxLevel - 1; lvl >= 0 && root[lvl] == null; lvl--)
            ; // level;
        prev = curr = root[lvl];
        while (true) {
            nodesChecked++;
            if (key == curr.key) // success if equal;
                return curr.key;
            else if (key < curr.key) { // if smaller, go down,
                if (lvl == 0) // if possible,
                    return 0;
                else if (curr == root[lvl]) // by one level
                    curr = root[--lvl]; // starting from the
                else
                    curr = prev.next[--lvl]; // predecessor which
            } // can be the root;
            else { // if greater,
                prev = curr; // go to the next
                if (curr.next[lvl] != null) // non-null node
                    curr = curr.next[lvl]; // on the same level
                else { // or to a list on a lower level;
                    for (lvl--; lvl >= 0 && curr.next[lvl] == null; lvl--)
                        ;
                    if (lvl >= 0)
                        curr = curr.next[lvl];
                    else
                        return 0;
                }
            }
        }
    }

    public void skipListInsert(int key) {
        IntSkipListNode[] curr = new IntSkipListNode[maxLevel];
        IntSkipListNode[] prev = new IntSkipListNode[maxLevel];
        IntSkipListNode newNode;
        int lvl, i;
        curr[maxLevel - 1] = root[maxLevel - 1];
        prev[maxLevel - 1] = null;
        for (lvl = maxLevel - 1; lvl >= 0; lvl--) {
            while (curr[lvl] != null && curr[lvl].key < key) { // go to the next
                prev[lvl] = curr[lvl]; // if smaller;
                curr[lvl] = curr[lvl].next[lvl];
            }
            if (curr[lvl] != null && curr[lvl].key == key) // don't include
                return; // duplicates;
            if (lvl > 0) // go one level down
                if (prev[lvl] == null) { // if not the lowest
                    curr[lvl - 1] = root[lvl - 1]; // level, using a link
                    prev[lvl - 1] = null; // either from the root
                } else { // or from the predecessor;
                    curr[lvl - 1] = prev[lvl].next[lvl - 1];
                    prev[lvl - 1] = prev[lvl];
                }
        }
        lvl = chooseLevel(); // generate randomly level
        // for newNode;
        newNode = new IntSkipListNode(key, lvl + 1);
        for (i = 0; i <= lvl; i++) { // initialize next fields of
            newNode.next[i] = curr[i]; // newNode and reset to newNode
            if (prev[i] == null) // either fields of the root
                root[i] = newNode; // or next fields of newNode's
            else
                prev[i].next[i] = newNode; // predecessors;
        }
    }
}