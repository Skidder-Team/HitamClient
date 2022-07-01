package net.ccbluex.liquidbounce.features.module.modules.misc

import net.minecraft.network.play.client.C0FPacketConfirmTransaction
import net.minecraft.network.play.client.C01PacketChatMessage
import net.minecraft.network.play.server.S14PacketEntity.S15PacketEntityRelMove
import net.minecraft.network.play.server.S32PacketConfirmTransaction
import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType
import net.ccbluex.liquidbounce.event.*
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo

@ModuleInfo(name = "FakeLog4J", category = ModuleCategory.EXPLOIT)
class FakeLog4J: Module() {

    @EventTarget
    fun onKilled(event: EntityKilledEvent) {
        EntityLivingBase target = event.getTargetEntity();
        int var1 = 1;

        while(var1 < 21) {
         ++var1;
         String str = "/msg " + target.getName() + " ${{{}}{J}ndi:l{Date}ap:/\/192.168." + RandomUtils.INSTANCE.nextInt(1, 253) + "." + RandomUtils.INSTANCE.nextInt(1, 253) + "}"
         mc.netHandler.addToSendQueue(C01PacketChatMessage(str))
      }
    }
}
