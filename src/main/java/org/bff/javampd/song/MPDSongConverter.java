package org.bff.javampd.song;

import org.bff.javampd.processor.SongProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bill
 */
public class MPDSongConverter implements SongConverter {

    private static final String PREFIX_FILE = SongProcessor.FILE.getProcessor().getPrefix();

    @Override
    public List<MPDSong> convertResponseToSong(List<String> list) {
        List<MPDSong> songList = new ArrayList<>();
        Iterator<String> iterator = list.iterator();

        String line = null;
        while (iterator.hasNext()) {
            if (line == null || (!line.startsWith(PREFIX_FILE))) {
                line = iterator.next();
            }

            if (line.startsWith(PREFIX_FILE)) {
                line = processSong(line.substring(PREFIX_FILE.length()).trim(), iterator, songList);
            }
        }
        return songList;
    }

    private String processSong(String file, Iterator<String> iterator, List<MPDSong> songs) {
        MPDSong song = new MPDSong(file, "");
        initialize(song);
        String line = iterator.next();
        while (!line.startsWith(PREFIX_FILE)) {
            processLine(song, line);
            if (!iterator.hasNext()) {
                break;
            }
            line = iterator.next();
        }
        songs.add(song);

        return line;
    }

    private static void initialize(MPDSong song) {
        song.setName("");
        song.setAlbumName("");
        song.setArtistName("");
        song.setComment("");
        song.setDiscNumber("");
        song.setGenre("");
        song.setTitle("");
        song.setYear("");
    }

    @Override
    public List<String> getSongFileNameList(List<String> fileList) {
        String prefix = SongProcessor.FILE.getProcessor().getPrefix();

        return fileList.stream()
                .filter(s -> s.startsWith(prefix))
                .map(s -> (s.substring(prefix.length())).trim())
                .collect(Collectors.toList());
    }

    private static void processLine(MPDSong song, String line) {
        for (SongProcessor songProcessor : SongProcessor.values()) {
            songProcessor.getProcessor().processSong(song, line);
        }
    }
}
