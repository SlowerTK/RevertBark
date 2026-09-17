package com.slowertk.revertbark;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod(RevertBark.MOD_ID)
public class RevertBark {
    public static final String MOD_ID = "revertbark";

    public RevertBark(IEventBus modBus) {
        System.out.println("RevertBark initialize");
    }
}

