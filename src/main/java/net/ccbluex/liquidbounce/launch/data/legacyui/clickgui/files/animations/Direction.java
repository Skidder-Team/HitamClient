package net.ccbluex.liquidbounce.launch.data.legacyui.clickgui.files.animations;

public enum Direction {
    FORWARDS,
    BACKWARDS;

    public Direction opposite() {
        if (this == Direction.FORWARDS) {
            return Direction.BACKWARDS;
        } else return Direction.FORWARDS;
    }

}