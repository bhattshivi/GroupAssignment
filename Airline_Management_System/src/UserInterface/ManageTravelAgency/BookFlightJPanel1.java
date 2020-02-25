/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManageTravelAgency;

import Business.AirlinerDirectory;
import Business.Airplane;
import Business.AirplaneDirectory;
import Business.Customer;
import Business.CustomerDirectory;
import Business.Flight;
import Business.MasterTravelSchedule;
import Business.Reservation;
import Business.ReservationDirectory;
import Business.Seat;
import UserInterface.ManageAirliner.UpdateAirplane;
import java.awt.CardLayout;
import java.awt.Component;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivibhatt
 */
public class BookFlightJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form BookFlightJPanel
     */
    private JPanel panel;
    private AirlinerDirectory airlineDirectory;
    private MasterTravelSchedule masterTravelSchedule;
    private ArrayList<Flight> masterFlightList;
    private String searchTxtFlight;
    private String source;
    private String destination;
    private ArrayList<Flight> flightSelectedList;
    private CustomerDirectory custDir;
    private ReservationDirectory reservationDirectory;
    private Customer cust;
    private Reservation reservation;
    private AirplaneDirectory airplaneDirectory;
    private DefaultTableModel dtm;// = (DefaultTableModel) jTable1.getModel();
    private int indexCount;
   
    public BookFlightJPanel1(JPanel panel, AirlinerDirectory airlineDirectory, AirplaneDirectory airplaneDirectory, MasterTravelSchedule masterTravelSchedule, ArrayList<Flight> flightSelectedList, CustomerDirectory custDir, Customer cust, ReservationDirectory reservationDirectory, Reservation reservation) {
        initComponents();
        this.panel = panel;
        this.airlineDirectory = airlineDirectory;
        this.masterTravelSchedule = masterTravelSchedule;
        this.flightSelectedList = flightSelectedList;
        this.custDir = custDir;
        this.reservationDirectory = reservationDirectory;
        this.cust = cust;
        this.reservation = reservation;
        this.airplaneDirectory = airplaneDirectory;
        dtm = (DefaultTableModel) jTable1.getModel();
        indexCount = 0;
        resetSeatLock();
        populateFlightCombo(); 
        populateUserCombo();
        populateFlightDetails();
        populateCustomerDetails();
    }
    
    public void resetSeatLock() {
        for(Flight f : flightSelectedList) {
            f.setSeatLock(null);
        }
    }
    
    public void populateFlightCombo() {
        for(Flight f : flightSelectedList) {
            selectedFlightCombo.addItem(f);
        }
    } 
    
    public void populateUserCombo() {
        for(Customer c : custDir.getCustomerList()) {
            if(c.getIsActive()) {
                customerCombo.addItem(c);
            }
        }
    }
    
    public void populateFlightDetails() {
        //DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        //dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        Flight f = (Flight)selectedFlightCombo.getSelectedItem();
        indexCount = selectedFlightCombo.getSelectedIndex();
        System.out.println( "inde count in 1--" + indexCount);
        System.out.println( "flight"+f.getFlightName()+"Seat Lock1---> " + f.getSeatLock());
        
        flightNumTxt.setText(f.getFlightName());
        carrierTxt.setText(f.getAirliner().getAirlinerName());
        sourceTxt.setText(f.getFlightSchedule().getSource());
        destinationTxt.setText(f.getFlightSchedule().getDestination());
        dDateTxt.setText(f.getFlightSchedule().getDepartureDate()+"");
        aDateTxt.setText(f.getFlightSchedule().getArrivalDate()+"");
        dTimeTxt.setText(f.getFlightSchedule().getDepartureTime()+"");
        aTimeTxt.setText(f.getFlightSchedule().getArrivalTime()+"");
        
        for (Seat s : f.getFlightSeatList()) {
            System.out.println("Seat Lock2---> " + (f.getSeatLock() == s));
            if("Available".equals(s.getStatus())) {
                Object[] row = new Object[dtm.getColumnCount()];
                row[0] = s;
                row[1] = s.getPrice();
                row[2] = s.getType();
                row[3] = f.getSeatLock() == s;
                dtm.addRow(row);
            }
        }
    } 
    
    public void populateCustomerDetails() {
        Customer cust = (Customer)customerCombo.getSelectedItem();
        
        firstNameTxt.setText(cust.getFirstName());
        lastNameTxt.setText(cust.getLastName());
        passportTxt.setText(cust.getPassportNum());
        genderTxt.setText(cust.getGender());
        emailTxt.setText(cust.getEmailId());
        firstNameTxt.setText(cust.getFirstName());
    } 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectedFlightCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sourceTxt = new javax.swing.JTextField();
        destinationTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dDateTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        aDateTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dTimeTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        aTimeTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        flightNumTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        carrierTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        firstNameTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lastNameTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        passportTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        genderTxt = new javax.swing.JTextField();
        bookTicket = new javax.swing.JButton();
        btnBackBookFlight = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(174, 195, 195));
        setPreferredSize(new java.awt.Dimension(1040, 1020));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        selectedFlightCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedFlightComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Flight from the list for seat selection");

        jPanel1.setBackground(new java.awt.Color(174, 195, 195));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Flight Details"));

        jLabel2.setText("Source");

        sourceTxt.setEditable(false);

        destinationTxt.setEditable(false);
        destinationTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Destination");

        jLabel4.setText("Departure Date");

        dDateTxt.setEditable(false);

        jLabel5.setText("Arrival Date");

        aDateTxt.setEditable(false);

        jLabel6.setText("Departure Time");

        dTimeTxt.setEditable(false);
        dTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dTimeTxtActionPerformed(evt);
            }
        });

        jLabel7.setText("Arrival Time");

        aTimeTxt.setEditable(false);

        jLabel8.setText("Flight Number");

        flightNumTxt.setEditable(false);

        jLabel9.setText("Carrier");

        carrierTxt.setEditable(false);
        carrierTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrierTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(dTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sourceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(flightNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carrierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(aDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(aTimeTxt))))))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(flightNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(carrierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sourceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(destinationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(aDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(aTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(174, 195, 195));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Seats Selection"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Seat #", "Price", "Type", "Select Seat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Select customer");

        customerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(174, 195, 195));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Detials"));

        jLabel11.setText("First Name");

        firstNameTxt.setEditable(false);

        jLabel12.setText("Last Name");

        lastNameTxt.setEditable(false);

        jLabel13.setText("Email Id");

        emailTxt.setEditable(false);

        jLabel14.setText("Passport #");

        passportTxt.setEditable(false);

        jLabel15.setText("Gender");

        genderTxt.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passportTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(476, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(passportTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(genderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-airport-60.png"))); // NOI18N
        bookTicket.setText("Book");
        bookTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTicketActionPerformed(evt);
            }
        });

        btnBackBookFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-back-30.png"))); // NOI18N
        btnBackBookFlight.setText("Back");
        btnBackBookFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackBookFlightActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel16.setText("Book Flight");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(selectedFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBackBookFlight))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(411, 411, 411)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(436, 436, 436)
                                .addComponent(bookTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackBookFlight)
                .addGap(8, 8, 8)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(selectedFlightCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(bookTicket)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dTimeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dTimeTxtActionPerformed

    private void destinationTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationTxtActionPerformed

    private void carrierTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrierTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carrierTxtActionPerformed

    private void customerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboActionPerformed
        populateCustomerDetails();
    }//GEN-LAST:event_customerComboActionPerformed

    public boolean isSeatSelected(Flight f) {
        int nRow = jTable1.getRowCount();
        int count1 = 0;
        boolean s = true;
        
        for(int i=0; i < nRow; i++) {           
            if(null != jTable1.getValueAt(i, 3)) {
                if((Boolean)jTable1.getValueAt(i, 3) == false) {
                    count1++;
                }
            }
        }        
        if(count1 == nRow) {
            s = false;
            JOptionPane.showMessageDialog(null, "Please select a seat");
        }
        return s;
    }
    
    public boolean isOnlyOneSeatSelected(Flight f) {
        int nRow = jTable1.getRowCount();
        int count2 = 0;
        int rowCount = 0;
        boolean s = true;
        
        for(int i=0; i < nRow; i++) {           
            if(null != jTable1.getValueAt(i, 3)) {
                if((Boolean)jTable1.getValueAt(i, 3) == true) {
                    rowCount = i;
                    count2++;
                }
            }
        }        
        if(count2 > 1 && nRow > 1) {
            s = false;
            JOptionPane.showMessageDialog(null, "Please select only one seat");
        }else {
            
            Seat s1 = (Seat)jTable1.getValueAt(rowCount, 0);
            if(f.getSeatLock() == null) {
                f.setSeatLock(s1);
            }
            
            System.out.println("---seat lock while booking --- " );
            System.out.println( "flight"+f.getFlightName()+"Seat Lock1---> " + f.getSeatLock());
            System.out.println("---eat lock while booking --- " );
        }
        return s;
    }
    
    private void selectedFlightComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedFlightComboActionPerformed
        
        //selectedFlightCombo.getItemAt(indexCount);
        
        if(flightSelectedList.size() > 1) {
            System.out.println("---calling---");
            int nRow = jTable1.getRowCount();
            int count1 = 0;
            int count2 = 0;
            int rowCount = 0;

            for(int i=0; i < nRow; i++) {           
                if(null == jTable1.getValueAt(i, 3)) {
                    //count1++;
                }else {
                    if((Boolean)jTable1.getValueAt(i, 3) == false) {
                        count1++;
                    }
                }

                if(null == jTable1.getValueAt(i, 3)) {
                    //count1++;
                }else {
                    if((Boolean)jTable1.getValueAt(i, 3) == true) {
                        rowCount = i;
                        count2++;
                    }
                }
            }

            if(count1 == nRow) {
                JOptionPane.showMessageDialog(null, "Please select a seat before procedding to next flight");
                selectedFlightCombo.setSelectedIndex(indexCount);
            }else if(count2 == nRow && nRow > 1) {
                JOptionPane.showMessageDialog(null, "Please select only one seat");
                selectedFlightCombo.setSelectedIndex(indexCount);
            }else {
                Seat s = (Seat)jTable1.getValueAt(rowCount, 0);
                System.out.println( "inde count in 2--" + indexCount);
                Flight f = (Flight)selectedFlightCombo.getItemAt(indexCount);
                f.setSeatLock(s);
                populateFlightDetails();
            }
        }
        
        
        /*
        int n = jTable1.getSelectedRow();        
        if(n>=0){
            
            
            
            Seat s = (Seat)jTable1.getValueAt(n, 0);
            Flight f = (Flight)selectedFlightCombo.getItemAt(indexCount);
            f.setSeatLock(s);
        }        
        populateFlightDetails();
        */
    }//GEN-LAST:event_selectedFlightComboActionPerformed
    
    private boolean isOverlap(Flight f) {
        boolean overlap = false;
        Customer c = (Customer)customerCombo.getSelectedItem();
        Flight flightMatched = null;
        
        for(Reservation r : reservationDirectory.getReservationList()) {
            if(r.getCustomer() == (Customer)customerCombo.getSelectedItem() && r.isIsBooked()) {
                
                if(r.getFlight().getFlightSchedule().getDepartureDate().isBefore(f.getFlightSchedule().getArrivalDate()) &&
                        f.getFlightSchedule().getDepartureDate().isBefore(r.getFlight().getFlightSchedule().getArrivalDate())) {
                    System.out.println(">>>>> iside 1 >>>>>>");
                    overlap = true;
                    flightMatched = r.getFlight();
                }else if((f.getFlightSchedule().getArrivalDate().equals(r.getFlight().getFlightSchedule().getArrivalDate()) && 
                          f.getFlightSchedule().getDepartureDate().equals(r.getFlight().getFlightSchedule().getDepartureDate())) ||
                        f.getFlightSchedule().getArrivalDate().equals(r.getFlight().getFlightSchedule().getDepartureDate()) ||
                        f.getFlightSchedule().getDepartureDate().equals(r.getFlight().getFlightSchedule().getArrivalDate())
                        ) {    
                    System.out.println(">>>>> iside 2 >>>>>>");
                    long diff1 = DAYS.between(r.getFlight().getFlightSchedule().getDepartureDate(), r.getFlight().getFlightSchedule().getArrivalDate());
                    long diff2 = DAYS.between(f.getFlightSchedule().getDepartureDate(), f.getFlightSchedule().getArrivalDate());
                    
                    if(diff2 > diff1) {
                        System.out.println(">>>>> iside 3 >>>>>>");
                        if(r.getFlight().getFlightSchedule().getArrivalTime().isAfter(f.getFlightSchedule().getDepartureTime())) {
                            System.out.println(">>>>> iside 4 >>>>>>");
                            overlap = true;
                            flightMatched = r.getFlight();
                        }
                    }
                    if(diff1 > diff2) {
                        System.out.println(">>>>> iside 5 >>>>>>");
                        if(f.getFlightSchedule().getArrivalTime().isAfter(r.getFlight().getFlightSchedule().getDepartureTime())) {
                            System.out.println(">>>>> iside 6 >>>>>>");
                            overlap = true;
                            flightMatched = r.getFlight();
                        }
                    }
                    if(diff1 == diff2) {
                        System.out.println(">>>>> iside 7 >>>>>>");
                        if(r.getFlight().getFlightSchedule().getDepartureTime().isBefore(f.getFlightSchedule().getArrivalTime()) &&
                            f.getFlightSchedule().getDepartureTime().isBefore(r.getFlight().getFlightSchedule().getArrivalTime())) {
                            System.out.println(">>>>> iside 8 >>>>>>");
                            overlap = true;
                            flightMatched = r.getFlight();
                        }
                        if(f.getFlightSchedule().getDepartureTime().equals(r.getFlight().getFlightSchedule().getDepartureTime()) && 
                          f.getFlightSchedule().getArrivalTime().equals(r.getFlight().getFlightSchedule().getArrivalTime())) {
                            System.out.println(">>>>> iside 9 >>>>>>");
                            overlap = true;
                            flightMatched = r.getFlight();
                        }
                    }
                }                
            }
        }
        if(overlap == true) {
            JOptionPane.showMessageDialog(null, "There is already a booking for customer " + c.getFirstName() + " " + c.getLastName() + " on flight number " + flightMatched.getFlightName() + " which is overlapping with the schedule for flight number " + f.getFlightName() + ". Please seach again and choose different flight" );
        }
        return overlap;
    }
    
    private void bookTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTicketActionPerformed
        
        boolean overlapVal = false;
        
        /*for(Flight f : flightSelectedList) {            
            //overlapVal = isOverlap(f);
            if(isOverlap(f)) {
                overlapVal = true;
                break;
            }
        }*/
        
        //if(!overlapVal) {
            
            boolean seatSelected = true;
            boolean oneSeatSelected = true;
            
            for(Flight f : flightSelectedList) {

                
                if(isOverlap(f)) {
                    overlapVal = true;
                    break;
                }             
                
                if(!isSeatSelected(f)) {
                    seatSelected = false;
                    break;
                }
                
                if(!isOnlyOneSeatSelected(f)) {
                    seatSelected = false;
                    break;
                }
                
                /*
                if(f.getSeatLock() == null) {
                    JOptionPane.showMessageDialog(null,"Please select a seat on flight " + f.getFlightName() +" to make booking");
                    seatSelected = false;
                    break;
                }
                */
            }           
            //!overlapVal && 
            if(seatSelected && !overlapVal && oneSeatSelected) {
                for(Flight f : flightSelectedList) {
                    
                    Reservation r = new Reservation();
                    r.setFlight(f);
                    r.setCustomer((Customer)customerCombo.getSelectedItem());
                    //r.setSeat(f.getSeatLock());
                    Seat seatVal = f.getSeatLock();
                    System.out.println("inside MMMMM MMMM ---- " + seatVal.getSeatName() + "--" + seatVal.getStatus());
                    seatVal.setStatus("Not Available");
                    r.setSeat(seatVal);  
                    
                    f.setSeatLock(null);
                    
                    reservationDirectory.addReservation(r);
                }
                JOptionPane.showMessageDialog(null,"Flight has been booked successfully. Go to Manage Booking panel to manage all the bookings.");
                
                ManageTravelAgency manageTravelAgency = new ManageTravelAgency(panel, airlineDirectory, airplaneDirectory, masterTravelSchedule, custDir, cust, reservationDirectory, reservation);
                this.panel.add(manageTravelAgency, "ManageTravelAgency");
                CardLayout layout = (CardLayout)this.panel.getLayout();
                layout.next(panel);                                       
        //}
            
            /*
            for(Flight f : flightSelectedList) {
                int emptyCheck = 0;
                Reservation r = new Reservation();
                r.setFlight(f);
                r.setCustomer((Customer)customerCombo.getSelectedItem());

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                int nRow = dtm.getRowCount();
                
                
                for(int i=0; i < nRow; i++) {  
                    if(null != jTable1.getValueAt(i, 3)) {
                      if((boolean)jTable1.getValueAt(i, 3) == true) {
                          Seat seatVal = (Seat)jTable1.getValueAt(i, 0);
                          seatVal.setStatus("Not Available");
                          r.setSeat(seatVal);                    
                      }
                    }else {
                        emptyCheck++;
                    }
                }
                
                
                if(emptyCheck == nRow) {
                    JOptionPane.showMessageDialog(null,"Please select a seat to make booking");
                }else {
                    reservationDirectory.addReservation(r);
                    JOptionPane.showMessageDialog(null,"Flight has been booked successfully. Go to Manage Booking panel to manage all the bookings.");
                }
                
            } 
            */
            
        
            }
        
        for(Reservation r : reservationDirectory.getReservationList()) {
            System.out.println("------ RESERVATION ----------");
            System.out.println(r.getFlight().getFlightName());
            System.out.println(r.getFlight().getFlightSchedule().getSource());
            System.out.println(r.getFlight().getFlightSchedule().getDestination());
            System.out.println(r.getSeat().getSeatName());
            System.out.println(r.getReservationId());
            System.out.println(r.isIsBooked());
            System.out.println("------ RESERVATION END ----------");
            //System.out.println(r);
            //System.out.println(r);
            //System.out.println(r);
            //System.out.println(r);
            //System.out.println(r);
            
            
            
        }
        
    }//GEN-LAST:event_bookTicketActionPerformed

    private void btnBackBookFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackBookFlightActionPerformed
        // TODO add your handling code here:
        //this.panel.remove(this);
        //CardLayout layout = (CardLayout) this.panel.getLayout();
        //layout.previous(panel);
        
        /*
        System.out.println(">>>--- inside book flight back btn >>>---");
        this.panel.remove(this);
        CardLayout layout = (CardLayout)this.panel.getLayout();
        Component[] comps = this.panel.getComponents();
        for (Component comp : comps){
            if(comp instanceof ManageTravelAgency){
                ManageTravelAgency rePopulateTable = (ManageTravelAgency) comp;
                //SearchFlightJPanel1 rePopulateTable = (SearchFlightJPanel1) comp;
                //rePopulateTable.populate();
                
                //rePopulateTable.populate();
                //rePopulateTable.hideTables();
                //rePopulateTable.hideRoundTripFields();
                //rePopulateTable.hideMulticityFields();
                
            }
        }
        layout.previous(panel);
        */
        //JPanel panel, AirlinerDirectory airlineDirectory, AirplaneDirectory airplaneDirectory, MasterTravelSchedule masterTravelSchedule, CustomerDirectory custDir, Customer cust, ReservationDirectory reservationDirectory, Reservation reservation
        SearchFlightJPanel1 manageTravelAgency = new SearchFlightJPanel1(panel, airlineDirectory, airplaneDirectory, masterTravelSchedule, custDir, cust, reservationDirectory, reservation);
        this.panel.add(manageTravelAgency, "SearchFlightJPanel1");
        CardLayout layout = (CardLayout)this.panel.getLayout();
        layout.next(panel);
        
        System.out.println(">>>--- exit book flight back btn >>>---");
    }//GEN-LAST:event_btnBackBookFlightActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
      
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aDateTxt;
    private javax.swing.JTextField aTimeTxt;
    private javax.swing.JButton bookTicket;
    private javax.swing.JButton btnBackBookFlight;
    private javax.swing.JTextField carrierTxt;
    private javax.swing.JComboBox<Customer> customerCombo;
    private javax.swing.JTextField dDateTxt;
    private javax.swing.JTextField dTimeTxt;
    private javax.swing.JTextField destinationTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JTextField flightNumTxt;
    private javax.swing.JTextField genderTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JTextField passportTxt;
    private javax.swing.JComboBox<Flight> selectedFlightCombo;
    private javax.swing.JTextField sourceTxt;
    // End of variables declaration//GEN-END:variables
}
