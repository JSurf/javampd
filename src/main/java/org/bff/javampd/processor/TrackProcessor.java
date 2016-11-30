package org.bff.javampd.processor;

import org.bff.javampd.song.MPDSong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackProcessor extends SongResponseProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackProcessor.class);

    public TrackProcessor() {
        super("Track:");
    }

    @Override
    public void processSong(MPDSong song, String line) {
        if (startsWith(line)) {
            song.setTrack(processTrack(line.substring(getPrefix().length()).trim()));
        }
    }

    private static int processTrack(String track) {
        try {
            return Integer.parseInt(track.split("/")[0]);
        } catch (NumberFormatException nfe) {
            LOGGER.error("Unable to format track", nfe);
        }

        return 0;
    }
}
