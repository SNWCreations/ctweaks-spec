package snw.mods.ctweaks.object.pos;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.Range;
import snw.lib.protocol.io.PacketReader;
import snw.lib.protocol.io.PacketWriter;

public record PlanePosition(
        @Range(from = 0, to = Integer.MAX_VALUE) int x,
        @Range(from = 0, to = Integer.MAX_VALUE) int y
) {
    public static final PacketReader<PlanePosition> READER;
    public static final PacketWriter<PlanePosition> WRITER;

    static {
        READER = input -> {
            final int x = input.readInt();
            final int y = input.readInt();
            return new PlanePosition(x, y);
        };
        WRITER = (output, planePosition) -> {
            final int x = planePosition.x();
            final int y = planePosition.y();
            output.writeInt(x);
            output.writeInt(y);
        };
    }

    public PlanePosition {
        Preconditions.checkArgument(x > 0, "x must be positive");
        Preconditions.checkArgument(y > 0, "y must be positive");
    }

    public interface Getter {
        PlanePosition getPosition();
    }

    public interface Setter {
        void setPosition(PlanePosition position);
    }

    public interface PropertySetter<T extends PropertySetter<T>> {
        T setPosition(PlanePosition position);
    }

    public static PlanePosition planePos(int x, int y) {
        return new PlanePosition(x, y);
    }
}
