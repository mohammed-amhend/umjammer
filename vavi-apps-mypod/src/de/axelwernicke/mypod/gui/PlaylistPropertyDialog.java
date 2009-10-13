// PlaylistPropertyDialog
// $Id: PlaylistPropertyDialog.java,v 1.13 2003/07/20 06:46:17 axelwernicke Exp $
//
// Copyright (C) 2002-2003 Axel Wernicke <axel.wernicke@gmx.de>
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package de.axelwernicke.mypod.gui;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTree;
import javax.swing.tree.TreePath;


//import javax.swing.border.TitledBorder;

/**
 *
 * @author  axel wernicke
 */
public class PlaylistPropertyDialog extends javax.swing.JDialog {
    /** jdk1.4 logger */
//  private static Logger logger = Logger.getLogger("de.axelwernicke.mypod.gui");

    /** set to true, if dialog was closed with the ok button */
    private boolean confirmed = false;

    /** Creates new form PlaylistPropertyDialog
     * @param parent swing object
     * @param modal mode
     */
    public PlaylistPropertyDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(OkButton);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() //GEN-BEGIN:initComponents
     {
        java.awt.GridBagConstraints gridBagConstraints;

        splitPane = new javax.swing.JSplitPane();
        treeScrollPane = new javax.swing.JScrollPane();
        optionTree = new javax.swing.JTree();
        contentPanel = new javax.swing.JPanel();
        generalScrollPane = new javax.swing.JScrollPane();
        generalPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        syncCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        artistFilterPanel = new javax.swing.JPanel();
        artistSelectionPanel = new de.axelwernicke.mypod.gui.SelectionPanel();
        buttonPanel4 = new javax.swing.JPanel();
        enableArtistFilterCheckBox = new javax.swing.JCheckBox();
        genreFilterPanel = new javax.swing.JPanel();
        genreSelectionPanel = new de.axelwernicke.mypod.gui.SelectionPanel();
        buttonPanel2 = new javax.swing.JPanel();
        enableGenreFilterCheckBox = new javax.swing.JCheckBox();
        yearFilterPanel = new javax.swing.JPanel();
        yearSelectionPanel = new de.axelwernicke.mypod.gui.SelectionPanel();
        buttonPanel3 = new javax.swing.JPanel();
        enableYearFilterCheckBox = new javax.swing.JCheckBox();
        buttonPanel = new javax.swing.JPanel();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setTitle(GuiUtils.getStringLocalized("resource/language", "playlistProperties"));
        setName("PlaylistPropertyDialog");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    closeDialog(evt);
                }
            });

        splitPane.setDividerLocation(150);
        splitPane.setMinimumSize(new java.awt.Dimension(250, 100));
        splitPane.setPreferredSize(new java.awt.Dimension(500, 350));
        treeScrollPane.setMinimumSize(new java.awt.Dimension(145, 363));
        treeScrollPane.setPreferredSize(new java.awt.Dimension(145, 363));
        optionTree.setMinimumSize(new java.awt.Dimension(145, 72));
        optionTree.setPreferredSize(new java.awt.Dimension(145, 72));
        optionTree.setRootVisible(false);
        optionTree.setShowsRootHandles(true);
        optionTree.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    optionTreeMouseClicked(evt);
                }
            });
        optionTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
                public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                    optionTreeValueChanged(evt);
                }
            });

        treeScrollPane.setViewportView(optionTree);

        splitPane.setLeftComponent(treeScrollPane);

        contentPanel.setLayout(new java.awt.CardLayout());

        contentPanel.setPreferredSize(new java.awt.Dimension(350, 201));
        generalScrollPane.setBorder(null);
        generalPanel.setLayout(new java.awt.GridBagLayout());

        nameLabel.setForeground(new java.awt.Color(102, 102, 153));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameLabel.setText(GuiUtils.getStringLocalized("resource/language", "name:"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        generalPanel.add(nameLabel, gridBagConstraints);

        nameTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 0, 12);
        generalPanel.add(nameTextField, gridBagConstraints);

        syncCheckBox.setText(GuiUtils.getStringLocalized("resource/language", "syncWithIPod"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 0, 12);
        generalPanel.add(syncCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weighty = 0.1;
        generalPanel.add(jLabel1, gridBagConstraints);

        generalScrollPane.setViewportView(generalPanel);

        contentPanel.add(generalScrollPane, "generalCard");

        artistFilterPanel.setLayout(new java.awt.BorderLayout());

        artistFilterPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(2, 10, 2, 10)));
        artistFilterPanel.add(artistSelectionPanel, java.awt.BorderLayout.CENTER);

        enableArtistFilterCheckBox.setText(GuiUtils.getStringLocalized("resource/language", "enableFilter"));
        enableArtistFilterCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    enableArtistFilterCheckBoxStateChanged(evt);
                }
            });

        buttonPanel4.add(enableArtistFilterCheckBox);

        artistFilterPanel.add(buttonPanel4, java.awt.BorderLayout.SOUTH);

        contentPanel.add(artistFilterPanel, "artistFilterCard");

        genreFilterPanel.setLayout(new java.awt.BorderLayout());

        genreFilterPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(2, 10, 2, 10)));
        genreFilterPanel.add(genreSelectionPanel, java.awt.BorderLayout.CENTER);

        enableGenreFilterCheckBox.setText(GuiUtils.getStringLocalized("resource/language", "enableFilter"));
        enableGenreFilterCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    enableGenreFilterCheckBoxStateChanged(evt);
                }
            });

        buttonPanel2.add(enableGenreFilterCheckBox);

        genreFilterPanel.add(buttonPanel2, java.awt.BorderLayout.SOUTH);

        contentPanel.add(genreFilterPanel, "genreFilterCard");

        yearFilterPanel.setLayout(new java.awt.BorderLayout());

        yearFilterPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(2, 10, 2, 10)));
        yearFilterPanel.add(yearSelectionPanel, java.awt.BorderLayout.CENTER);

        enableYearFilterCheckBox.setText(GuiUtils.getStringLocalized("resource/language", "enableFilter"));
        enableYearFilterCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    enableYearFilterCheckBoxStateChanged(evt);
                }
            });

        buttonPanel3.add(enableYearFilterCheckBox);

        yearFilterPanel.add(buttonPanel3, java.awt.BorderLayout.SOUTH);

        contentPanel.add(yearFilterPanel, "yearFilterCard");

        splitPane.setRightComponent(contentPanel);

        getContentPane().add(splitPane, java.awt.BorderLayout.CENTER);

        OkButton.setText(GuiUtils.getStringLocalized("resource/language", "ok"));
        OkButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    OkButtonActionPerformed(evt);
                }
            });

        buttonPanel.add(OkButton);

        CancelButton.setText(GuiUtils.getStringLocalized("resource/language", "cancel"));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CancelButtonActionPerformed(evt);
                }
            });

        buttonPanel.add(CancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        pack();
    } //GEN-END:initComponents

    private void enableArtistFilterCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) //GEN-FIRST:event_enableArtistFilterCheckBoxStateChanged
     { //GEN-HEADEREND:event_enableArtistFilterCheckBoxStateChanged
        this.artistSelectionPanel.setEnabled(this.enableArtistFilterCheckBox.getModel().isSelected());
    } //GEN-LAST:event_enableArtistFilterCheckBoxStateChanged

    private void optionTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) //GEN-FIRST:event_optionTreeValueChanged
     { //GEN-HEADEREND:event_optionTreeValueChanged
        // get selected leaf
        try {
            TreePath tpath = evt.getNewLeadSelectionPath();
            String leaf = tpath.getLastPathComponent().toString();

            // show card selected
            showCard(leaf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //GEN-LAST:event_optionTreeValueChanged

    /**
     * @param evt
     */
    private void enableYearFilterCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) //GEN-FIRST:event_enableYearFilterCheckBoxStateChanged
     { //GEN-HEADEREND:event_enableYearFilterCheckBoxStateChanged
        this.yearSelectionPanel.setEnabled(this.enableYearFilterCheckBox.getModel().isSelected());
    } //GEN-LAST:event_enableYearFilterCheckBoxStateChanged

    /**
     * @param evt
     */
    private void enableGenreFilterCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) //GEN-FIRST:event_enableGenreFilterCheckBoxStateChanged
     { //GEN-HEADEREND:event_enableGenreFilterCheckBoxStateChanged
        this.genreSelectionPanel.setEnabled(this.enableGenreFilterCheckBox.getModel().isSelected());
    } //GEN-LAST:event_enableGenreFilterCheckBoxStateChanged

    /**
     * @param evt
     */
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) //GEN-FIRST:event_CancelButtonActionPerformed
     { //GEN-HEADEREND:event_CancelButtonActionPerformed
        setVisible(false);
    } //GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @param evt
     */
    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) //GEN-FIRST:event_OkButtonActionPerformed
     { //GEN-HEADEREND:event_OkButtonActionPerformed
        confirmed = true;
        setVisible(false);
    } //GEN-LAST:event_OkButtonActionPerformed

    /**
     * @param evt
     */
    private void optionTreeMouseClicked(java.awt.event.MouseEvent evt) //GEN-FIRST:event_optionTreeMouseClicked
     { //GEN-HEADEREND:event_optionTreeMouseClicked
        // determine which object was clicked
        try {
            JTree jtree = (JTree) evt.getSource();
            String leaf = jtree.getSelectionPath().getLastPathComponent().toString();

            showCard(leaf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //GEN-LAST:event_optionTreeMouseClicked

    /** Cancel the dialog
     * @param evt window closing event
     */
    private void closeDialog(java.awt.event.WindowEvent evt) { //GEN-FIRST:event_closeDialog
        setVisible(false);
    } //GEN-LAST:event_closeDialog

    /**
     * @param _name
     */
    public void setPlaylistName(String _name) {
        if (_name != null) {
            this.nameTextField.setText(_name);
        }
    }

    /**
     * @return
     */
    public String getPlaylistName() {
        return this.nameTextField.getText();
    }

    /**
     * @param _sync
     */
    public void setIPodSync(boolean _sync) {
        this.syncCheckBox.getModel().setSelected(_sync);
    }

    /**
     * @return
     */
    public boolean isIPodSync() {
        return this.syncCheckBox.getModel().isSelected();
    }

    /** Controls the enabling of the artist filter selection panel
     */
    public void setArtistFilterEnabled(boolean enabled) {
        this.enableArtistFilterCheckBox.getModel().setSelected(enabled);
        this.artistSelectionPanel.setEnabled(enabled);
    }

    /**
     * @return
     */
    public boolean isArtistFilterEnabled() {
        return this.enableArtistFilterCheckBox.getModel().isSelected();
    }

    /** Controls the enabling of the artist filter selection panel
     */
    public void setGenreFilterEnabled(boolean enabled) {
        this.enableGenreFilterCheckBox.getModel().setSelected(enabled);
        this.genreSelectionPanel.setEnabled(enabled);
    }

    /**
     * @return
     */
    public boolean isGenreFilterEnabled() {
        return this.enableGenreFilterCheckBox.getModel().isSelected();
    }

    /** Controls the enabling of the artist filter selection panel
     */
    public void setYearFilterEnabled(boolean enabled) {
        this.enableYearFilterCheckBox.getModel().setSelected(enabled);
        this.yearSelectionPanel.setEnabled(enabled);
    }

    /** Gets the status of the year filter
     * @return year filter enabled
     */
    public boolean isYearFilterEnabled() {
        return this.enableYearFilterCheckBox.getModel().isSelected();
    }

    /** Gets the confirmed flag
     * @return is confirmed
     */
    public boolean isConfirmed() {
        return this.confirmed;
    }

    /**
     * @param model
     */
    public void setArtistListModel(DefaultListModel model, List<String> selection) {
        this.artistSelectionPanel.setUnselectedListModel(model);
        this.artistSelectionPanel.select(selection);
    }

    /**
     * @param model
     */
    public void setGenreListModel(DefaultListModel model, List<String> selection) {
        this.genreSelectionPanel.setUnselectedListModel(model);
        this.genreSelectionPanel.select(selection);
    }

    /**
     * @param model
     */
    public void setYearListModel(DefaultListModel model, List<String> selection) {
        this.yearSelectionPanel.setUnselectedListModel(model);
        this.yearSelectionPanel.select(selection);
    }

    /** Gets the currently selected artists
     * @return selected entries
     */
    public List<String> getSelectedArtists() {
        return this.artistSelectionPanel.getSelection();
    }

    /** Gets the currently selected artists
     * @return selected entries
     */
    public List<String> getSelectedGenres() {
        return this.genreSelectionPanel.getSelection();
    }

    /** Gets the currently selected artists
     * @return selected entries
     */
    public List<String> getSelectedYears() {
        return this.yearSelectionPanel.getSelection();
    }

    /** bring card to front by name
     */
    private void showCard(String cardName) {
        // set property card
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();

        if (cardName.equals(GuiUtils.getStringLocalized("resource/language", "general"))) {
            contentPanel.repaint();
            cardLayout.show(this.contentPanel, "generalCard");
        } else if (cardName.equals(GuiUtils.getStringLocalized("resource/language", "view"))) {
            contentPanel.repaint();
            cardLayout.show(this.contentPanel, "viewCard");
        } else if (cardName.equals(GuiUtils.getStringLocalized("resource/language", "artist"))) {
            contentPanel.repaint();
            cardLayout.show(this.contentPanel, "artistFilterCard");
        } else if (cardName.equals(GuiUtils.getStringLocalized("resource/language", "genre"))) {
            contentPanel.repaint();
            cardLayout.show(this.contentPanel, "genreFilterCard");
        } else if (cardName.equals(GuiUtils.getStringLocalized("resource/language", "year"))) {
            contentPanel.repaint();
            cardLayout.show(this.contentPanel, "yearFilterCard");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton OkButton;
    private javax.swing.JPanel artistFilterPanel;
    private de.axelwernicke.mypod.gui.SelectionPanel artistSelectionPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel buttonPanel2;
    private javax.swing.JPanel buttonPanel3;
    private javax.swing.JPanel buttonPanel4;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JCheckBox enableArtistFilterCheckBox;
    private javax.swing.JCheckBox enableGenreFilterCheckBox;
    private javax.swing.JCheckBox enableYearFilterCheckBox;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JScrollPane generalScrollPane;
    private javax.swing.JPanel genreFilterPanel;
    private de.axelwernicke.mypod.gui.SelectionPanel genreSelectionPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    public javax.swing.JTree optionTree;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JCheckBox syncCheckBox;
    private javax.swing.JScrollPane treeScrollPane;
    private javax.swing.JPanel yearFilterPanel;
    private de.axelwernicke.mypod.gui.SelectionPanel yearSelectionPanel;

    // End of variables declaration//GEN-END:variables
}
