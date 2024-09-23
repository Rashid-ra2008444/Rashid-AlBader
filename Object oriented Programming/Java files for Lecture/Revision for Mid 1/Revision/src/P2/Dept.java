package P2;
//Code the enumeration Dept having the integer private attributes capacity and count=0.
// This enumeration declares three Dept objects each of a specified capacity.
// These objects are CSE with capacity 300, EEE with capacity 100, and MIE with capacity 200.
// The enumeration also has the public methods getCapacity, getCount, and incCount.
// The method incCount increments count by one as long as it does not exceed the value of the capacity otherwise, it does nothing.
public enum Dept {
    CSE(300),
    EEE(100),
    MIE(200);
    int capacity;
    int count=0;
    Dept(int capacity){
        this.capacity = capacity;
    }
    public void incCount(){
        if(count < capacity){
            count++;
        }
    }
    public int getCount(){
        return count;
    }
    public int getCapacity(){
        return capacity;
    }
}
