package me.jamespurvis;

public class PowerTwoMaxHeap {

    private int[] heapData;
    private int heapPowerOf;
    private int heapSize;

    public PowerTwoMaxHeap(int powerOf) {
        this.heapPowerOf = powerOf;
        this.heapData = new int[1];
        this.heapSize = 0;
    }

    public void insertion(int insertionValue) {

        //If the heap's size is equal to the length of our array
        //we need to resize the array to continue insertion.
        if (heapSize == heapData.length) {
            resizeArray();
        }

        //Add our insertion value to the end of the heap.
        heapData[0] = insertionValue;

        //set our currentIndex to the size of the heap.
        int heapCurrentIndex = heapSize;

        //This loops compares heapData[heapCurrentIndex] with heapData[heapCurrentIndex -1] to see which is larger.
        while (heapCurrentIndex > 0 && heapData[heapCurrentIndex] > heapData[heapCurrentIndex - 1] / (int) Math.pow(2, heapPowerOf)) {
            //Conditions are met, so we will perform a swap.

            //A placeholder variable used to hold the current variable located at heapData[heapCurrentIndex]
            int heapSwap = heapData[heapCurrentIndex];

            //perform the swap
            heapData[heapCurrentIndex] = heapData[(heapCurrentIndex - 1) / (int) Math.pow(2, heapPowerOf)];
            heapData[(heapCurrentIndex - 1) / (int) Math.pow(2, heapPowerOf)] = heapSwap;
            heapCurrentIndex = (heapCurrentIndex - 1) / (int) Math.pow(2, heapPowerOf);
        }

        //out of loop, item has been inserted increment our heap size
        heapSize++;
    }

    public int popMax() {

        //store the root element
        int rootElement = heapData[0];

        //swap the rootElement with the last element in the array.
        heapData[0] = heapData[heapSize - 1];

        //decrement our heapSize
        heapSize--;

        int heapCurrentIndex = 0;

        //compare each element within the boundaries of the current index to the size of the heap

        while (heapCurrentIndex < heapSize) {
            int heapMaxIndex = heapCurrentIndex;

            for (int i = 1; i <= (int) Math.pow(2, heapPowerOf); i++) {
                int heapChildIndex = (int) Math.pow(2, heapPowerOf) * heapCurrentIndex + i;

                if (heapChildIndex < heapSize && heapData[heapChildIndex] > heapData[heapMaxIndex]) {
                    heapMaxIndex = heapChildIndex;
                }
            }
            //swap the element
            if (heapData[heapCurrentIndex] < heapData[heapMaxIndex]) {

                int swap = heapData[heapCurrentIndex];

                heapData[heapCurrentIndex] = heapData[heapMaxIndex];

                heapData[heapMaxIndex] = swap;

                heapCurrentIndex = heapMaxIndex;

            } else {

                break;
            }

        }

        return rootElement;
    }

    public void resizeArray() {
        int[] newHeapData = new int[heapData.length * 2];
        for(int a = 0; a < heapData.length; a++) {
            heapData[a] = heapData[a];
        }
        heapData = newHeapData;
    }
}





