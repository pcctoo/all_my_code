/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;


/**
 *
 * @author pcctoo
 */
public class Addr implements Executable {
                // ADDR S
                // AC = AC + MEM[BP + S]; CY = CARRY

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        
          int OFFSET = 0;
    if ((mar & 0x800000) == 0x800000) {
         OFFSET = ((~mar & 0xFFFFFF) + 1) * -1;
     } else {
           OFFSET = mar;
       }
                 
                    long result = (long) regs[AC] + (long) mem[regs[BP] + OFFSET];
                regs[AC] = (int) result;
                if (result > 0xFFFFFFFF) {
                    regs[CY] = 1;
                } else {
                    regs[CY] = 0;
                }
    }
            
}
