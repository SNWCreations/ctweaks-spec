package snw.mods.ctweaks.object.pos;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.Range;

public record PlanePosition(
        @Range(from = 0, to = Integer.MAX_VALUE) int x,
        @Range(from = 0, to = Integer.MAX_VALUE) int y
) {
    public PlanePosition {
        Preconditions.checkArgument(x > 0, "x must be positive");
        Preconditions.checkArgument(y > 0, "y must be positive");
    }

    public interface Getter {
        PlanePosition getPosition();
    }

    public static PlanePosition planePos(int x, int y) {
        return new PlanePosition(x, y);
    }
}
