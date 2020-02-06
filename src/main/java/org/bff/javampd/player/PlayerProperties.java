package org.bff.javampd.player;

import javax.inject.Inject;

import org.bff.javampd.server.MPDProperties;

/**
 * @author bill
 */
public class PlayerProperties extends MPDProperties {

    @Inject
	public PlayerProperties() {
    	super();
    }
	private enum Command {
        XFADE("player.crossfade"),
        CURRSONG("player.currentsong"),
        NEXT("player.next"),
        PAUSE("player.pause"),
        PLAY("player.play"),
        PLAYID("player.play.id"),
        PREV("player.prev"),
        REPEAT("player.repeat"),
        RANDOM("player.random"),
        SEEK("player.seek"),
        SEEKID("player.seek.id"),
        STOP("player.stop"),
        SETVOL("player.set.volume");

        private final String key;

        Command(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public String getXFade() {
        return getPropertyString(Command.XFADE.getKey());
    }

    public String getCurrentSong() {
        return getPropertyString(Command.CURRSONG.getKey());
    }

    public String getNext() {
        return getPropertyString(Command.NEXT.getKey());
    }

    public String getPause() {
        return getPropertyString(Command.PAUSE.getKey());
    }

    public String getPlay() {
        return getPropertyString(Command.PLAY.getKey());
    }

    public String getPlayId() {
        return getPropertyString(Command.PLAYID.getKey());
    }

    public String getPrevious() {
        return getPropertyString(Command.PREV.getKey());
    }

    public String getRepeat() {
        return getPropertyString(Command.REPEAT.getKey());
    }

    public String getRandom() {
        return getPropertyString(Command.RANDOM.getKey());
    }

    public String getSeek() {
        return getPropertyString(Command.SEEK.getKey());
    }

    public String getSeekId() {
        return getPropertyString(Command.SEEKID.getKey());
    }

    public String getStop() {
        return getPropertyString(Command.STOP.getKey());
    }

    public String getSetVolume() {
        return getPropertyString(Command.SETVOL.getKey());
    }
}
