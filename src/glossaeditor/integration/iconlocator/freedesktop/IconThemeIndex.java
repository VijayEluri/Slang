/*
 *  Copyright 2010 Georgios Migdos <cyberpython@gmail.com>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package glossaeditor.integration.iconlocator.freedesktop;

import java.io.*;
import java.util.*;

public class IconThemeIndex {

    //TODO: FIXME
    Hashtable entryLookupTable;

    public IconThemeIndex() {
        entryLookupTable = new Hashtable();
    }

    public void load(String filename) throws FileNotFoundException {

        try {

            Hashtable currentEntry = null;
            String entryName;

            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {


                if (line.startsWith("[")) {

                    entryName = line.substring(1, line.indexOf("]")).toLowerCase();
                    currentEntry = (Hashtable) entryLookupTable.get(entryName);
                    if (currentEntry == null) {
                        currentEntry = new Hashtable();
                        entryLookupTable.put(entryName, currentEntry);
                    }

                } else if (line.startsWith(";") || line.startsWith("#")) {
                    continue;

                } else {
                    if (line.indexOf("=") != -1 && currentEntry != null) {
                        String v = line.substring(line.indexOf("=") + 1).trim();
                        String k = line.substring(0, line.indexOf("=")).trim().toLowerCase();
                        currentEntry.put(k, v);
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getValue(String entry, String key) {
        try {
            return (String) getEntry(entry).get(key.toLowerCase());
        } catch (NullPointerException e) {
            return null;
        }
    }

    private Hashtable getEntry(String section) {
        return (Hashtable) (entryLookupTable.get(section.toLowerCase()));
    }
}