/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumstuff;

/**
 *
 * @author pccto
 */
public enum direction {
    north(0), south(180), east(90), west(270);
    private final int degrees;
    direction (int degrees){
        this.degrees= degrees;
    }
    
    public int degrees() {
        return this.degrees;
    }
    
}
