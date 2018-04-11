

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class ViewComplaints extends javax.swing.JFrame {

    /**
     * Creates new form ViewComplaints
     * @param user
     */
    private User user = null;
    ArrayList<Complaint> complaintList;
    static int index = 0;
    public ViewComplaints(User user) {
        initComponents();
        this.user = user;
        index = 0;
//        descriptionPanel.setLayout(new BoxLayout(descriptionPanel,BoxLayout.Y_AXIS));
//        locationPanel.setLayout(new BoxLayout(locationPanel,BoxLayout.Y_AXIS));
//        typePanel.setLayout(new BoxLayout(typePanel,BoxLayout.Y_AXIS));
//        toolsPanel.setLayout(new BoxLayout(toolsPanel,BoxLayout.Y_AXIS));
//        workerNamesPanel.setLayout(new BoxLayout(workerNamesPanel,BoxLayout.Y_AXIS));
//        workerNumbersPanel.setLayout(new BoxLayout(workerNumbersPanel,BoxLayout.Y_AXIS));
//        serialPanel.setLayout(new BoxLayout(serialPanel,BoxLayout.Y_AXIS));
//        Font font = new Font("Ubuntu",Font.BOLD,18);
//        JLabel serialHeading = new JLabel("Sr. No.",JLabel.CENTER);
//        serialHeading.setToolTipText(serialHeading.getText());
//        serialHeading.setFont(font);
//        JLabel descriptionHeading = new JLabel("Complaint Description",JLabel.CENTER);
//        descriptionHeading.setToolTipText(descriptionHeading.getText());
//        descriptionHeading.setFont(font);
//        JLabel locationHeading = new JLabel("Location",JLabel.CENTER);
//        locationHeading.setToolTipText(locationHeading.getText());
//        locationHeading.setFont(font);
//        JLabel typeHeading = new JLabel("Type of Work",JLabel.CENTER);
//        typeHeading.setFont(font);
//        typeHeading.setToolTipText(typeHeading.getText());
//        JLabel toolsHeading = new JLabel("Required Tools",JLabel.CENTER);
//        toolsHeading.setFont(font);
//        toolsHeading.setToolTipText(toolsHeading.getText());
//        JLabel workerNamesHeading = new JLabel("Worker name",JLabel.CENTER);
//        workerNamesHeading.setFont(font);
//        workerNamesHeading.setToolTipText(workerNamesHeading.getText());
//        JLabel workerNumbersHeading = new JLabel("Worker Contact",JLabel.CENTER);
//        workerNumbersHeading.setToolTipText(workerNumbersHeading.getText());
//        workerNumbersHeading.setFont(font);
//        serialPanel.add(serialHeading);
//        descriptionPanel.add(descriptionHeading);
//        locationPanel.add(locationHeading);
//        typePanel.add(typeHeading);
//        toolsPanel.add(toolsHeading);
//        workerNamesPanel.add(workerNamesHeading);
//        workerNumbersPanel.add(workerNumbersHeading);
//        complaintList = ComplaintDatabase.getComplaintDataByUserId(user.getLoginId());
//        boolean listIsEmpty = complaintList.isEmpty();
//        if(listIsEmpty){
//            this.alert.setVisible(true);
//        }
//        else{
//            JTextArea[] serialNumbers = new JTextArea[complaintList.size()];
//            JTextArea[] descriptions = new JTextArea[complaintList.size()];
//            JTextArea[] locations = new JTextArea[complaintList.size()];
//            JTextArea[] types = new JTextArea[complaintList.size()];
//            JTextArea[] tools = new JTextArea[complaintList.size()];
//            JTextArea[] workerNames = new JTextArea[complaintList.size()];
//            JTextArea[] workerNumbers  = new JTextArea[complaintList.size()];
//            for(int i=0;i<complaintList.size();i++){
////                index = i;
//                serialNumbers[i] = new JTextArea(""+(i+1));
//                serialNumbers[i].setEditable(false);
//                serialNumbers[i].setToolTipText(serialNumbers[i].getText());
//                serialNumbers[i].setLineWrap(true);
//                serialNumbers[i].setWrapStyleWord(true);
//                serialPanel.add(serialNumbers[i]);
//                descriptions[i] = new JTextArea(complaintList.get(i).complaintDescription);
//                descriptions[i].setEditable(false);
//                descriptions[i].setToolTipText(descriptions[i].getText());
//                descriptionPanel.add(descriptions[i]);
//                locations[i] = new JTextArea(complaintList.get(i).location);
//                locations[i].setEditable(false);
//                locations[i].setToolTipText(locations[i].getText());
//                locationPanel.add(locations[i]);
//                types[i] = new JTextArea(complaintList.get(i).typeOfWork);
//                types[i].setEditable(false);
//                types[i].setToolTipText(types[i].getText());
//                typePanel.add(types[i]);
//                tools[i] = new JTextArea(complaintList.get(i).toolsRequired);
//                tools[i].setEditable(false);
//                tools[i].setToolTipText(tools[i].getText());
//                toolsPanel.add(tools[i]);
//                if(complaintList.get(i).assignedWorker != null){
//                    workerNames[i] = new JTextArea(complaintList.get(i).assignedWorker.name);
//                    workerNumbers[i] = new JTextArea(complaintList.get(i).assignedWorker.contactNumber);
//                }
//                else{
//                    workerNames[i] = new JTextArea("Not yet assigned");
//                    workerNumbers[i] = new JTextArea("Not yet assigned");
//                }
//                workerNames[i].setEditable(false);
//                workerNames[i].setToolTipText(workerNames[i].getText());
//                workerNumbers[i].setEditable(false);
//                workerNamesPanel.add(workerNames[i]);
//                workerNumbersPanel.add(workerNumbers[i],JPanel.CENTER_ALIGNMENT);
//            }
//        }
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        if(listIsEmpty){
//            this.alert.setVisible(true);
//            this.deleteButton.setEnabled(false);
//        }
        complaintList = ComplaintDatabase.getComplaintDataByUserId(user.getLoginId());
        boolean listIsEmpty = complaintList.isEmpty();
        if(listIsEmpty){
            this.alert.setVisible(true);
            this.message.setEditable(false);
            this.send.setEnabled(false);
            this.next.setEnabled(false);
            this.previous.setEnabled(false);
        }
        else{
            this.previous.setEnabled(false);
            if(index == complaintList.size()-1){
                this.next.setEnabled(false);
            }
            this.complaintDescription.setText(complaintList.get(index).complaintDescription);
            this.location.setText(complaintList.get(index).location);
            this.typeOfWork.setText(complaintList.get(index).typeOfWork);
            this.toolsRequired.setText(complaintList.get(index).toolsRequired);
            if(complaintList.get(index).assignedWorker == null){
                this.workerName.setText("Not yet assigned");
                this.workerNumber.setText("Not yet assigned");
                this.message.setEditable(false);
                this.send.setEnabled(false);
            }
            else{
                this.message.setEditable(true);
                this.send.setEnabled(true);
                this.workerName.setText(complaintList.get(index).assignedWorker.name);
                this.workerNumber.setText(complaintList.get(index).assignedWorker.contactNumber);
            }
            if(!complaintList.get(index).getMessage().equals("null")){
                String[] messages = complaintList.get(index).getMessage().split("_");
                for(int i=1;i<messages.length;i++){
                    this.chat.setText(this.chat.getText() + messages[i] + "\n");
                } 
            }
        }
        this.complaintDescription.setEditable(false);
        this.location.setEditable(false);
        this.typeOfWork.setEditable(false);
        this.toolsRequired.setEditable(false);
        this.chat.setEditable(false);
        this.workerName.setEditable(false);
        this.workerNumber.setEditable(false);
    }
    public void deleteComplaint(Complaint complaint,int i){
        try{
        ComplaintDatabase.deleteComplaint(complaintList.get(i));
        this.successDelete.setVisible(true);
        } catch(Exception ex){
            System.out.println("Error in deleteComplaint");
        }
        ViewComplaints viewComplaints = new ViewComplaints(user);
        this.setVisible(false);
        viewComplaints.setVisible(true);
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
        deleteFrame = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        deleteIndex = new javax.swing.JTextField();
        deleteConfirm = new javax.swing.JButton();
        parseAlert = new javax.swing.JFrame();
        parseAlertMsg = new javax.swing.JLabel();
        successDelete = new javax.swing.JFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        complaintDescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        typeOfWork = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        toolsRequired = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        workerName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        workerNumber = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        chat = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        send = new javax.swing.JButton();

        alert.setTitle("No complaints!");
        alert.setAlwaysOnTop(true);
        alert.setSize(new java.awt.Dimension(300, 100));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert-icon-red-outline (1).png"))); // NOI18N
        jLabel2.setText("You have no complaints!");

        javax.swing.GroupLayout alertLayout = new javax.swing.GroupLayout(alert.getContentPane());
        alert.getContentPane().setLayout(alertLayout);
        alertLayout.setHorizontalGroup(
            alertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        alertLayout.setVerticalGroup(
            alertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        deleteFrame.setTitle("Delete Complaint");
        deleteFrame.setSize(new java.awt.Dimension(600, 400));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enter Serial Number of complaint you wish to delete");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Serial Number: ");

        deleteConfirm.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        deleteConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete (1).png"))); // NOI18N
        deleteConfirm.setText("Delete");
        deleteConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteFrameLayout = new javax.swing.GroupLayout(deleteFrame.getContentPane());
        deleteFrame.getContentPane().setLayout(deleteFrameLayout);
        deleteFrameLayout.setHorizontalGroup(
            deleteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(deleteFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(deleteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteConfirm)
                    .addGroup(deleteFrameLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(57, 57, 57)
                        .addComponent(deleteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        deleteFrameLayout.setVerticalGroup(
            deleteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(deleteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(deleteIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(deleteConfirm)
                .addGap(39, 39, 39))
        );

        parseAlert.setTitle("Error!");
        parseAlert.setSize(new java.awt.Dimension(500, 100));

        parseAlertMsg.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        parseAlertMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parseAlertMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alert-icon-red-outline (1).png"))); // NOI18N
        parseAlertMsg.setText("Please enter valid index from 1 to ");

        javax.swing.GroupLayout parseAlertLayout = new javax.swing.GroupLayout(parseAlert.getContentPane());
        parseAlert.getContentPane().setLayout(parseAlertLayout);
        parseAlertLayout.setHorizontalGroup(
            parseAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parseAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parseAlertMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        parseAlertLayout.setVerticalGroup(
            parseAlertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parseAlertLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parseAlertMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        successDelete.setTitle("Success");
        successDelete.setAlwaysOnTop(true);
        successDelete.setSize(new java.awt.Dimension(300, 100));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/success (1).png"))); // NOI18N
        jLabel5.setText("Successfully deleted complaint!");

        javax.swing.GroupLayout successDeleteLayout = new javax.swing.GroupLayout(successDelete.getContentPane());
        successDelete.getContentPane().setLayout(successDeleteLayout);
        successDeleteLayout.setHorizontalGroup(
            successDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        successDeleteLayout.setVerticalGroup(
            successDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(successDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View your Complaints");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Complaints");

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete (1).png"))); // NOI18N
        deleteButton.setText("Delete Complaint");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addComponent(deleteButton)
                .addGap(195, 195, 195)
                .addComponent(previous)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(84, 84, 84))
        );

        backPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {next, previous});

        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(previous)
                    .addComponent(next))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        goBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back (1).png"))); // NOI18N
        goBackButton.setText("Go Back");
        goBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Complaint Description");

        complaintDescription.setColumns(20);
        complaintDescription.setRows(5);
        jScrollPane1.setViewportView(complaintDescription);

        jLabel7.setText("Location");

        jLabel8.setText("Type of Work");

        jLabel9.setText("Tools Required");

        toolsRequired.setColumns(20);
        toolsRequired.setRows(5);
        jScrollPane2.setViewportView(toolsRequired);

        jLabel10.setText("Assigned Worker Name");

        jLabel11.setText("Worker Contact Number");

        workerNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workerNumberActionPerformed(evt);
            }
        });

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
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(location)
                    .addComponent(typeOfWork, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(167, 167, 167)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(workerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workerName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(message)
                        .addGap(18, 18, 18)
                        .addComponent(send)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {workerName, workerNumber});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(workerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(workerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(typeOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(send))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goBackButton)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(394, 394, 394))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBackButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        UserInterface userInterface = new UserInterface(user);
        this.setVisible(false);
        userInterface.setVisible(true);
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
//        this.deleteFrame.setVisible(true);
        deleteComplaint(complaintList.get(index),index);
        this.deleteFrame.setVisible(false);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void deleteConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteConfirmActionPerformed
        // TODO add your handling code here:
        try{
            int index = Integer.parseInt(this.deleteIndex.getText());
            index--;
            if(index <0 || index >= complaintList.size()){
                this.parseAlertMsg.setText("Please enter a valid index from 1 to "+complaintList.size());
                this.parseAlert.setVisible(true);
            }
            else{
                deleteComplaint(complaintList.get(index),index);
                this.deleteFrame.setVisible(false);
            }
            
            
        }
        catch(NumberFormatException numEx){
            this.parseAlertMsg.setText("Please enter a valid index from 1 to "+complaintList.size());
            this.parseAlert.setVisible(true);
        }
    }//GEN-LAST:event_deleteConfirmActionPerformed

    private void workerNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workerNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workerNumberActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        index++;
        this.previous.setEnabled(true);
        if(index == complaintList.size()-1){
            this.next.setEnabled(false);
        }
        this.complaintDescription.setText(complaintList.get(index).complaintDescription);
        this.location.setText(complaintList.get(index).location);
        this.typeOfWork.setText(complaintList.get(index).typeOfWork);
        this.toolsRequired.setText(complaintList.get(index).toolsRequired);
        if(complaintList.get(index).assignedWorker == null){
            this.workerName.setText("Not yet assigned");
            this.workerNumber.setText("Not yet assigned");
            this.message.setEditable(false);
            this.send.setEnabled(false);
        }
        else{
            this.message.setEditable(true);
            this.send.setEnabled(true);
            this.workerName.setText(complaintList.get(index).assignedWorker.name);
            this.workerNumber.setText(complaintList.get(index).assignedWorker.contactNumber);
        }
        this.chat.setText("");
        if(!complaintList.get(index).getMessage().equals("null")){
            String[] messages = complaintList.get(index).getMessage().split("_");
            for (int i=1;i<messages.length;i++) {
                this.chat.setText(this.chat.getText() + messages[i] + "\n");
            }
        }
    }//GEN-LAST:event_nextActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        if(!this.message.getText().equals("")){
            String newMessage = complaintList.get(index).getMessage() + "_User: " + this.message.getText();
            ComplaintDatabase.updateMessage(newMessage, complaintList.get(index).complaintId);
            String[] newMessages = newMessage.split("_");
            this.chat.setText("");
            for (int i=1;i<newMessages.length;i++) {
                this.chat.setText(this.chat.getText()+ newMessages[i] + "\n");
            }
        }
        
    }//GEN-LAST:event_sendActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        // TODO add your handling code here:
        index--;
        this.next.setEnabled(true);
        if(index == 0){
            this.previous.setEnabled(false);
        }
        this.complaintDescription.setText(complaintList.get(index).complaintDescription);
        this.location.setText(complaintList.get(index).location);
        this.typeOfWork.setText(complaintList.get(index).typeOfWork);
        this.toolsRequired.setText(complaintList.get(index).toolsRequired);
        if(complaintList.get(index).assignedWorker == null){
            this.workerName.setText("Not yet assigned");
            this.workerNumber.setText("Not yet assigned");
            this.message.setEditable(false);
            this.send.setEnabled(false);
        }
        else{
            this.message.setEditable(true);
            this.send.setEnabled(true);
            this.workerName.setText(complaintList.get(index).assignedWorker.name);
            this.workerNumber.setText(complaintList.get(index).assignedWorker.contactNumber);
        }
        this.chat.setText("");
        if(!complaintList.get(index).getMessage().equals("null")){
            String[] messages = complaintList.get(index).getMessage().split("_");
            for (int i=1;i<messages.length;i++) {
                this.chat.setText(this.chat.getText() + messages[i] + "\n");
            }
        }
    }//GEN-LAST:event_previousActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame alert;
    private javax.swing.JPanel backPanel;
    private javax.swing.JTextArea chat;
    private javax.swing.JTextArea complaintDescription;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteConfirm;
    private javax.swing.JFrame deleteFrame;
    private javax.swing.JTextField deleteIndex;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField location;
    private javax.swing.JTextField message;
    private javax.swing.JButton next;
    private javax.swing.JFrame parseAlert;
    private javax.swing.JLabel parseAlertMsg;
    private javax.swing.JButton previous;
    private javax.swing.JButton send;
    private javax.swing.JFrame successDelete;
    private javax.swing.JTextArea toolsRequired;
    private javax.swing.JTextField typeOfWork;
    private javax.swing.JTextField workerName;
    private javax.swing.JTextField workerNumber;
    // End of variables declaration//GEN-END:variables
}
