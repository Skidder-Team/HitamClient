package net.ccbluex.liquidbounce.features.module.modules.misc

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.event.WorldEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType
import net.ccbluex.liquidbounce.utils.ClientUtils
import net.ccbluex.liquidbounce.value.ListValue
import net.ccbluex.liquidbounce.value.TextValue
import net.ccbluex.liquidbounce.value.BoolValue
import net.minecraft.network.play.server.S14PacketEntity
import net.minecraft.network.play.server.S1DPacketEntityEffect

@ModuleInfo(name = "AntiFanboy", category = ModuleCategory.MISC)
class AntiStaff : Module() {

    val server  = ListValue("Server", arrayOf("LuckyNetwork","CavryNetwork"),"LuckyNetwork")
    val notify  = BoolValue("Notification",true)
    val chat    = BoolValue("SendChatMessage",false)
    val message = TextValue("Message", "%staff% was detected as a staff member!").displayable { chat.get() }

    val leave = BoolValue("Leave",true)
    val leaveMessage = TextValue("LeaveCommand","/hub").displayable { leave.get() }
    
    private var luckynetFanboy : String = "Dapry WhoIsRihun Feraaaa FacedApollo"
    private var cavrynetFanboy : String = "Cavry Necrovert Lievert Dapry JektDV Nafry"

    
    private var detected = false
    private var staffs = "imagine playing on luckynetwork"
    
    
    @EventTarget
    fun onWorld(e: WorldEvent) {
        when (server.get().lowercase()) {

            "luckynetwork" -> {
                staffs = luckynetFanboy
            }

            "cavrynetwork" -> {
                staffs = cavrynetFanboy
            }

            
        }
            
        detected = false
    }

    @EventTarget
    fun onPacket(event: PacketEvent){
        if (mc.theWorld == null || mc.thePlayer == null) return

        val packet = event.packet // smart convert
        if (packet is S1DPacketEntityEffect) {
            val entity = mc.theWorld.getEntityByID(packet.entityId)
            if (entity != null && (staffs.contains(entity.name) || staffs.contains(entity.displayName.unformattedText))) {
                if (!detected) {
                    if (notify.get()){
                        LiquidBounce.hud.addNotification(Notification(name, "Detected staff members with invis. You should quit ASAP.", NotifyType.WARNING, 8000))
                    }
                    
                    if (chat.get()) {
                        mc.thePlayer.sendChatMessage((message.get()).replace("%staff%", entity.name))
                    }
                    if (leave.get()) {
                        mc.thePlayer.sendChatMessage(leaveMessage.get())
                    }
                    
                    detected = true
                }
            }
        }
        if (packet is S14PacketEntity) {
            val entity = packet.getEntity(mc.theWorld)

            if (entity != null && (staffs.contains(entity.name) || staffs.contains(entity.displayName.unformattedText))) {
                if (!detected) {
                    if (notify.get()){
                    LiquidBounce.hud.addNotification(Notification(name, "Detected staff members. You should quit ASAP.", NotifyType.WARNING,8000))
                    }
                    
                    if (chat.get()) {
                        ClientUtils.displayChatMessage((message.get()).replace("%staff%", entity.name))
                    }
                    
                    if (leave.get()) {
                        mc.thePlayer.sendChatMessage(leaveMessage.get())
                    }
                    
                    detected = true
                }
            }
        }
    }
}