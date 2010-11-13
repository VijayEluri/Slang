/*
 *  Copyright 2009 Georgios "cyberpython" Migdos <cyberpython@gmail.com>.
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

package glossaeditor.util;

import glossaeditor.Slang;
import glossaeditor.integration.SystemInfo;
import java.io.IOException;

/**
 *
 * @author Georgios "cyberpython" Migdos <cyberpython@gmail.com>
 */
public class MiscUtils {

    public static boolean runningOnWindows(){
        SystemInfo sysInfo =  Slang.getApplication().getSystemInfo();
        String osName = sysInfo.getOSName();
        if( osName.contains("windows")){
            return true;
        }
        return false;
    }

    public static boolean runningOnWindowsVistaOrLater(){
        SystemInfo sysInfo =  Slang.getApplication().getSystemInfo();
        String osName = sysInfo.getOSName();
        if( osName.contains("windows")){
            String version = sysInfo.getOSVersion();
            Float v = Float.parseFloat(version);
            if(v>5.2){
                return true;
            }
        }
        return false;
    }

    public void execCommand(String cmd) {

        Runtime rt = Runtime.getRuntime();
        try {
            Process p = rt.exec(cmd);

        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

}
