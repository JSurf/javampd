/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bff.javampd.objects;

/**
 * String represents an artist.
 *
 * @author Bill
 */
public class MPDArtist extends MPDItem {

    /**
     * Creates a String object
     *
     * @param name the name of the artist
     */
    public MPDArtist(String name) {
        setName(name);
    }
}
