/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;

/**
 *
 * @author Adrian Sanchez
 */
public class Shll implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
                // SHLL X
                // AC = AC << X (inject 0's)
                regs[AC] = regs[AC] << mar;
    }
    
}
