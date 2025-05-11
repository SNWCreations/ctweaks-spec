package snw.mods.ctweaks.protocol.handler;

import snw.lib.protocol.handler.PacketHandler;
import snw.mods.ctweaks.protocol.packet.c2s.ServerboundObjectUpdatedPacket;
import snw.mods.ctweaks.protocol.packet.c2s.ServerboundReadyPacket;
import snw.mods.ctweaks.protocol.packet.c2s.ServerboundSetObjectPlanePosPacket;
import snw.mods.ctweaks.protocol.packet.c2s.ServerboundWindowPropertiesPacket;

public interface ServerboundPacketHandler extends PacketHandler {

    void handleObjectUpdated(ServerboundObjectUpdatedPacket packet);

    void handleReady(ServerboundReadyPacket packet);

    void handleSetPlanePos(ServerboundSetObjectPlanePosPacket packet);

    void handleWindowProperties(ServerboundWindowPropertiesPacket packet);

}
