package snw.mods.ctweaks.protocol.handler;

import snw.lib.protocol.handler.PacketHandler;
import snw.mods.ctweaks.protocol.packet.s2c.ClientboundAddRendererPacket;
import snw.mods.ctweaks.protocol.packet.s2c.ClientboundClearRendererPacket;
import snw.mods.ctweaks.protocol.packet.s2c.ClientboundRemoveRendererPacket;
import snw.mods.ctweaks.protocol.packet.s2c.ClientboundUpdateTextRendererPacket;

public interface ClientboundPacketHandler extends PacketHandler {
    void handleAddRenderer(ClientboundAddRendererPacket packet);

    void handleClearRenderer(ClientboundClearRendererPacket packet);

    void handleRemoveRenderer(ClientboundRemoveRendererPacket packet);

    void handleUpdateTextRenderer(ClientboundUpdateTextRendererPacket packet);
}
