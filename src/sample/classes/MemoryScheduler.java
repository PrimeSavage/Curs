package sample.classes;

import java.util.ArrayList;


public class MemoryScheduler {

    private ArrayList<MemoryBlock> memoryBlocks = new ArrayList<>();

    public String print() {
        StringBuilder result = new StringBuilder("[ ");
        for (final MemoryBlock memoryBlock : memoryBlocks) {
            result.append(memoryBlock).append(" ");
        }
        return result + " ]";
    }

    public boolean findFreeBlock(final int size, final Process process) {
        boolean check = false;
        try{
            memoryBlocks.sort(MemoryBlock.byEnd);
        }catch (Exception e){
            e.printStackTrace();
        }
        final ArrayList<MemoryBlock> tempMemoryBlocks = new ArrayList<>();
        if(memoryBlocks.isEmpty()){
            process.setMemoryBlock(new MemoryBlock(Configuration.OSMemoryVolume + 1, Configuration.OSMemoryVolume + size + 1));
            memoryBlocks.add(process.getMemoryBlock());
            check = true;
        }
        else {
            if ((memoryBlocks.get(0).start - 1) - (Configuration.OSMemoryVolume + 1) >= size) {
                tempMemoryBlocks.add(new MemoryBlock(Configuration.OSMemoryVolume + 1, memoryBlocks.get(0).start - 1));
            } else {
                if (Configuration.memoryVolume - (memoryBlocks.get(memoryBlocks.size() - 1).end + 1) >= size) {
                    tempMemoryBlocks.add(new MemoryBlock(memoryBlocks.get(memoryBlocks.size() - 1).end + 1, Configuration.memoryVolume));
                } else {
                    for (int i = 0; i < memoryBlocks.size() - 1; i++) {
                        if (memoryBlocks.get(i + 1).start - memoryBlocks.get(i).end >= size) {
                            final MemoryBlock tempMemoryBlock = new MemoryBlock(memoryBlocks.get(i).end, memoryBlocks.get(i + 1).start);
                            tempMemoryBlocks.add(tempMemoryBlock);
                        }
                    }
                }
            }
            if (!tempMemoryBlocks.isEmpty()) {
                process.setMemoryBlock(new MemoryBlock(tempMemoryBlocks.get(0).start + 1, tempMemoryBlocks.get(0).start + size));
                memoryBlocks.add(process.getMemoryBlock());
                check = true;
            }
        }
        return check;
    }


    public void releaseMemoryBlock(final MemoryBlock memoryBlock) {
        memoryBlocks.remove(memoryBlock);
    }

    public ArrayList<MemoryBlock> getMemoryBlocks() {
        return memoryBlocks;
    }

    public boolean add(final int size, final Process process) {
        boolean check = false;
        if (!memoryBlocks.isEmpty()) {
            if (memoryBlocks.get(memoryBlocks.size() - 1).end + size < Configuration.memoryVolume) {
                process.setMemoryBlock(new MemoryBlock(memoryBlocks.get(memoryBlocks.size() - 1).end + 1, memoryBlocks.get(memoryBlocks.size() - 1).end + size + 1));
                memoryBlocks.add(process.getMemoryBlock());
                check = true;
            }
        } else {
            process.setMemoryBlock(new MemoryBlock(Configuration.OSMemoryVolume + 1, Configuration.OSMemoryVolume + size + 1));
            memoryBlocks.add(process.getMemoryBlock());
            check = true;
        }
        return check;
    }
}
