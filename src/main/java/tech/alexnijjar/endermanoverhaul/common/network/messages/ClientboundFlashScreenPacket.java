package tech.alexnijjar.endermanoverhaul.common.network.messages;


import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.ClientboundPacketType;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import com.teamresourceful.resourcefullib.common.network.defaults.DatalessPacketType;
import net.minecraft.resources.ResourceLocation;
import tech.alexnijjar.endermanoverhaul.EndermanOverhaul;
import tech.alexnijjar.endermanoverhaul.client.gui.FlashOverlay;

public class ClientboundFlashScreenPacket implements Packet<ClientboundFlashScreenPacket> {

    public static final ClientboundPacketType<ClientboundFlashScreenPacket> TYPE = new Type();

    @Override
    public PacketType<ClientboundFlashScreenPacket> type() {
        return TYPE;
    }

    private static class Type extends DatalessPacketType<ClientboundFlashScreenPacket> implements ClientboundPacketType<ClientboundFlashScreenPacket> {

        public Type() {
            super(ClientboundFlashScreenPacket.class,
                ResourceLocation.fromNamespaceAndPath(EndermanOverhaul.MOD_ID, "flash_screen"),
                ClientboundFlashScreenPacket::new);
        }

        @Override
        public Runnable handle(ClientboundFlashScreenPacket message) {
            return () -> FlashOverlay.shouldFlash = true;
        }
    }
}
