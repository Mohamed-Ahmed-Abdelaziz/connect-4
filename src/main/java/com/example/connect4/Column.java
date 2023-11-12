package com.example.connect4;

public class Column {
    // cell value = 0 for empty, 1 for pc, 2 for human
    byte length;
    byte filledCells;
    short cells;

    public Column(){
        length = 6;
        cells = 0;
        filledCells = 0;
    }

    public short getCells() {
        return cells;
    }

    public boolean add(int turn){
        if(filledCells == length || turn < 1 || turn > 2){
            return false;
        }
        short input = (short) (turn << filledCells*2);
        cells = (short) (cells | input);
        filledCells++;
        return true;
    }

    public int get(int index){
        if(index < 0 || index >= length){
            return -1;
        }
        int mask = 3 << index * 2;
        return (mask & (int)cells) >> (index * 2);
    }

    public boolean isFilled(){
        return filledCells == length;
    }
}
