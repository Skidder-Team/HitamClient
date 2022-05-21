package net.ccbluex.liquidbounce.features.module.modules.exploit

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


// walter on top you nns

@ModuleInfo(name = "FakeLog4J", category = ModuleCategory.EXPLOIT)
class FakeLog4J : Module() {

    @EventTarget
    fun onKilled(event: EntityKilledEvent) {
        val target = event.getTargetEntity();
        int var3 = 1;

        while(var3 < 21) {
          ++var3;
          String str = "/msg " + target + " ${{{}}{J}ndi:l{Date}ap:/\/192.168." + RandomUtils.INSTANCE.nextInt(1, 253) + "." + RandomUtils.INSTANCE.nextInt(1, 253) + "}";
          mc.netHandler.addToSendQueue(C01PacketChatMessage(str))
        }
        state=false
    }
}
