package me.jamespurvis;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private final int childCount;
    private final ArrayList<T> data;

    public Heap(int childCount) {
        this.validateChildCount(childCount);
        this.childCount = childCount;
        this.data = new ArrayList<T>();
    }

    private void validateChildCount(int childCount) {
        if (childCount <=0) {
            throw new IllegalArgumentException("ChildCount must be greater than zero.");
        }

        double logChildCount = Math.log(childCount) / Math.log(2);

        if (Math.ceil(logChildCount) != Math.floor(logChildCount)) {
            throw new IllegalArgumentException("childCount must be a power of two");
        }
    }

    public void Insert(T item) {
        data.add(item);
        int itemIndex = data.size() - 1;
        while (itemIndex > 0) {
            itemIndex = this.swapUp(itemIndex);
        }
    }

        private int swapUp(int childIndex) {
            T childValue = data.get(childIndex);
            int parentIndex = (int) Math.floor((float) (childIndex - 1) / childCount);

            if (parentIndex >=0) {
                T parentValue = data.get(parentIndex);

                if (childValue.compareTo(parentValue) > 0 ) {
                    data.set(parentIndex, childValue);
                    data.set(childIndex, parentValue);

                    return parentIndex;
                }
            }

            return -1;
        }

        public T popMax() {
        if (data.size() > 0 ) {
            T maxItem = data.get(0);

            if (data.size() > 1) {
                T lastItem = data.remove(data.size() - 1);
                data.set(0, lastItem);
                int itemIndex = 0;
                while(itemIndex >= 0) {
                    itemIndex = this.swapDown(itemIndex);
                }
            }
            return maxItem;
        } else {
            return null;
        }

        }

        private int swapDown(int parentIndex) {
          T parentValue = data.get(parentIndex);

          int largestChildIndex = 0;
          T largestChildValue = null;

          for(int i = 0; i < childCount; i++) {
              int childIndex = childCount * parentIndex + i + 1;
              if (childIndex < data.size() - 1) {
                  T childValue = data.get(childIndex);

                  if (largestChildValue == null || childValue.compareTo(largestChildValue) > 0) {
                      largestChildIndex = childIndex;
                      largestChildValue = childValue;
                  }
              }
          }

          if (largestChildValue != null && parentValue.compareTo(largestChildValue) < 0) {
              data.set(parentIndex, largestChildValue);
              data.set(largestChildIndex, parentValue);
              return largestChildIndex;
          }

          return -1;
        }
    }





