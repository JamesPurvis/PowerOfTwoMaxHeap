package me.jamespurvis;

public class Main {

    public static void main(String[] args ) {

        PowerTwoMaxHeap mHeap = new PowerTwoMaxHeap(20);

        mHeap.insertion(2);
        mHeap.insertion(19);
        mHeap.insertion(30);
        mHeap.insertion(5);
        mHeap.insertion(8);

        System.out.println(mHeap.popMax());
    }
}
