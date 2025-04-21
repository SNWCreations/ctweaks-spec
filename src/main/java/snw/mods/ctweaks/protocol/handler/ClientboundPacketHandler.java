package snw.mods.ctweaks.protocol.handler;

import snw.lib.protocol.handler.PacketHandler;
import snw.mods.ctweaks.protocol.packet.s2c.*;

public interface ClientboundPacketHandler extends PacketHandler {
    void handleAddRenderer(ClientboundAddRendererPacket packet);

    void handleClearRenderer(ClientboundClearRendererPacket packet);

    void handleHello(ClientboundHelloPacket packet);

    void handleRemoveRenderer(ClientboundRemoveRendererPacket packet);

    void handleUpdateTextRenderer(ClientboundUpdateTextRendererPacket packet);
}
