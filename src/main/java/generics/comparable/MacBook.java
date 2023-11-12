package generics.comparable;

public class MacBook implements Comparable<MacBook> {
    private int cpuCore;

    public MacBook(int cpuCore) {
        this.cpuCore = cpuCore;
    }


    @Override
    public int compareTo(MacBook other) {
        return this.cpuCore - other.cpuCore;
        // this.cpuCore > other.cpuCore  +
        // this.cpuCore = other.cpuCore  0
        // this.cpuCore < other.cpuCore -
    }
}
