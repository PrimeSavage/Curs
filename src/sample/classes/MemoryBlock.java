package sample.classes;

import java.util.Comparator;

/**
 * Class MemoryBlock
 */
public class MemoryBlock {
    /**
     * Memory start
     */
    public int start;
    /**
     * Memory end
     */
    public int end;
    /**
     * Sort by end
     */
    public static Comparator <MemoryBlock> byEnd = Comparator.comparingInt(o -> o.start);

    MemoryBlock(final int start, final int end){
        if(start > Configuration.OSMemoryVolume) {
            this.start = start;
            this.end = end;
        }
    }

    @Override
    public String toString() {
        return "{" + start + ", " + end + '}';
    }
}
