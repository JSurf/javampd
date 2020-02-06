package org.bff.javampd;

import org.bff.javampd.monitor.*;

import dagger.Binds;
import dagger.Module;

/**
 * Initializes the DI bindings
 *
 * @author bill
 */
@Module
public abstract class MPDMonitorModule {
        @Binds 
        public abstract StandAloneMonitor bindStandAloneMonitor(MPDStandAloneMonitor obj);
        @Binds 
        public abstract OutputMonitor bindOutputMonitor(MPDOutputMonitor obj);
        @Binds 
        public abstract TrackMonitor bindTrackMonitor(MPDTrackMonitor obj);
        @Binds 
        public abstract ConnectionMonitor bindConnectionMonitor(MPDConnectionMonitor obj);
        @Binds 
        public abstract VolumeMonitor bindVolumeMonitor(MPDVolumeMonitor obj);
        @Binds 
        public abstract PlayerMonitor bindPlayerMonitor(MPDPlayerMonitor obj);
        @Binds 
        public abstract BitrateMonitor bindBitrateMonitor(MPDBitrateMonitor obj);
        @Binds 
        public abstract PlaylistMonitor bindPlaylistMonitor(MPDPlaylistMonitor obj);
        @Binds 
        public abstract ErrorMonitor bindErrorMonitor(MPDErrorMonitor obj);
}
