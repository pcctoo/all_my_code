/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;

/**
 *
 * @author Joshua Neilson
 */
public class Mult implements Executable{

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // MULT X
        // AC = AC * MEM[X]
        regs[AC] = regs[AC] * mem[mar];
    }
    
}
