
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saketh
 */
public class ViewSchedule extends javax.swing.JFrame {

    /**
     * Creates new form ViewSchedule
     */
    private Schedule schedule = null;
    static int index = 0;
    ArrayList<Complaint> pendingComplaints;
    public ViewSchedule(Schedule schedule) {
        initComponents();
        this.schedule = schedule;
        index = 0;
//        serialPanel.setLayout(new BoxLayout(serialPanel,BoxLayout.Y_AXIS));
//        descriptionPanel.setLayout(new BoxLayout(descriptionPanel,BoxLayout.Y_AXIS));
//        locationPanel.setLayout(new BoxLayout(locationPanel,BoxLayout.Y_AXIS));
//        toolsPanel.setLayout(new BoxLayout(toolsPanel,BoxLayout.Y_AXIS));
//        userNamePanel.setLayout(new BoxLayout(userNamePanel,BoxLayout.Y_AXIS));
//        userContactNumberPanel.setLayout(new BoxLayout(userContactNumberPanel,BoxLayout.Y_AXIS));
//        Font font = new Font("Ubuntu",Font.BOLD,18);
//        JLabel serialHeading = new JLabel("Sr. No.");
//        serialHeading.setFont(font);
//        serialHeading.setToolTipText(serialHeading.getText());
//        JLabel descriptionHeading = new JLabel("Complaint Description");
//        descriptionHeading.setFont(font);
//        descriptionHeading.setToolTipText(descriptionHeading.getText());
//        JLabel locationHeading = new JLabel("Location");
//        locationHeading.setFont(font);
//        locationHeading.setToolTipText(locationHeading.getText());
//        JLabel toolsHeading = new JLabel("Tools Required");
//        toolsHeading.setFont(font);
//        toolsHeading.setToolTipText(toolsHeading.getText());
//        JLabel userNamesHeading = new JLabel("User Name");
//        userNamesHeading.setFont(font);
//        userNamesHeading.setToolTipText(userNamesHeading.getText());
//        JLabel userContactNumbersHeading = new JLabel("User Contact");
//        userContactNumbersHeading.setFont(font);
//        userContactNumbersHeading.setToolTipText(userContactNumbersHeading.getText());
//        serialPanel.add(serialHeading);
//        descriptionPanel.add(descriptionHeading);
//        locationPanel.add(locationHeading);
//        toolsPanel.add(toolsHeading);
//        userNamePanel.add(userNamesHeading);
//        userContactNumberPanel.add(userContactNumbersHeading);
//        ArrayList<Complaint> pendingComplaints = schedule.getPendingComplaints();
//        if(pendingComplaints.isEmpty()){
//            this.alert.setVisible(true);
//        }
//        else{
//            JTextArea[] serialNumbers = new JTextArea[pendingComplaints.size()];
//            JTextArea[] descriptions = new JTextArea[pendingComplaints.size()];
//            JTextArea[] locations = new JTextArea[pendingComplaints.size()];
//            JTextArea[] tools = new JTextArea[pendingComplaints.size()];
//            JTextArea[] userNames = new JTextArea[pendingComplaints.size()];
//            JTextArea[] userContactNumbers = new JTextArea[pendingComplaints.size()];
//            for(int i=0;i<pendingComplaints.size();i++){
//                serialNumbers[i] = new JTextArea(""+(i+1));
//                serialNumbers[i].setEditable(false);
//                serialNumbers[i].setToolTipText(serialNumbers[i].getText());
//                serialPanel.add(serialNumbers[i]);
//                descriptions[i] = new JTextArea(pendingComplaints.get(i).complaintDescription);
//                descriptions[i].setEditable(false);
//                descriptions[i].setToolTipText(descriptions[i].getText());
//                descriptionPanel.add(descriptions[i]);
//                locations[i] = new JTextArea(pendingComplaints.get(i).location);
//                locations[i].setEditable(false);
//                locations[i].setToolTipText(locations[i].getText());
//                locationPanel.add(locations[i]);
//                tools[i] = new JTextArea(pendingComplaints.get(i).toolsRequired);
//                tools[i].setEditable(false);
//                tools[i].setToolTipText(tools[i].getText());
//                toolsPanel.add(tools[i]);
//                userNames[i] = new JTextArea(pendingComplaints.get(i).getUserDetails().name);
//                userNames[i].setEditable(false);
//                userNames[i].setToolTipText(userNames[i].getText());
//                userNamePanel.add(userNames[i]);
//                userContactNumbers[i] = new JTextArea(pendingComplaints.get(i).getUserDetails().getContactNumber());
//                userContactNumbers[i].setEditable(false);
//                userContactNumbers[i].setToolTipText(userContactNumbers[i].getText());
//                userContactNumberPanel.add(userContactNumbers[i]);
//            }
//        }
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pendingComplaints = schedule.getPendingComplaints();
        if(pendingComplaints.isEmpty()){
            this.alert.setVisible(true);
            this.next.setEnabled(false);
            this.previous.setEnabled(false);
            this.message.setEditable(false);
            this.send.setEnabled(false);
        }
        else{
            this.previous.setEnabled(false);
            if(index == pendingComplaints.size() - 1){
                this.next.setEnabled(false);
            }
            this.complaintDescription.setText(pendingComplaints.get(index).complaintDescription);
            this.location.setText(pendingComplaints.get(index).location);
            this.toolsRequired.setText(pendingComplaints.get(index).toolsRequired);
            this.userName.setText(pendingComplaints.get(index).getUserDetails().name);
            this.userNumber.setText(pendingComplaints.get(index).getUserDetails().getContactNumber());
            if(!pendingComplaints.get(index).getMessage().equals("null")){
                String[] messages = pendingComplaints.get(index).getMessage().split("_");
                for(int i=1;i<messages.length;i++){
                    this.chat.setText(this.chat.getText() + messages[i] + "\n");
                }
            }
        }
        this.complaintDescription.setEditable(false);
        this.location.setEditable(false);
        this.toolsRequired.setEditable(false);
        this.userName.setEditable(false);
        this.userNumber.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alert = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        goBackButton = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        complaintDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        toolsRequired = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        userNumber = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        send = new javax.swing.JButton();

        alert.setTitle("No complaints!");
        alert.setAlwaysOnTop(true);
        alert.setSize(new java.awt.Dimension(300, 100));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert-icon-red-outline (1).png"))); // NOI18N
        jLabel2.setText("You have no pending complaints!");

        javax.swing.GroupLayout alertLayout = new javax.swing.GroupLayout(alert.getContentPane());
        alert.getContentPane().setLayout(alertLayout);
        alertLayout.setHorizontalGroup(
            alertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );
        alertLayout.setVerticalGroup(
            alertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View your Schedule");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Schedule");

        goBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back (1).png"))); // NOI18N
        goBackButton.setText("Go Back");
        goBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addComponent(goBackButton)
                .addGap(288, 288, 288)
                .addComponent(previous)
                .addGap(98, 98, 98)
                .addComponent(next)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        buttonPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {next, previous});

        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goBackButton)
                    .addComponent(previous)
                    .addComponent(next))
                .addContainerGap())
        );

        jLabel3.setText("Complaint Description");

        complaintDescription.setColumns(20);
        complaintDescription.setRows(5);
        jScrollPane1.setViewportView(complaintDescription);

        jLabel4.setText("Location");

        jLabel5.setText("Tools Required");

        toolsRequired.setColumns(20);
        toolsRequired.setRows(5);
        jScrollPane2.setViewportView(toolsRequired);

        jLabel6.setText("User Name");

        jLabel7.setText("User Contact Number");

        chat.setColumns(20);
        chat.setRows(5);
        jScrollPane3.setViewportView(chat);

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(200, 200, 200)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(message)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(send))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {userName, userNumber});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        WorkerInterface workerInterface = new WorkerInterface(schedule.getWorker());
        this.setVisible(false);
        this.alert.setVisible(false);
        workerInterface.setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        if(!this.message.getText().equals("")){
            String newMessage = pendingComplaints.get(index).getMessage() + "_Worker: "+this.message.getText();
            ComplaintDatabase.updateMessage(newMessage, pendingComplaints.get(index).complaintId);
            String[] newMessages = newMessage.split("_");
            this.chat.setText("");
            for(int i=1;i<newMessages.length;i++){
                this.chat.setText(this.chat.getText() + newMessages[i] + "\n");
            }
        }
    }//GEN-LAST:event_sendActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        // TODO add your handling code here:
        index--;
        this.next.setEnabled(true);
        if(index==0){
            this.previous.setEnabled(false);
        }
        this.complaintDescription.setText(pendingComplaints.get(index).complaintDescription);
        this.location.setText(pendingComplaints.get(index).location);
        this.toolsRequired.setText(pendingComplaints.get(index).toolsRequired);
        this.userName.setText(pendingComplaints.get(index).getUserDetails().name);
        this.userNumber.setText(pendingComplaints.get(index).getUserDetails().getContactNumber());
        this.chat.setText("");
        if(!pendingComplaints.get(index).getMessage().equals("null")){
            String[] messages = pendingComplaints.get(index).getMessage().split("_");
            for(int i=1;i<messages.length;i++){
                this.chat.setText(this.chat.getText() + messages[i] + "\n");
            }
        }
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        index++;
        this.previous.setEnabled(true);
        if(index == pendingComplaints.size() - 1){
            this.next.setEnabled(false);
        }
        this.complaintDescription.setText(pendingComplaints.get(index).complaintDescription);
        this.location.setText(pendingComplaints.get(index).location);
        this.toolsRequired.setText(pendingComplaints.get(index).toolsRequired);
        this.userName.setText(pendingComplaints.get(index).getUserDetails().name);
        this.userNumber.setText(pendingComplaints.get(index).getUserDetails().getContactNumber());
        this.chat.setText("");
        if(!pendingComplaints.get(index).getMessage().equals("null")){
            String[] messages = pendingComplaints.get(index).getMessage().split("_");
            for(int i=1;i<messages.length;i++){
                this.chat.setText(this.chat.getText() + messages[i] + "\n");
            }
        }
                
    }//GEN-LAST:event_nextActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame alert;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextArea chat;
    private javax.swing.JTextArea complaintDescription;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField location;
    private javax.swing.JTextField message;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    private javax.swing.JButton send;
    private javax.swing.JTextArea toolsRequired;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userNumber;
    // End of variables declaration//GEN-END:variables
}
