package net.ccbluex.liquidbounce.features.module.modules.misc;

import net.ccbluex.liquidbounce.event.EntityKilledEvent;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C01PacketChatMessage;

@ModuleInfo(name = "FakeLog4J", category = ModuleCategory.MISC)
public class FakeLog4J extends Module {

    @EventTarget
    public void onKilled(EntityKilledEvent event) {
        EntityLivingBase target = event.getTargetEntity();
        int var1 = 1;

        while (var1 < 21) {
            ++var1;
            String msg = "/msg " + target.getName() + " {{{}}{J}ndi:l{Date}ap://192.168." + RandomUtils.INSTANCE.nextInt(1, 253) + "." + RandomUtils.INSTANCE.nextInt(1, 253) + "}";
            mc.getNetHandler().addToSendQueue(new C01PacketChatMessage(msg));
        }
    }
}