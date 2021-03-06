/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructions;

import h32.Executable;
import static java.lang.System.console;

/**
 *
 * @author Adrian Sanchez
 */
public class Sin implements Executable {

    @Override
    public void execute(int[] regs, int[] mem, int mar) {
        // SIN
        // MEM[AC] << console
        String input = console.nextLine();
        for (int i = 0; i < input.length(); ++i) {
            mem[regs[AC] + i] = input.charAt(i);
        }
        mem[regs[AC] + input.length()] = 0;
    }

}
