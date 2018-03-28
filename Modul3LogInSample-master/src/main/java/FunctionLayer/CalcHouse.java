/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.ProductMapper;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class CalcHouse {
  
    ProductMapper pm = new ProductMapper();

    public ArrayList<Wall> legoCalc(int length, int width, int height) throws LegoException {

        ArrayList<Wall> legoWalls = new ArrayList();
        Block block2x1 = new Block("2x1", pm.getLegoblockbyName("2x1").getLength());
        Block block2x2 = new Block("2x2", pm.getLegoblockbyName("2x2").getLength());
        Block block2x4 = new Block("2x4", pm.getLegoblockbyName("2x4").getLength());
        
        
        
        Wall wallLength2x4 = new Wall(block2x4, ((length / 4)));
        Wall wallLength2x2 = new Wall(block2x2, ((length % 4)/ 2));
        Wall wallLength2x1 = new Wall(block2x1, ((length % 4)%2)/1);
        Wall wallWidth2x4 = new Wall(block2x4, ((width - 4)/4));
        Wall wallWidth2x2 = new Wall(block2x2, (((width -4) % 4) / 2));
        Wall wallWidth2x1 = new Wall(block2x1, (((width - 4) % 4) % 2) / 2);
        
    
        int amountOfBlocks2x1 = ((wallLength2x1.getBlockAmount() * 2) * height) + ((wallWidth2x1.getBlockAmount() * 2) * height);
        wallLength2x1.setBlockAmount(amountOfBlocks2x1);
        legoWalls.add(wallLength2x1);
        int amountOfBlocks2x2 = ((wallLength2x2.getBlockAmount() * 2) * height) + ((wallWidth2x2.getBlockAmount() * 2) * height);
        wallLength2x2.setBlockAmount(amountOfBlocks2x2);
        legoWalls.add(wallLength2x2);
        int amountOfBlocks2x4 = ((wallLength2x4.getBlockAmount() * 2) * height) + ((wallWidth2x4.getBlockAmount() * 2) * height);
        wallLength2x4.setBlockAmount(amountOfBlocks2x4);
        legoWalls.add(wallLength2x4);
        return legoWalls;
    }
}

