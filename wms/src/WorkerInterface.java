
import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saketh
 */
public class WorkerInterface extends javax.swing.JFrame {

    /**
     * Creates new form WorkerInterface
     * @param worker
     */
    private Worker worker = null;
    public WorkerInterface(Worker worker) {
        initComponents();
        this.welcomeLabel.setText(this.welcomeLabel.getText()+" "+worker.name);
        this.worker = worker;
        worker.setPendingComplaints();
        this.pendingComplaintLabel.setText("You have "+worker.pendingComplaints+" pending complaints!");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        contactNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        deleteAlert = new javax.swing.JFrame();
        jLabel6 = new javax.swing.JLabel();
        deleteErrorAlert = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        blankDetailsAlert = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        numberAlert = new javax.swing.JFrame();
        jLabel9 = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        scheduleButton = new javax.swing.JButton();
        viewProfileButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        pendingComplaintLabel = new javax.swing.JLabel();

        profile.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        profile.setTitle("Worker");
        profile.setSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Profile");

        jLabel2.setText("Name");

        jLabel3.setText("Contact Number");

        jLabel4.setText("Working Location");

        jLabel5.setText("Type of Work");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electical", "Plumbing", "Sweeping", "Civil/Maintenance", " " }));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit(1).png"))); // NOI18N
        editButton.setText("Edit");
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save (1).png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        goBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back (1).png"))); // NOI18N
        goBackButton.setText("Go Back");
        goBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete (1).png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile.getContentPane());
        profile.getContentPane().setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(profileLayout.createSequentialGroup()
                        .addContainerGap(125, Short.MAX_VALUE)
                        .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(profileLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name))
                            .addGroup(profileLayout.createSequentialGroup()
                                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(contactNumber)
                                    .addComponent(location)
                                    .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(goBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        profileLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {contactNumber, location, name, type});

        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBackButton)
                .addGap(19, 19, 19))
        );

        deleteAlert.setAlwaysOnTop(true);
        deleteAlert.setSize(new java.awt.Dimension(300, 100));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/success (1).png"))); // NOI18N
        jLabel6.setText("Account deleted Successfully!");

        javax.swing.GroupLayout deleteAlertLayout = new javax.swing.GroupLayout(deleteAlert.getContentPane());
        deleteAlert.getContentPane().setLayout(deleteAlertLayout);
        deleteAlertLayout.setHorizontalGroup(
            deleteAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        deleteAlertLayout.setVerticalGroup(
            deleteAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        deleteErrorAlert.setAlwaysOnTop(true);
        deleteErrorAlert.setSize(new java.awt.Dimension(300, 100));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert-icon-red-outline (1).png"))); // NOI18N
        jLabel7.setText("Error in deleting account!");

        javax.swing.GroupLayout deleteErrorAlertLayout = new javax.swing.GroupLayout(deleteErrorAlert.getContentPane());
        deleteErrorAlert.getContentPane().setLayout(deleteErrorAlertLayout);
        deleteErrorAlertLayout.setHorizontalGroup(
            deleteErrorAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteErrorAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        deleteErrorAlertLayout.setVerticalGroup(
            deleteErrorAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteErrorAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        blankDetailsAlert.setPreferredSize(new java.awt.Dimension(300, 100));
        blankDetailsAlert.setSize(new java.awt.Dimension(300, 100));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert-icon-red-outline (1).png"))); // NOI18N
        jLabel8.setText("Please enter all details!");

        javax.swing.GroupLayout blankDetailsAlertLayout = new javax.swing.GroupLayout(blankDetailsAlert.getContentPane());
        blankDetailsAlert.getContentPane().setLayout(blankDetailsAlertLayout);
        blankDetailsAlertLayout.setHorizontalGroup(
            blankDetailsAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blankDetailsAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        blankDetailsAlertLayout.setVerticalGroup(
            blankDetailsAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blankDetailsAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        numberAlert.setPreferredSize(new java.awt.Dimension(300, 100));
        numberAlert.setSize(new java.awt.Dimension(300, 100));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert-icon-red-outline (1).png"))); // NOI18N
        jLabel9.setText("Enter valid phone number!");

        javax.swing.GroupLayout numberAlertLayout = new javax.swing.GroupLayout(numberAlert.getContentPane());
        numberAlert.getContentPane().setLayout(numberAlertLayout);
        numberAlertLayout.setHorizontalGroup(
            numberAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numberAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        numberAlertLayout.setVerticalGroup(
            numberAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numberAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Worker Interface");

        welcomeLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome !");

        scheduleButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        scheduleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view (1) (1) (1).png"))); // NOI18N
        scheduleButton.setText("View Schedule");
        scheduleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        viewProfileButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        viewProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile (1) (1).png"))); // NOI18N
        viewProfileButton.setText("View Profile");
        viewProfileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfileButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout (1).jpeg"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        pendingComplaintLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        pendingComplaintLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendingComplaintLabel.setText("You have # pending complaints!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pendingComplaintLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pendingComplaintLabel)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(scheduleButton)
                .addGap(12, 12, 12)
                .addComponent(viewProfileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        WorkerLogin workerLogin = new WorkerLogin();
        this.setVisible(false);
        workerLogin.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void viewProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProfileButtonActionPerformed
        // TODO add your handling code here:
        this.name.setText(worker.name);
        this.contactNumber.setText(worker.contactNumber);
        this.location.setText(worker.location);
        this.type.setSelectedItem(worker.typeOfWork);
        this.name.setEditable(false);
        this.contactNumber.setEditable(false);
        this.location.setEditable(false);
        this.type.setEditable(false);
        this.type.setEnabled(false);
        this.saveButton.setEnabled(false);
        this.profile.setVisible(true);
    }//GEN-LAST:event_viewProfileButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        this.name.setEditable(true);
        this.contactNumber.setEditable(true);
        this.location.setEditable(true);
        this.type.setEnabled(true);
        this.type.setEditable(true);
        this.saveButton.setEnabled(true);
        this.editButton.setEnabled(false);
    }//GEN-LAST:event_editButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:
        this.profile.setVisible(false);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        int state = validDetails(this.name.getText(),this.contactNumber.getText(),this.location.getText());
        if(state==0){
            Worker modifyWorker = new Worker(this.name.getText(),this.contactNumber.getText(),this.location.getText(),this.type.getSelectedItem().toString(),worker.getLoginId(),worker.getLoginPassword());
            WorkerDatabase.modifyWorkerData(modifyWorker);
            this.saveButton.setEnabled(false);
            this.name.setEditable(false);
            this.contactNumber.setEditable(false);
            this.location.setEditable(false);
            this.type.setEditable(false);
            this.editButton.setEnabled(true);
            worker = WorkerDatabase.getWorkerData(worker.getLoginId());
            this.name.setText(worker.name);
            this.contactNumber.setText(worker.contactNumber);
            this.location.setText(worker.location);
            this.type.setSelectedItem(worker.typeOfWork);
            this.welcomeLabel.setText("Welcome! "+worker.name);
        }
        else if(state == 1){
            this.blankDetailsAlert.setVisible(true);
        }
        else if(state ==2){
            this.numberAlert.setVisible(true);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    public int validDetails(String name, String contactNumber,String location)
    {
        if(name.equals("") || contactNumber.equals("") || location.equals(""))
            return 1;
        else{
            try{
                int x = Integer.parseInt(contactNumber);
                return 0;
            }
            catch(NumberFormatException nfx){
                return 2;
            }
        }
    }
    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        // TODO add your handling code here:
        Schedule schedule = new Schedule(worker);
        ViewSchedule viewSchedule = new ViewSchedule(schedule);
        this.setVisible(false);
        viewSchedule.setVisible(true);
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        ArrayList<Complaint> complaintList = ComplaintDatabase.getComplaintDataByWorkerId(worker.getLoginId());
        if(WorkerDatabase.deleteWorker(worker)){
            this.deleteAlert.setVisible(true);
        }
        else{
            this.deleteErrorAlert.setVisible(true);
        }
        if(!complaintList.isEmpty()){
            for(int i=0;i<complaintList.size();i++){
                ComplaintDatabase.updateAssignedWorker("null", complaintList.get(i).complaintId);
                complaintList.get(i).assignWorker();
            }
        }
        WorkerLogin workerLogin = new WorkerLogin();
        this.setVisible(false);
        this.profile.setVisible(false);
        workerLogin.setVisible(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame blankDetailsAlert;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JFrame deleteAlert;
    private javax.swing.JButton deleteButton;
    private javax.swing.JFrame deleteErrorAlert;
    private javax.swing.JButton editButton;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField location;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField name;
    private javax.swing.JFrame numberAlert;
    private javax.swing.JLabel pendingComplaintLabel;
    private javax.swing.JFrame profile;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JButton viewProfileButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
