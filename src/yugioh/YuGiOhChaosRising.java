/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yugioh;

import yugioh.chaosrising.duel.cntl.DuelCntl;
import yugioh.chaosrising.userinterface.UserInterface;
import yugioh.chaosrising.userinterface.UserInterfaceCntl;
import yugioh.testharness.MasterTestHarness;

/**
 * This serves class serves as the entry point to the application. By running this class
 * @author Faust
 * @version .1
 * @since .1
 */
public class YuGiOhChaosRising {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i =0; i < args.length; i++) {
            if(args[i].equalsIgnoreCase("test")) {
                new MasterTestHarness();
                break;
            }
        }

        UserInterfaceCntl.getInstance().loadDuel();
    }
    
}
