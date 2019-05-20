package com.members;

import com.management.Manager;
import java.lang.module.ModuleDescriptor;
import java.util.Set;

public class Player {

    public static void main(String[] args) {

        Module playerModule = Player.class.getModule();
        Module managerModule = Manager.class.getModule();
        System.out.println("Class 'Player' is in module: " + playerModule.getName());
        System.out.println("Class 'Manager' is in module: " + managerModule.getName());

        boolean playerModuleIsNamed = playerModule.isNamed();
        boolean managerModuleIsNamed = managerModule.isNamed();
        System.out.println("\nThe 'playerModule' module is named module? " + playerModuleIsNamed);
        System.out.println("The 'managerModule' module is named module? " + managerModuleIsNamed);

        boolean playerModulePnExported = playerModule.isExported("com.members");
        boolean managerModulePnExported = managerModule.isExported("com.management");
        System.out.println("\nThe 'playerModule' has exported the 'com.members' package? " 
                + playerModulePnExported);
        System.out.println("The 'managerModule' has exported the 'com.management' package? " 
                + managerModulePnExported);

        boolean playerModulePnOpen = playerModule.isOpen("com.members");
        boolean managerModulePnOpen = managerModule.isOpen("com.management");
        System.out.println("\nThe 'playerModule' has opened the 'com.members' package? " 
                + playerModulePnOpen);
        System.out.println("The 'managerModule' has opened the 'com.management' package? " 
                + managerModulePnOpen);

        boolean before = playerModule.isExported("com.members", managerModule);
        playerModule.addExports("com.members", managerModule);
        boolean after = playerModule.isExported("com.members", managerModule);
        System.out.println("\nBefore exporting 'com.members' via 'addExports()': " + before);
        System.out.println("After exporting 'com.members' via 'addExports()': " + after);

        ModuleDescriptor descriptorPlayerModule = playerModule.getDescriptor();
        ModuleDescriptor descriptorManagerModule = managerModule.getDescriptor();        
        System.out.println("\n'playerModule' packages: " + descriptorPlayerModule.packages());
        System.out.println("'managerModule' packages: " + descriptorManagerModule.packages());
    }
}
