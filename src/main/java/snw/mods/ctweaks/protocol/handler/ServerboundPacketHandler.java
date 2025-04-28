package snw.mods.ctweaks.protocol.handler;

import snw.lib.protocol.handler.PacketHandler;
import snw.mods.ctweaks.protocol.packet.c2s.ServerboundWindowPropertiesPacket;

public interface ServerboundPacketHandler extends PacketHandler {

    void handleWindowProperties(ServerboundWindowPropertiesPacket packet);

}
