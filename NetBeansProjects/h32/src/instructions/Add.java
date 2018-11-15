package instructions;

import h32.Executable;

import static h32.RegisterManipulator.CY;


/**
 *
 * @author pcctoo
 */
public class Add implements Executable {
    public byte add;
    
      // case 0x02:

    @Override
    public void execute(int[] regs, int[] mem, int mar) {

        //AC = AC + mem{X}; CY = CARRY
        int old = regs[AC];
                long result = (long) regs[AC] + (long) mem[mar];
               regs[AC] = (int) result;
                if (result > 0xFFFFFFFFL) {
                    regs[CY] = 1;
                } else {
                    regs[CY] = 0;
    }
              
                }
                //break;


}