/**
 *  Copyright 2009 Sorbonne Universités, Université Pierre & Marie Curie - CNRS UMR 7606 (LIP6/MoVe)
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Initial contributor:
 *    Lom Messan Hillah - <lom-messan.hillah@lip6.fr>
 *
 *  Mailing list:
 *    lom-messan.hillah@lip6.fr
 */
/**
 * 
 */
package fr.lip6.move.pnml.framework.utils.exception;

/**
 * @author ggiffo
 * 
 */
public class OtherException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5114501298915071406L;

    /**
     * 
     */
    public OtherException() {
        super();
    }

    /**
     * @param message .
     */
    public OtherException(String message) {
        super(message);
    }

    /**
     * @param cause .
     */
    public OtherException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message .
     * @param cause .
     */
    public OtherException(String message, Throwable cause) {
        super(message, cause);
    }

}
