package org.flowkeeper.client.ui;

import java.awt.SystemTray;
import java.util.prefs.Preferences;

import org.flowkeeper.server.UserType;
import org.jdesktop.application.Action;
import org.jdesktop.beansbinding.AutoBinding;

/**
 *
 * 
 */
public class SettingsWindow extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2478438143076304627L;
	private final Preferences prefs = Preferences.userRoot().node("pomodoroServer");
    private final UserType user;

    private void storePreferences() {
        user.setPomodoroLength(Integer.parseInt(pomodoroLengthTextField.getText()));
        user.setBreakLength(Integer.parseInt(breakLengthTextField.getText()));

        prefs.put("autorun", autorunCheckBox.isSelected() ? "Y" : "N");
        prefs.put("timerSounds", soundsCheckBox.isSelected() ? "Y" : "N");
        prefs.put("updatesCheck", updatesCheckBox.isSelected() ? "Y" : "N");

        prefs.put("timerWindowMode", hideAllWindowsRadioButton.isSelected() ?
            "A" : (hideMainWindowRadioButton.isSelected() ? "M" : "N"));

        // TODO: Modify autorun
        
    }

    private void loadPreferences() {
        pomodoroLengthTextField.setText(user.getPomodoroLength().toString());
        breakLengthTextField.setText(user.getBreakLength().toString());

        autorunCheckBox.setSelected(prefs.get("autorun", "Y").equals("Y"));
        soundsCheckBox.setSelected(prefs.get("timerSounds", "Y").equals("Y"));
        updatesCheckBox.setSelected(prefs.get("updatesCheck", "Y").equals("Y"));

        String hideMode = SystemTray.isSupported() ? prefs.get("timerWindowMode", "M") : "N";
        timerWindowButtonGroup.setSelected(hideMainWindowRadioButton.getModel(), hideMode.equals("M"));
        timerWindowButtonGroup.setSelected(hideNoWindowsRadioButton.getModel(), hideMode.equals("N"));
        timerWindowButtonGroup.setSelected(hideAllWindowsRadioButton.getModel(), hideMode.equals("A"));

        if (!SystemTray.isSupported()) {
            hideMainWindowRadioButton.setEnabled(false);
            hideAllWindowsRadioButton.setEnabled(false);
        }
    }

    /** Creates new form SettingsWindow */
    public SettingsWindow(java.awt.Frame parent, boolean modal, UserType user) {
        super(parent, modal);
        this.user = user;
        initComponents();
        loadPreferences();
        getRootPane().setDefaultButton(saveButton);
        // TODO: Remove this as soon as autorun works
        autorunCheckBox.setVisible(false);
        Util.decorate(this, true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        timerWindowButtonGroup = new javax.swing.ButtonGroup();
        headerPanel = new javax.swing.JPanel();
        headerTextLabel = new javax.swing.JLabel();
        headerLogoLabel = new javax.swing.JLabel();
        pomodoroTechniquePanel = new javax.swing.JPanel();
        pomodoroLengthLabel = new javax.swing.JLabel();
        breakLengthLabel = new javax.swing.JLabel();
        pomodoroLengthTextField = new javax.swing.JFormattedTextField();
        breakLengthTextField = new javax.swing.JFormattedTextField();
        technicalSettingsPanel = new javax.swing.JPanel();
        autorunCheckBox = new javax.swing.JCheckBox();
        soundsCheckBox = new javax.swing.JCheckBox();
        hideMainWindowRadioButton = new javax.swing.JRadioButton();
        hideAllWindowsRadioButton = new javax.swing.JRadioButton();
        hideNoWindowsRadioButton = new javax.swing.JRadioButton();
        updatesCheckBox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        defaultsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.flowkeeper.client.ui.PomodoroClientApp.class).getContext().getResourceMap(SettingsWindow.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        headerPanel.setBackground(resourceMap.getColor("headerPanel.background")); // NOI18N
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("headerPanel.border.lineColor"))); // NOI18N
        headerPanel.setName("headerPanel"); // NOI18N

        headerTextLabel.setFont(headerTextLabel.getFont().deriveFont(headerTextLabel.getFont().getSize()+7f));
        headerTextLabel.setText(resourceMap.getString("headerTextLabel.text")); // NOI18N
        headerTextLabel.setName("headerTextLabel"); // NOI18N

        headerLogoLabel.setIcon(resourceMap.getIcon("headerLogoLabel.icon")); // NOI18N
        headerLogoLabel.setName("headerLogoLabel"); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerLogoLabel))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLogoLabel)
            .addComponent(headerTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        pomodoroTechniquePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("pomodoroTechniquePanel.border.title"))); // NOI18N
        pomodoroTechniquePanel.setName("pomodoroTechniquePanel"); // NOI18N

        pomodoroLengthLabel.setText(resourceMap.getString("pomodoroLengthLabel.text")); // NOI18N
        pomodoroLengthLabel.setName("pomodoroLengthLabel"); // NOI18N

        breakLengthLabel.setText(resourceMap.getString("breakLengthLabel.text")); // NOI18N
        breakLengthLabel.setName("breakLengthLabel"); // NOI18N

        pomodoroLengthTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pomodoroLengthTextField.setText(resourceMap.getString("pomodoroLengthTextField.text")); // NOI18N
        pomodoroLengthTextField.setName("pomodoroLengthTextField"); // NOI18N

        AutoBinding<Object, Object, Object, Object> binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, saveButton, org.jdesktop.beansbinding.ELProperty.create("${action}"), pomodoroLengthTextField, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        breakLengthTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        breakLengthTextField.setText(resourceMap.getString("breakLengthTextField.text")); // NOI18N
        breakLengthTextField.setName("breakLengthTextField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, saveButton, org.jdesktop.beansbinding.ELProperty.create("${action}"), breakLengthTextField, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pomodoroTechniquePanelLayout = new javax.swing.GroupLayout(pomodoroTechniquePanel);
        pomodoroTechniquePanel.setLayout(pomodoroTechniquePanelLayout);
        pomodoroTechniquePanelLayout.setHorizontalGroup(
            pomodoroTechniquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoroTechniquePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pomodoroTechniquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pomodoroLengthLabel)
                    .addComponent(breakLengthLabel))
                .addGap(18, 18, 18)
                .addGroup(pomodoroTechniquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(breakLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pomodoroLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pomodoroTechniquePanelLayout.setVerticalGroup(
            pomodoroTechniquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoroTechniquePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pomodoroTechniquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pomodoroLengthLabel)
                    .addComponent(pomodoroLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pomodoroTechniquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(breakLengthLabel)
                    .addComponent(breakLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        technicalSettingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("technicalSettingsPanel.border.title"))); // NOI18N
        technicalSettingsPanel.setName("technicalSettingsPanel"); // NOI18N

        autorunCheckBox.setSelected(true);
        autorunCheckBox.setText(resourceMap.getString("autorunCheckBox.text")); // NOI18N
        autorunCheckBox.setName("autorunCheckBox"); // NOI18N

        soundsCheckBox.setSelected(true);
        soundsCheckBox.setText(resourceMap.getString("soundsCheckBox.text")); // NOI18N
        soundsCheckBox.setName("soundsCheckBox"); // NOI18N

        timerWindowButtonGroup.add(hideMainWindowRadioButton);
        hideMainWindowRadioButton.setSelected(true);
        hideMainWindowRadioButton.setText(resourceMap.getString("hideMainWindowRadioButton.text")); // NOI18N
        hideMainWindowRadioButton.setName("hideMainWindowRadioButton"); // NOI18N

        timerWindowButtonGroup.add(hideAllWindowsRadioButton);
        hideAllWindowsRadioButton.setText(resourceMap.getString("hideAllWindowsRadioButton.text")); // NOI18N
        hideAllWindowsRadioButton.setName("hideAllWindowsRadioButton"); // NOI18N

        timerWindowButtonGroup.add(hideNoWindowsRadioButton);
        hideNoWindowsRadioButton.setText(resourceMap.getString("hideNoWindowsRadioButton.text")); // NOI18N
        hideNoWindowsRadioButton.setName("hideNoWindowsRadioButton"); // NOI18N

        updatesCheckBox.setSelected(true);
        updatesCheckBox.setText(resourceMap.getString("updatesCheckBox.text")); // NOI18N
        updatesCheckBox.setName("updatesCheckBox"); // NOI18N

        javax.swing.GroupLayout technicalSettingsPanelLayout = new javax.swing.GroupLayout(technicalSettingsPanel);
        technicalSettingsPanel.setLayout(technicalSettingsPanelLayout);
        technicalSettingsPanelLayout.setHorizontalGroup(
            technicalSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(technicalSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(technicalSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autorunCheckBox)
                    .addComponent(soundsCheckBox)
                    .addComponent(updatesCheckBox)
                    .addComponent(hideMainWindowRadioButton)
                    .addComponent(hideAllWindowsRadioButton)
                    .addComponent(hideNoWindowsRadioButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        technicalSettingsPanelLayout.setVerticalGroup(
            technicalSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(technicalSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(autorunCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(soundsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updatesCheckBox)
                .addGap(18, 18, 18)
                .addComponent(hideMainWindowRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hideAllWindowsRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hideNoWindowsRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(org.flowkeeper.client.ui.PomodoroClientApp.class).getContext().getActionMap(SettingsWindow.class, this);
        saveButton.setAction(actionMap.get("save")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N

        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        defaultsButton.setText(resourceMap.getString("defaultsButton.text")); // NOI18N
        defaultsButton.setName("defaultsButton"); // NOI18N
        defaultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(technicalSettingsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pomodoroTechniquePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(defaultsButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pomodoroTechniquePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(technicalSettingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(defaultsButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void defaultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultsButtonActionPerformed
        autorunCheckBox.setSelected(true);
        soundsCheckBox.setSelected(true);
        updatesCheckBox.setSelected(true);
        breakLengthTextField.setValue(5);
        pomodoroLengthTextField.setValue(25);
        hideAllWindowsRadioButton.setSelected(false);
        hideMainWindowRadioButton.setSelected(true);
        hideNoWindowsRadioButton.setSelected(false);
    }//GEN-LAST:event_defaultsButtonActionPerformed

    @Action
    public void save() {
        storePreferences();
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autorunCheckBox;
    private javax.swing.JLabel breakLengthLabel;
    private javax.swing.JFormattedTextField breakLengthTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton defaultsButton;
    private javax.swing.JLabel headerLogoLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel headerTextLabel;
    private javax.swing.JRadioButton hideAllWindowsRadioButton;
    private javax.swing.JRadioButton hideMainWindowRadioButton;
    private javax.swing.JRadioButton hideNoWindowsRadioButton;
    private javax.swing.JLabel pomodoroLengthLabel;
    private javax.swing.JFormattedTextField pomodoroLengthTextField;
    private javax.swing.JPanel pomodoroTechniquePanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox soundsCheckBox;
    private javax.swing.JPanel technicalSettingsPanel;
    private javax.swing.ButtonGroup timerWindowButtonGroup;
    private javax.swing.JCheckBox updatesCheckBox;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
