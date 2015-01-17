/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2015, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.model.page.atewebdriver;

import org.eclipse.jdt.annotation.Nullable;

// TODO: Auto-generated Javadoc
/**
 * This class ostype defines ....
 * @author Jun Yang
 *
 */
    
public class OSinfo {
	@Nullable
    private static String OS = "";  
    private static OSinfo _instance = new OSinfo();;  
    private EPlatform platform ;
    
    private OSinfo(){
        OS = System.getProperty("os.name").toLowerCase();
    	platform = EPlatform.Others;
    }  
      
    public static boolean isLinux(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("linux")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isMacOS(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("mac")>=0 && os2.indexOf("os")>0 && os2.indexOf("x")<0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isMacOSX(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("mac")>=0 && os2.indexOf("os")>0 && os2.indexOf("x")>0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isWindows(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("windows")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isOS2(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("os/2")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isSolaris(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("solaris")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isSunOS(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("sunos")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isMPEiX(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("mpe/ix")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isHPUX(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("hp-ux")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isAix(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("aix")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isOS390(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("os/390")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isFreeBSD(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("freebsd")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isIrix(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("irix")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isDigitalUnix(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("digital")>=0 && os2.indexOf("unix")>0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isNetWare(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("netware")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isOSF1(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("osf1")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    public static boolean isOpenVMS(){  
        final String os2 = OS;
		if (os2 != null) {
			return os2.indexOf("openvms")>=0;
		} else {
			// TODO handle null value
			return false;
		}  
    }  
      
    /** 
     * Get the name of operating system 
     * @return  the name of operating system
     */  
    public static EPlatform getOSname(){  
        if(isAix()){  
            _instance.platform = EPlatform.AIX;  
        }else if (isDigitalUnix()) {  
            _instance.platform = EPlatform.Digital_Unix;  
        }else if (isFreeBSD()) {  
            _instance.platform = EPlatform.FreeBSD;  
        }else if (isHPUX()) {  
            _instance.platform = EPlatform.HP_UX;  
        }else if (isIrix()) {  
            _instance.platform = EPlatform.Irix;  
        }else if (isLinux()) {  
            _instance.platform = EPlatform.Linux;  
        }else if (isMacOS()) {  
            _instance.platform = EPlatform.Mac_OS;  
        }else if (isMacOSX()) {  
            _instance.platform = EPlatform.Mac_OS_X;  
        }else if (isMPEiX()) {  
            _instance.platform = EPlatform.MPEiX;  
        }else if (isNetWare()) {  
            _instance.platform = EPlatform.NetWare_411;  
        }else if (isOpenVMS()) {  
            _instance.platform = EPlatform.OpenVMS;  
        }else if (isOS2()) {  
            _instance.platform = EPlatform.OS2;  
        }else if (isOS390()) {  
            _instance.platform = EPlatform.OS390;  
        }else if (isOSF1()) {  
            _instance.platform = EPlatform.OSF1;  
        }else if (isSolaris()) {  
            _instance.platform = EPlatform.Solaris;  
        }else if (isSunOS()) {  
            _instance.platform = EPlatform.SunOS;  
        }else if (isWindows()) {  
            _instance.platform = EPlatform.Windows;  
        }else{  
            _instance.platform = EPlatform.Others;  
        }  
        return _instance.platform;  
    }  
}  







