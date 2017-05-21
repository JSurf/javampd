package org.bff.javampd;

import org.bff.javampd.command.MPDCommandExecutor;
import org.bff.javampd.server.MPD;
import org.bff.javampd.server.MPDConnectionException;
import org.bff.javampd.server.ServerProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.InetAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuilderTest {

    @Mock
    private MPDCommandExecutor mpdCommandExecutor;

    @Mock
    private ServerProperties serverProperties;

    @InjectMocks
    private MPD.Builder mpdBuilder;

    @Captor
    private ArgumentCaptor<String> commandArgumentCaptor;

    private static final int DEFAULT_PORT = 6600;
    private static final int DEFAULT_TIMEOUT = 0;
    private static final String DEFAULT_SERVER = "localhost";

    @Test
    public void testServer() throws Exception {
        MPD mpd = mpdBuilder.server("localhost").build();
        assertEquals(InetAddress.getByName("localhost"), mpd.getAddress());
    }

    @Test(expected = MPDConnectionException.class)
    public void testBuilderException() throws Exception {
        new MPD.Builder().server("bogusServer").build();
    }

    @Test
    public void testPort() throws Exception {
        MPD mpd = mpdBuilder.port(8080).build();
        assertEquals(mpd.getPort(), 8080);
    }

    @Test
    public void testTimeout() throws Exception {
        MPD mpd = mpdBuilder.timeout(0).build();
        assertEquals(mpd.getTimeout(), 0);
    }

    @Test
    public void testPassword() throws Exception {
        String password = "thepassword";
        when(serverProperties.getPassword()).thenReturn(new ServerProperties().getPassword());

        MPD mpd = mpdBuilder.password(password).build();

        verify(mpdCommandExecutor)
                .usePassword(commandArgumentCaptor.capture());
        assertNotNull(mpd);
        assertEquals(password, commandArgumentCaptor.getAllValues().get(0));
    }

    @Test
    public void testNullPassword() throws Exception {
        String password = null;
        when(serverProperties.getPassword()).thenReturn(new ServerProperties().getPassword());

        MPD mpd = mpdBuilder.password(password).build();

        verify(mpdCommandExecutor, never()).usePassword(password);
        assertNotNull(mpd);
    }

    @Test
    public void testBlankPassword() throws Exception {
        String password = "";
        when(serverProperties.getPassword()).thenReturn(new ServerProperties().getPassword());

        MPD mpd = mpdBuilder.password(password).build();

        verify(mpdCommandExecutor, never()).usePassword(password);
        assertNotNull(mpd);
    }

    @Test
    public void testBuild() throws Exception {
        MPD mpd = mpdBuilder.build();
        assertNotNull(mpd);
    }

    @Test
    public void testDefaultServer() throws Exception {
        MPD mpd = mpdBuilder.build();
        assertEquals(InetAddress.getByName(DEFAULT_SERVER), mpd.getAddress());
    }

    @Test
    public void testDefaultPort() throws Exception {
        MPD mpd = mpdBuilder.build();
        assertEquals(mpd.getPort(), DEFAULT_PORT);
    }

    @Test
    public void testDefaultTimeout() throws Exception {
        MPD mpd = mpdBuilder.build();
        assertEquals(mpd.getTimeout(), DEFAULT_TIMEOUT);
    }
}
