/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.control;

/**
 *
 * @author guilherme
 */
public class ChemisToolsControl {

    public static final int B = 1;
    public static final int KB = 1024;
    public static final int MB = 1024 * 1024;
    
    public static Runtime runtime = Runtime.getRuntime();

    public static long getUsedMemory(int unit) {
        return (runtime.totalMemory() - runtime.freeMemory()) / unit;
    }

    public static long getFreeMemory(int unit) {
        return runtime.freeMemory() / unit;
    }

    public static long getTotalMemory(int unit) {
        return runtime.totalMemory() / unit;
    }

    public static long getMaxMemory(int unit) {
        return runtime.maxMemory() / unit;
    }
}
