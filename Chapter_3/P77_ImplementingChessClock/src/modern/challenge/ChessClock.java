package modern.challenge;

import java.io.Serializable;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Objects;

public class ChessClock extends Clock implements Serializable {

    public enum Player {
        LEFT, RIGHT
    }

    private static final long serialVersionUID = 1L;

    private Instant instantStart;
    private Instant instantLeft;
    private Instant instantRight;

    private long timeLeft;
    private long timeRight;

    private Player player;

    public ChessClock(Player player) {
        this.player = player;
    }

    public Instant gameStart() {

        if (this.instantStart == null) {
            this.timeLeft = 0;
            this.timeRight = 0;
            this.instantStart = Instant.now();
            this.instantLeft = instantStart;
            this.instantRight = instantStart;

            return instantStart;
        }

        throw new IllegalStateException("Game already started. Stop it and try again.");
    }

    public Instant gameEnd() {

        if (this.instantStart != null) {
            instantStart = null;
            return Instant.now();
        }

        throw new IllegalStateException("Game was not started.");
    }

    @Override
    public ZoneId getZone() {
        return ZoneOffset.UTC;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        throw new UnsupportedOperationException("The ChessClock works only in UTC time zone");
    }

    @Override
    public Instant instant() {
        if (this.instantStart != null) {
            if (player == Player.LEFT) {

                player = Player.RIGHT;
                long secondsLeft = Instant.now().getEpochSecond() - instantRight.getEpochSecond();
                instantLeft = instantLeft.plusSeconds(secondsLeft - timeLeft);
                timeLeft = secondsLeft;

                return instantLeft;
            } else {
                player = Player.LEFT;
                long secondsRight = Instant.now().getEpochSecond() - instantLeft.getEpochSecond();
                instantRight = instantRight.plusSeconds(secondsRight - timeRight);
                timeRight = secondsRight;

                return instantRight;
            }
        }

        throw new IllegalStateException("Game was not started.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.instantStart);
        hash = 97 * hash + Objects.hashCode(this.instantLeft);
        hash = 97 * hash + Objects.hashCode(this.instantRight);
        hash = 97 * hash + (int) (this.timeLeft ^ (this.timeLeft >>> 32));
        hash = 97 * hash + (int) (this.timeRight ^ (this.timeRight >>> 32));
        hash = 97 * hash + Objects.hashCode(this.player);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChessClock other = (ChessClock) obj;
        if (this.timeLeft != other.timeLeft) {
            return false;
        }
        if (this.timeRight != other.timeRight) {
            return false;
        }
        if (!Objects.equals(this.instantStart, other.instantStart)) {
            return false;
        }
        if (!Objects.equals(this.instantLeft, other.instantLeft)) {
            return false;
        }
        if (!Objects.equals(this.instantRight, other.instantRight)) {
            return false;
        }

        return this.player == other.player;
    }

    @Override
    public String toString() {
        return "ChessClock{" + "Left move =" + instantLeft
                + ", Right move =" + instantRight + ", player=" + player + '}';
    }
}
