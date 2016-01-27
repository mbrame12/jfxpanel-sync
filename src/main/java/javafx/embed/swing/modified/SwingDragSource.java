/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package javafx.embed.swing.modified;

import com.sun.javafx.embed.EmbeddedSceneDSInterface;
import com.sun.javafx.tk.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javafx.scene.input.TransferMode;

/**
 * This file was copied from the javafx.embed.swing package on January 27, 2016, 
 * but otherwise was not modified.
 * Drag source to deliver data from Swing environment to embedded FX scene.
 */
final class SwingDragSource extends CachingTransferable implements EmbeddedSceneDSInterface {

    private int sourceActions;

    SwingDragSource() {
    }
    
    void updateContents(final DropTargetDragEvent e, boolean fetchData) {
        sourceActions = e.getSourceActions();
        updateData(e.getTransferable(), fetchData);
    }

    void updateContents(final DropTargetDropEvent e, boolean fetchData) {
        sourceActions = e.getSourceActions();
        updateData(e.getTransferable(), fetchData);
    }

    @Override
    public Set<TransferMode> getSupportedActions() {
        assert Toolkit.getToolkit().isFxUserThread();
        return SwingDnD.dropActionsToTransferModes(sourceActions);
    }

    @Override
    public void dragDropEnd(TransferMode performedAction) {
        throw new UnsupportedOperationException();                
    }
}
