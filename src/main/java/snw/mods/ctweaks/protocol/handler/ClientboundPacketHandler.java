package snw.mods.ctweaks.protocol.handler;

import snw.lib.protocol.handler.PacketHandler;
import snw.mods.ctweaks.protocol.packet.s2c.*;

public interface ClientboundPacketHandler extends PacketHandler {
    void handleAddLayout(ClientboundAddLayoutPacket packet);

    void handleAddRenderer(ClientboundAddRendererPacket packet);

    void handleArrangeLayout(ClientboundArrangeLayoutPacket packet);

    void handleClearLayout(ClientboundClearLayoutPacket packet);

    void handleClearRenderer(ClientboundClearRendererPacket packet);

    void handleHello(ClientboundHelloPacket packet);

    void handleRemoveLayout(ClientboundRemoveLayoutPacket packet);

    void handleRemoveRenderer(ClientboundRemoveRendererPacket packet);

    void handleUpdateGridLayout(ClientboundUpdateGridLayoutPacket packet);

    void handleUpdateLinearLayout(ClientboundUpdateLinearLayoutPacket packet);

    void handleUpdatePlayerFaceRenderer(ClientboundUpdatePlayerFaceRendererPacket packet);

    void handleUpdateTextRenderer(ClientboundUpdateTextRendererPacket packet);
}
