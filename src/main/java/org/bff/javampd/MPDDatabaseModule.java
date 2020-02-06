package org.bff.javampd;

import org.bff.javampd.album.AlbumDatabase;
import org.bff.javampd.album.MPDAlbumDatabase;
import org.bff.javampd.artist.ArtistDatabase;
import org.bff.javampd.artist.MPDArtistDatabase;
import org.bff.javampd.database.MPDMusicDatabase;
import org.bff.javampd.database.MusicDatabase;
import org.bff.javampd.file.FileDatabase;
import org.bff.javampd.file.MPDFileDatabase;
import org.bff.javampd.genre.GenreDatabase;
import org.bff.javampd.genre.MPDGenreDatabase;
import org.bff.javampd.playlist.MPDPlaylistDatabase;
import org.bff.javampd.playlist.PlaylistDatabase;
import org.bff.javampd.song.MPDSongDatabase;
import org.bff.javampd.song.MPDSongSearcher;
import org.bff.javampd.song.SongDatabase;
import org.bff.javampd.song.SongSearcher;
import org.bff.javampd.year.DateDatabase;
import org.bff.javampd.year.MPDDateDatabase;

import dagger.Binds;
import dagger.Module;

/**
 * Initializes the DI bindings
 *
 * @author bill
 */
@Module
public abstract class MPDDatabaseModule {
    
	@Binds
	public abstract ArtistDatabase bindArtistDatabase(MPDArtistDatabase artistDatabase);
	@Binds
	public abstract AlbumDatabase bindAlbumDatabase(MPDAlbumDatabase albumDatabase);
	@Binds
	public abstract SongDatabase bindSongDatabase(MPDSongDatabase songDatabase);
	@Binds
	public abstract GenreDatabase bindGenreDatabase(MPDGenreDatabase obj);
	@Binds
    public abstract PlaylistDatabase bindPlaylistDatabase(MPDPlaylistDatabase obj);
	@Binds
    public abstract FileDatabase bindFileDatabase(MPDFileDatabase obj);
	@Binds
    public abstract DateDatabase bindDateDatabase(MPDDateDatabase obj);
	@Binds
    public abstract MusicDatabase bindMusicDatabase(MPDMusicDatabase obj);
	@Binds
    public abstract SongSearcher bindSongSearcher(MPDSongSearcher obj);
}
