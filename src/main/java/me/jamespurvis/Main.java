package me.jamespurvis;

public class Main {

    public static void main(String[] args ) {

        Heap<Integer> mHeap = new Heap<Integer>(32);

        mHeap.Insert(2);
        mHeap.Insert(4);
        mHeap.Insert(1);
        mHeap.Insert(100);
        mHeap.Insert(3);

        System.out.println(mHeap.popMax());
    }
}
