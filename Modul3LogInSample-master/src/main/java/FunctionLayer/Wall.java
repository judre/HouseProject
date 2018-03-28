/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author andre
 */
public class Wall {
    private Block block;
    private int blockAmount;

    public Wall(Block block, int blockAmount) {
        this.block = block;
        this.blockAmount = blockAmount;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public int getBlockAmount() {
        return blockAmount;
    }

    public void setBlockAmount(int blockAmount) {
        this.blockAmount = blockAmount;
    }
   
}
