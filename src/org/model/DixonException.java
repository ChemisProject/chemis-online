/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

/**
 *
 * @author guilherme
 */
public class DixonException extends Exception {

    public DixonException() {
        super();
    }

    public DixonException(String message) {
        super(message);
    }

    public DixonException(String message, Throwable cause) {
        super(message, cause);
    }

    public DixonException(Throwable cause) {
        super(cause);
    }
}
