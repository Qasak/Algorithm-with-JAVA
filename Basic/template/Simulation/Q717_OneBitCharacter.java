package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 17:31
 */
public class Q717_OneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i < bits.length; ) {
            if(bits[i] == 1) {
                i += 2;
                if(i >= bits.length ) {
                    return false;
                }
            } else {
                i++;
                if(i >= bits.length ) {
                    return true;
                }
            }
        }
        return true;
    }
}
