package com.gkonovalov.datastructures.etc;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * Base block for HashMap construction.
 * </p>
 */
public class MapNode<Key, Value> {

    public Key key;
    public Value val;

    public MapNode<Key, Value> next;

    public MapNode(Key key, Value val, MapNode<Key, Value> node) {
        this.key = key;
        this.val = val;
        this.next = node;
    }
}
