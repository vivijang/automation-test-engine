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
    
public final class OSinfo {
	
	/** The os. */
	@Nullable
    private static String osName = "";  
    
    /** The _instance. */
    private static OSinfo instance = new OSinfo();;  
    
    /** The platform. */
    private EPlatform platform ;
    
    /**
     * Instantiates a new osinfo.
     */
    private OSinfo(){
        osName = System.getProperty("os.name").toLowerCase();
    	platform = EPlatform.Others;
    }  
      
    /**
     * Checks if is linux.
     *
     * @return true, if is linux
     */
    public static boolean isLinux(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("linux")>=0;
		} 
		else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is mac os.
     *
     * @return true, if is mac os
     */
    public static boolean isMacOS(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("mac")>=0 && os2.indexOf("os")>0 && os2.indexOf("x")<0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is mac osx.
     *
     * @return true, if is mac osx
     */
    public static boolean isMacOSX(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("mac")>=0 && os2.indexOf("os")>0 && os2.indexOf("x")>0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is windows.
     *
     * @return true, if is windows
     */
    public static boolean isWindows(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("windows")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is os2.
     *
     * @return true, if is os2
     */
    public static boolean isOS2(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("os/2")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is solaris.
     *
     * @return true, if is solaris
     */
    public static boolean isSolaris(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("solaris")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is sun os.
     *
     * @return true, if is sun os
     */
    public static boolean isSunOS(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("sunos")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is MP eix.
     *
     * @return true, if is MP eix
     */
    public static boolean isMPEiX(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("mpe/ix")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is hpux.
     *
     * @return true, if is hpux
     */
    public static boolean isHPUX(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("hp-ux")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is aix.
     *
     * @return true, if is aix
     */
    public static boolean isAix(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("aix")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is o s390.
     *
     * @return true, if is o s390
     */
    public static boolean isOS390(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("os/390")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is free bsd.
     *
     * @return true, if is free bsd
     */
    public static boolean isFreeBSD(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("freebsd")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is irix.
     *
     * @return true, if is irix
     */
    public static boolean isIrix(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("irix")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is digital unix.
     *
     * @return true, if is digital unix
     */
    public static boolean isDigitalUnix(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("digital")>=0 && os2.indexOf("unix")>0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is netware.
     *
     * @return true, if is netware
     */
    public static boolean isNetWare(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("netware")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is OS f1.
     *
     * @return true, if is OS f1
     */
    public static boolean isOSF1(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("osf1")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     * Checks if is open vms.
     *
     * @return true, if is open vms
     */
    public static boolean isOpenVMS(){  
        final String os2 = osName;
		if (os2 != null) {
			return os2.indexOf("openvms")>=0;
		} else {
			// TODO handle null value
			throw new IllegalStateException("OS name is not correct");
		}  
    }  
      
    /**
     *  
     * Get the name of operating system .
     *
     * @return  the name of operating system
     */  
    public static EPlatform getOSname(){  
        if(isAix()){  
            instance.platform = EPlatform.AIX;  
        }else if (isDigitalUnix()) {  
            instance.platform = EPlatform.Digital_Unix;  
        }else if (isFreeBSD()) {  
            instance.platform = EPlatform.FreeBSD;  
        }else if (isHPUX()) {  
            instance.platform = EPlatform.HP_UX;  
        }else if (isIrix()) {  
            instance.platform = EPlatform.Irix;  
        }else if (isLinux()) {  
            instance.platform = EPlatform.Linux;  
        }else if (isMacOS()) {  
            instance.platform = EPlatform.Mac_OS;  
        }else if (isMacOSX()) {  
            instance.platform = EPlatform.Mac_OS_X;  
        }else if (isMPEiX()) {  
            instance.platform = EPlatform.MPEiX;  
        }else if (isNetWare()) {  
            instance.platform = EPlatform.NetWare_411;  
        }else if (isOpenVMS()) {  
            instance.platform = EPlatform.OpenVMS;  
        }else if (isOS2()) {  
            instance.platform = EPlatform.OS2;  
        }else if (isOS390()) {  
            instance.platform = EPlatform.OS390;  
        }else if (isOSF1()) {  
            instance.platform = EPlatform.OSF1;  
        }else if (isSolaris()) {  
            instance.platform = EPlatform.Solaris;  
        }else if (isSunOS()) {  
            instance.platform = EPlatform.SunOS;  
        }else if (isWindows()) {  
            instance.platform = EPlatform.Windows;  
        }else{  
            instance.platform = EPlatform.Others;  
        }  
        return instance.platform;  
    }  
}  







