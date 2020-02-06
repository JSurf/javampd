package org.bff.javampd;

import org.bff.javampd.admin.Admin;
import org.bff.javampd.admin.MPDAdmin;
import org.bff.javampd.album.AlbumConverter;
import org.bff.javampd.album.MPDAlbumConverter;
import org.bff.javampd.art.ArtworkFinder;
import org.bff.javampd.art.MPDArtworkFinder;
import org.bff.javampd.command.CommandExecutor;
import org.bff.javampd.command.MPDCommandExecutor;
import org.bff.javampd.database.MPDTagLister;
import org.bff.javampd.database.TagLister;
import org.bff.javampd.player.MPDPlayer;
import org.bff.javampd.player.Player;
import org.bff.javampd.playlist.MPDPlaylist;
import org.bff.javampd.playlist.Playlist;
import org.bff.javampd.server.MPDServerStatus;
import org.bff.javampd.server.ServerStatus;
import org.bff.javampd.song.MPDSongConverter;
import org.bff.javampd.song.SongConverter;
import org.bff.javampd.statistics.MPDServerStatistics;
import org.bff.javampd.statistics.ServerStatistics;

import dagger.Binds;
import dagger.Module;

/**
 * Initializes the DI bindings
 *
 * @author bill
 */
@Module
public abstract class MPDModule {
	    @Binds 
        public abstract Admin bindAdmin(MPDAdmin obj);
	    @Binds 
        public abstract Player bindPlayer(MPDPlayer obj);
	    @Binds 
        public abstract Playlist bindPlaylist(MPDPlaylist obj);
	    @Binds 
        public abstract ServerStatus bindServerStatus(MPDServerStatus obj);
	    @Binds 
        public abstract ServerStatistics bindServerStatistics(MPDServerStatistics obj);
	    @Binds 
        public abstract CommandExecutor bindCommandExecutor(MPDCommandExecutor obj);
	    @Binds 
        public abstract TagLister bindTagLister(MPDTagLister obj);
	    @Binds 
        public abstract SongConverter bindSongConverter(MPDSongConverter obj);
	    @Binds 
        public abstract AlbumConverter bindAlbumConverter(MPDAlbumConverter obj);
	    @Binds 
        public abstract ArtworkFinder bindArtworkFinder(MPDArtworkFinder obj);
	    @Binds 
        public abstract Clock bindClock(MPDSystemClock obj);
}
