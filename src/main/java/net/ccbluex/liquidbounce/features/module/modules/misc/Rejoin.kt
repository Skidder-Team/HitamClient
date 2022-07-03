package net.ccbluex.liquidbounce.features.module.modules.misc

import net.minecraft.network.play.client.C01PacketChatMessage
import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType
import net.ccbluex.liquidbounce.event.*
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo

@ModuleInfo(name = "Rejoin", category = ModuleCategory.MISC)
class Rejoin: Module() {

    override fun onEnable() {
        doRejoin()
    }

    private fun doRejoin() {
        mc.netHandler.addToSendQueue(C01PacketChatMessage("/leave"))
    }
    
    @EventTarget
    fun onWorld(event: WorldEvent) {
        mc.netHandler.addToSendQueue(C01PacketChatMessage("/rejoin"))
        LiquidBounce.hud.addNotification(Notification(this.name, "Rejoined", NotifyType.INFO))
        state=false
    }
}
