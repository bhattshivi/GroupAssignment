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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivibhatt
 */
public class SearchFlightJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form SearchFlightJPanel
     */
    private JPanel panel;
    private AirlinerDirectory airlineDirectory;
    private MasterTravelSchedule masterTravelSchedule;
    private ArrayList<Flight> masterFlightList;
    private String searchTxtFlight;
    private String source;
    private String destination;
    private CustomerDirectory custDir;
    private Customer cust;

    private Reservation reservation;
    private String searchType;
    private ReservationDirectory reservationDirectory;
    
    private DefaultTableModel dtmMultiCity;
    private DefaultTableModel dtmOneWay;
    private DefaultTableModel dtmRoundTrip;
    private int multicityRowCount;
    private AirplaneDirectory airplaneDirectory;
    
    public SearchFlightJPanel1(JPanel panel, AirlinerDirectory airlineDirectory, AirplaneDirectory airplaneDirectory, MasterTravelSchedule masterTravelSchedule, CustomerDirectory custDir, Customer cust, ReservationDirectory reservationDirectory, Reservation reservation) {
        initComponents();
        searchType = "one-way";
        dtmOneWay = (DefaultTableModel) tblSearchFlight.getModel();
        multicityRowCount = 1;
        this.panel = panel;
        this.airlineDirectory = airlineDirectory;
        this.masterTravelSchedule = masterTravelSchedule;
        this.custDir = custDir;
        this.cust = cust;
        this.reservation = reservation;
        this.reservationDirectory = reservationDirectory;
        this.airplaneDirectory = airplaneDirectory;
        deleteRow.setEnabled(false);
        populate();
        hideTables();
        hideRoundTripFields();
        hideMulticityFields();
        
    }
    
    public void hideRoundTripFields() {
        //returningDate.setVisible(false);
        //returningDateLbl.setVisible(false);
        tblSearchRoundTripFlights.setVisible(false);
        //jScrollPane2.setVisible(false);
        //jLabel2.setVisible(false);
        rDateLabel.setVisible(false);
        aDatePicker.setVisible(false);
    }
    
    public void showRoundTripFields() {
        //returningDate.setVisible(true);
        //returningDateLbl.setVisible(true);
        tblSearchRoundTripFlights.setVisible(true);
        //jScrollPane2.setVisible(true);
        //jLabel2.setVisible(true);
        rDateLabel.setVisible(true);
        aDatePicker.setVisible(true);
    }
    
    public void hideMulticityFields() {
        jPanel2.setVisible(false); 
    }
    
    public void showMulticityFields() {
        jPanel2.setVisible(true); 
    }
    
    public void hideonewayFields() {
        jPanel1.setVisible(false); 
    }
    
    public void showonewayFields() {
        jPanel1.setVisible(true); 
    }
    
    public void hideTables() {
        jScrollPane1.setVisible(false);
        jLabel1.setVisible(false);
        jScrollPane2.setVisible(false);
        jLabel2.setVisible(false);        
    }
    
    public void showDepartingTable() {
        jScrollPane1.setVisible(true);
        jLabel1.setVisible(true);
    }
    
    public void showReturningTable() {
        jScrollPane2.setVisible(true);
        jLabel2.setVisible(true);
    }
    
    
    public void hideFields() {
        
        
        jPanel2.setVisible(false);        
        tblSearchRoundTripFlights.setVisible(false);
        jScrollPane2.setVisible(false);
        jLabel2.setVisible(false);
    }
    
    public void showFields() {
        //returningDate.setVisible(true);
        //returningDateLbl.setVisible(true);        
    }
    
    public void populate() {
        
        DefaultTableModel dtm = (DefaultTableModel) tblSearchFlight.getModel();
        dtm.setRowCount(0);
        for (Flight f : masterTravelSchedule.getMasterFlightList()) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = f;
            row[1] = f.getFlightSchedule().getSource();
            row[2] = f.getFlightSchedule().getDestination();
            row[3] = f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
            row[4] = f.getFlightSchedule().getArrivalDate()+ "; " + f.getFlightSchedule().getArrivalTime();
            dtm.addRow(row);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flightSearchOptions = new javax.swing.ButtonGroup();
        sourceCombo1 = new javax.swing.JComboBox<>();
        destinationCombo1 = new javax.swing.JComboBox<>();
        oneWayRB = new javax.swing.JRadioButton();
        multiCityRB = new javax.swing.JRadioButton();
        roundTripRB = new javax.swing.JRadioButton();
        searchFlight = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearchFlight = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSearchRoundTripFlights = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sourceCombo = new javax.swing.JComboBox<>();
        dDateLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        destinationCombo = new javax.swing.JComboBox<>();
        dDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        rDateLabel = new javax.swing.JLabel();
        aDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMultiCity = new javax.swing.JTable();
        addRow = new javax.swing.JButton();
        deleteRow = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnBackSearchFlights = new javax.swing.JButton();

        sourceCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boston", "San Francisco", "Dallas", "San Jose", "Seattle", "New York", "Las Vegas", "Los Angeles", "Chicago", "Miami" }));

        destinationCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boston", "San Francisco", "Dallas", "San Jose", "Seattle", "New York", "Las Vegas", "Los Angeles", "Chicago", "Miami" }));

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

        oneWayRB.setBackground(new java.awt.Color(174, 195, 195));
        flightSearchOptions.add(oneWayRB);
        oneWayRB.setSelected(true);
        oneWayRB.setText("One-way");
        oneWayRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneWayRBActionPerformed(evt);
            }
        });

        multiCityRB.setBackground(new java.awt.Color(174, 195, 195));
        flightSearchOptions.add(multiCityRB);
        multiCityRB.setText("Multi-destination");
        multiCityRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiCityRBActionPerformed(evt);
            }
        });

        roundTripRB.setBackground(new java.awt.Color(174, 195, 195));
        flightSearchOptions.add(roundTripRB);
        roundTripRB.setText("Round-trip");
        roundTripRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundTripRBActionPerformed(evt);
            }
        });

        searchFlight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        searchFlight.setText(" Search");
        searchFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFlightActionPerformed(evt);
            }
        });

        tblSearchFlight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight Id", "Flight #", "Airline", "Airplane", "Source", "Destination", "Departing Date and Time", "Arrival Date and Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchFlight.setRowHeight(25);
        jScrollPane1.setViewportView(tblSearchFlight);
        if (tblSearchFlight.getColumnModel().getColumnCount() > 0) {
            tblSearchFlight.getColumnModel().getColumn(0).setResizable(false);
            tblSearchFlight.getColumnModel().getColumn(2).setResizable(false);
            tblSearchFlight.getColumnModel().getColumn(3).setResizable(false);
            tblSearchFlight.getColumnModel().getColumn(4).setResizable(false);
            tblSearchFlight.getColumnModel().getColumn(5).setResizable(false);
            tblSearchFlight.getColumnModel().getColumn(6).setResizable(false);
            tblSearchFlight.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setText("Flights List");

        jLabel2.setText("Returning Flights List");

        tblSearchRoundTripFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight Id", "Flight #", "Airline", "Airplane", "Source", "Destination", "Departing Date and Time", "Arrival Date and Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchRoundTripFlights.setRowHeight(25);
        jScrollPane2.setViewportView(tblSearchRoundTripFlights);
        if (tblSearchRoundTripFlights.getColumnModel().getColumnCount() > 0) {
            tblSearchRoundTripFlights.getColumnModel().getColumn(0).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(1).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(2).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(3).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(4).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(5).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(6).setResizable(false);
            tblSearchRoundTripFlights.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-airport-60.png"))); // NOI18N
        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(174, 195, 195));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Departing from?");

        sourceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- None --", "Boston", "San Francisco", "Dallas", "San Jose", "Seattle", "New York", "Las Vegas", "Los Angeles", "Chicago", "Miami" }));

        dDateLabel.setText("Departing Date");

        jLabel8.setText("Going to?");

        destinationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- None --", "Boston", "San Francisco", "Dallas", "San Jose", "Seattle", "New York", "Las Vegas", "Los Angeles", "Chicago", "Miami" }));
        destinationCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationComboActionPerformed(evt);
            }
        });

        rDateLabel.setText("Returning Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dDateLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sourceCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dDatePicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(206, 206, 206)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rDateLabel)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(destinationCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sourceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(destinationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dDateLabel)
                    .addComponent(dDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rDateLabel)
                    .addComponent(aDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(174, 195, 195));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblMultiCity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Source", "Destination", "Departing Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblMultiCity.setRowHeight(25);
        jScrollPane3.setViewportView(tblMultiCity);
        if (tblMultiCity.getColumnModel().getColumnCount() > 0) {
            tblMultiCity.getColumnModel().getColumn(0).setResizable(false);
            tblMultiCity.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(sourceCombo1));
            tblMultiCity.getColumnModel().getColumn(1).setResizable(false);
            tblMultiCity.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(destinationCombo1));
            tblMultiCity.getColumnModel().getColumn(2).setResizable(false);
        }

        addRow.setText("Add Row");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });

        deleteRow.setText("Delete Row");
        deleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addRow)
                        .addGap(18, 18, 18)
                        .addComponent(deleteRow)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search Flights");
        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N

        btnBackSearchFlights.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-back-30.png"))); // NOI18N
        btnBackSearchFlights.setText("<Back");
        btnBackSearchFlights.setBackground(new java.awt.Color(174, 195, 195));
        btnBackSearchFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackSearchFlightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBackSearchFlights)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(357, 357, 357))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(oneWayRB)
                                .addGap(18, 18, 18)
                                .addComponent(roundTripRB)
                                .addGap(18, 18, 18)
                                .addComponent(multiCityRB)
                                .addGap(346, 346, 346))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(searchFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackSearchFlights)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneWayRB)
                    .addComponent(roundTripRB)
                    .addComponent(multiCityRB))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFlight)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFlightActionPerformed
        System.out.println(oneWayRB.isSelected());
        System.out.println(multiCityRB.isSelected());
        System.out.println(roundTripRB.isSelected());
        
        if(oneWayRB.isSelected()) {
            
            jLabel1.setText("Flights from " + sourceCombo.getSelectedItem() + " to " + destinationCombo.getSelectedItem());
            String source = (String)sourceCombo.getSelectedItem();
            String destination = (String)destinationCombo.getSelectedItem();
            LocalDate dDate;// = LocalDate.parse(departingDate.getText());
            
            if("-- None --".equals(source)) {
                JOptionPane.showMessageDialog(null, "Please select source city");
            }else if("-- None --".equals(destination)) {
                JOptionPane.showMessageDialog(null, "Please select destination city");
            }else if(source.equals(destination)) {
                JOptionPane.showMessageDialog(null, "Source and destination city cannot be same");
            }else if("".equals(dDatePicker.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter departing date");
            }
            
            /*
            else if("".equals(departingDate.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter departing date");
            }
            */
            
            else {
                
                try{
                    //dDate = LocalDate.parse(departingDate.getText());
                    dDate = dDatePicker.getDate();
                }catch(DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Departure date in YYYY-MM-DD format");
                    return;
                }
                
                if(dDate.isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "Departure Date can not be the past date");
                }else {
                    //DefaultTableModel dtm = (DefaultTableModel) tblSearchFlight.getModel();
                    showDepartingTable();
                    dtmOneWay.setRowCount(0);
                    for (Flight f : masterTravelSchedule.searchOneWayFlight(source, destination, dDate)) {
                        Object[] row = new Object[dtmOneWay.getColumnCount()];
                        
                        row[0]= f;
                        row[1]= f.getFlightName();
                        row[2]= f.getAirliner();
                        row[3]= f.getAirplane();
                        row[4]= f.getFlightSchedule().getSource();
                        row[5]= f.getFlightSchedule().getDestination();
                        row[6]= f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                        row[7]= f.getFlightSchedule().getArrivalDate() + "; " + f.getFlightSchedule().getArrivalTime();
                        
                        
                        /*
                        row[0] = f;
                        row[1] = f.getFlightSchedule().getSource();
                        row[2] = f.getFlightSchedule().getDestination();
                        row[3] = f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                        row[4] = f.getFlightSchedule().getArrivalDate()+ "; " + f.getFlightSchedule().getArrivalTime();
                        */
                        dtmOneWay.addRow(row);
                    }

                    if(masterTravelSchedule.searchOneWayFlight(source, destination, dDate).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no matching flights. Please modify the criteria");
                    }
                }
            }
        }
        
        if(roundTripRB.isSelected()) {
            
            //tblSearchRoundTripFlights.setVisible(true);
            //jScrollPane2.setVisible(true);
            //jLabel2.setVisible(true);
            
            jLabel1.setText("Flights from " + sourceCombo.getSelectedItem() + " to " + destinationCombo.getSelectedItem());
            String source = (String)sourceCombo.getSelectedItem();
            String destination = (String)destinationCombo.getSelectedItem();
            LocalDate dDate;
            LocalDate rDate;
            
            if("".equals(source)) {
                JOptionPane.showMessageDialog(null, "Please select source city");
            }else if("".equals(destination)) {
                JOptionPane.showMessageDialog(null, "Please select destination city");
            }else if(source.equals(destination)) {
                JOptionPane.showMessageDialog(null, "Source and destination city cannot be same");
            }
            else if("".equals(dDatePicker.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter departing date");
            }
            else if("".equals(aDatePicker.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter departing date");
            }
            /*
            else if("".equals(departingDate.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter departing date");
            }else if("".equals(returningDate.getText())) {
                JOptionPane.showMessageDialog(null, "Please select returning date");
            }
            */else {
                
                try{
                    //dDate = LocalDate.parse(departingDate.getText());
                    dDate = dDatePicker.getDate();
                }catch(DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Departure date in YYYY-MM-DD format");
                    return;
                } 

                try{
                    //rDate = LocalDate.parse(returningDate.getText());
                    rDate = aDatePicker.getDate();
                }catch(DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Returning date in YYYY-MM-DD format");
                    return;
                } 
                
                if(dDate.isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "Departure Date can not be the past date");
                }else if(rDate.isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "Returning Date can not be the past date");
                }else if(dDate.isAfter(rDate)) {
                    JOptionPane.showMessageDialog(null, "Departure Date should not be greater than Returning Date");
                }else {
                    showDepartingTable();
                    showReturningTable();
                    dtmOneWay.setRowCount(0);
                    for (Flight f : masterTravelSchedule.searchRoundTripFlight(source, destination, dDate, null)) {
                        Object[] row = new Object[dtmOneWay.getColumnCount()];
                        row[0]= f;
                        row[1]= f.getFlightName();
                        row[2]= f.getAirliner();
                        row[3]= f.getAirplane();
                        row[4]= f.getFlightSchedule().getSource();
                        row[5]= f.getFlightSchedule().getDestination();
                        row[6]= f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                        row[7]= f.getFlightSchedule().getArrivalDate() + "; " + f.getFlightSchedule().getArrivalTime();
                        /*
                        row[0] = f;
                        row[1] = f.getFlightSchedule().getSource();
                        row[2] = f.getFlightSchedule().getDestination();
                        row[3] = f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                        row[4] = f.getFlightSchedule().getArrivalDate()+ "; " + f.getFlightSchedule().getArrivalTime();
                        */
                        dtmOneWay.addRow(row);
                    }

                    jLabel2.setText("Flights from " + destinationCombo.getSelectedItem() + " to " + sourceCombo.getSelectedItem());
                    //DefaultTableModel dtm1 = (DefaultTableModel) tblSearchRoundTripFlights.getModel();
                    dtmRoundTrip.setRowCount(0);
                    for (Flight f : masterTravelSchedule.searchRoundTripFlight(destination, source, null, rDate)) {
                        Object[] row = new Object[dtmRoundTrip.getColumnCount()];
                        row[0]= f;
                        row[1]= f.getFlightName();
                        row[2]= f.getAirliner();
                        row[3]= f.getAirplane();
                        row[4]= f.getFlightSchedule().getSource();
                        row[5]= f.getFlightSchedule().getDestination();
                        row[6]= f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                        row[7]= f.getFlightSchedule().getArrivalDate() + "; " + f.getFlightSchedule().getArrivalTime();
                        /*
                        row[0] = f;
                        row[1] = f.getFlightSchedule().getSource();
                        row[2] = f.getFlightSchedule().getDestination();
                        row[3] = f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                        row[4] = f.getFlightSchedule().getArrivalDate()+ "; " + f.getFlightSchedule().getArrivalTime();
                        */
                        dtmRoundTrip.addRow(row);
                    }

                    if(masterTravelSchedule.searchRoundTripFlight(source, destination, dDate, null).isEmpty() &&
                            masterTravelSchedule.searchRoundTripFlight(destination, source, null, rDate).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no matching flights. Please modify the criteria");
                    }else if(masterTravelSchedule.searchRoundTripFlight(source, destination, dDate, null).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no matching departing flights. Please modify the criteria or select one-way option to book a single flight");
                    }else if(masterTravelSchedule.searchRoundTripFlight(destination, source, null, rDate).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no matching returning flights. Please modify the criteria or select one-way option to book a single flight");
                    }
                }
            }
            
            
            
            
            //DefaultTableModel dtm = (DefaultTableModel) tblSearchFlight.getModel();
            
        }
        
        if(multiCityRB.isSelected()) {
            
            boolean isError = false;
            
            int nRow = dtmMultiCity.getRowCount();
            ArrayList<Flight> multiCityFlights = new ArrayList<>();
            ArrayList<Flight> f1 = new ArrayList<>();
            
            for(int i=0; i < nRow; i++) {
                
                if(null == tblMultiCity.getValueAt(i, 0)) {
                    isError = true;
                    JOptionPane.showMessageDialog(null, "Please select source city at row " + (i+1));
                    break;
                }else if(null == tblMultiCity.getValueAt(i, 1)) {
                    isError = true;
                    JOptionPane.showMessageDialog(null, "Please select destination city at row " + (i+1));
                    break;
                }else if(tblMultiCity.getValueAt(i, 0).toString().equals(tblMultiCity.getValueAt(i, 1).toString())) {
                    isError = true;
                    JOptionPane.showMessageDialog(null, "Source and destination city cannot be same at row " + (i+1));
                }else if(null == tblMultiCity.getValueAt(i, 2) || "".equals(tblMultiCity.getValueAt(i, 2))) {
                    isError = true;
                    JOptionPane.showMessageDialog(null, "Please enter departing date at row " + (i+1));
                    break;
                }else {
                    LocalDate dDate;
                    try{
                        dDate = LocalDate.parse(tblMultiCity.getValueAt(i, 2).toString());
                    }catch(DateTimeParseException e){
                        isError = true;
                        JOptionPane.showMessageDialog(null, "Please enter a valid Departure date in YYYY-MM-DD format at row " + (i+1));
                        return;
                    } 
                    
                    if(dDate.isBefore(LocalDate.now())) {
                        isError = true;
                        JOptionPane.showMessageDialog(null, "Departure Date can not be the past date");
                    }else if(i>0) {
                        if(LocalDate.parse(tblMultiCity.getValueAt(i, 2).toString()).isBefore(LocalDate.parse(tblMultiCity.getValueAt((i-1), 2).toString()))) {
                            isError = true;
                            JOptionPane.showMessageDialog(null, "Dates should be in chronological order");
                        }else {
                            f1 = masterTravelSchedule.searchOneWayFlight(tblMultiCity.getValueAt(i, 0).toString(), tblMultiCity.getValueAt(i, 1).toString(), dDate);
                            multiCityFlights.addAll(f1);
                        }
                    }else {
                        f1 = masterTravelSchedule.searchOneWayFlight(tblMultiCity.getValueAt(i, 0).toString(), tblMultiCity.getValueAt(i, 1).toString(), dDate);
                        multiCityFlights.addAll(f1);
                    }
                }                
            }
            
            /*String source = (String)sourceCombo.getSelectedItem();
            String destination = (String)destinationCombo.getSelectedItem();
            LocalDate dDate = LocalDate.parse(departingDate.getText());
            LocalDate rDate = LocalDate.parse(returningDate.getText());*/
        
            
            
            //DefaultTableModel dtm = (DefaultTableModel) tblSearchFlight.getModel();
            if(!isError) {
                showDepartingTable();
                dtmOneWay.setRowCount(0);
                for (Flight f : multiCityFlights) {
                    Object[] row = new Object[dtmOneWay.getColumnCount()];
                    row[0]= f;
                    row[1]= f.getFlightName();
                    row[2]= f.getAirliner();
                    row[3]= f.getAirplane();
                    row[4]= f.getFlightSchedule().getSource();
                    row[5]= f.getFlightSchedule().getDestination();
                    row[6]= f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                    row[7]= f.getFlightSchedule().getArrivalDate() + "; " + f.getFlightSchedule().getArrivalTime();
                    
                        /*
                    row[0] = f;
                    row[1] = f.getFlightSchedule().getSource();
                    row[2] = f.getFlightSchedule().getDestination();
                    row[3] = f.getFlightSchedule().getDepartureDate() + "; " + f.getFlightSchedule().getDepartureTime();
                    row[4] = f.getFlightSchedule().getArrivalDate()+ "; " + f.getFlightSchedule().getArrivalTime();
                        */
                    dtmOneWay.addRow(row);
                }

                if(multiCityFlights.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "There are no matching flights. Please modify the criteria");
                }
            }
            
            
        }
        
    }//GEN-LAST:event_searchFlightActionPerformed

    private void oneWayRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneWayRBActionPerformed
        System.out.println(oneWayRB.isSelected());
        dtmOneWay = (DefaultTableModel) tblSearchFlight.getModel();
        //multicityRowCount = 0;
        hideTables();
        hideRoundTripFields();
        hideMulticityFields();
        showonewayFields();
    }//GEN-LAST:event_oneWayRBActionPerformed

    private void multiCityRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiCityRBActionPerformed
        dtmMultiCity = (DefaultTableModel) tblMultiCity.getModel();
        dtmMultiCity.setRowCount(0);
        dtmMultiCity.setRowCount(1);
        dtmOneWay = (DefaultTableModel) tblSearchFlight.getModel();
        hideTables();
        hideRoundTripFields();
        showMulticityFields();
        hideonewayFields();
    }//GEN-LAST:event_multiCityRBActionPerformed

    private void roundTripRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundTripRBActionPerformed
        dtmOneWay = (DefaultTableModel) tblSearchFlight.getModel();
        dtmRoundTrip = (DefaultTableModel) tblSearchRoundTripFlights.getModel();
        hideTables();
        showRoundTripFields();
        hideMulticityFields();
        showonewayFields();
    }//GEN-LAST:event_roundTripRBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean isActiveCust = false;
        for(Customer c : custDir.getCustomerList()) {
            if(c.getIsActive()) {
                isActiveCust = true;
                break;
            }
        }
        if(isActiveCust == true) {
        
            ArrayList<Flight> flightToBook = new ArrayList<>();

            if(oneWayRB.isSelected()) {
                int selectedRow1 = tblSearchFlight.getSelectedRow();


                if(selectedRow1<0) {
                    JOptionPane.showMessageDialog(null, "Please select a flight to book");
                }else {
                    Flight f = (Flight)tblSearchFlight.getValueAt(selectedRow1, 0);
                    flightToBook.add(f);
                    //BookFlightJPanel1 searchFlightJPanel = new BookFlightJPanel1(this.panel, airlineDirectory, masterTravelSchedule, flightToBook, custDir, reservationDirectory);
                    BookFlightJPanel1 searchFlightJPanel = new BookFlightJPanel1(this.panel, airlineDirectory, airplaneDirectory, masterTravelSchedule, flightToBook, custDir, cust, reservationDirectory, reservation);
                    this.panel.add(searchFlightJPanel, "SearchFlightJPanel");
                    CardLayout layout = (CardLayout)this.panel.getLayout();
                    layout.next(panel);
                }
            }

            if(roundTripRB.isSelected()) {
                int selectedRow1 = tblSearchFlight.getSelectedRow();
                int selectedRow2 = tblSearchRoundTripFlights.getSelectedRow();
                //ArrayList<Flight> flightToBook = new ArrayList<>();

                if(selectedRow1<0) {
                    JOptionPane.showMessageDialog(null, "Please select one departing flight");
                }
                else if(selectedRow2<0 && roundTripRB.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please select one returning flight");
                }
                else {
                    Flight f1;
                    Flight f = (Flight)tblSearchFlight.getValueAt(selectedRow1, 0);
                    if(roundTripRB.isSelected()) {
                        f1 = (Flight)tblSearchRoundTripFlights.getValueAt(selectedRow2, 0);
                        flightToBook.add(f1);
                    }
                    flightToBook.add(f);
                    BookFlightJPanel1 searchFlightJPanel = new BookFlightJPanel1(this.panel, airlineDirectory, airplaneDirectory, masterTravelSchedule, flightToBook, custDir, cust, reservationDirectory, reservation);
                    this.panel.add(searchFlightJPanel, "SearchFlightJPanel");
                    CardLayout layout = (CardLayout)this.panel.getLayout();
                    layout.next(panel);

                }
            }

            if(multiCityRB.isSelected()) {
                int readyToBookCount = 0;
                int selectedRow1 = tblSearchFlight.getSelectedRow();
                //ArrayList<Flight> flightToBook = new ArrayList<>();

                if(selectedRow1 < 0) {
                    //readyToBookCount = 0;
                    JOptionPane.showMessageDialog(null, "Please select atleast one flight");
                }else {
                    //readyToBookCount = 0;
                    int[] selectedRows = tblSearchFlight.getSelectedRows();
                    outer : for(int i = 0; i < selectedRows.length; i++) {
                        
                        Flight f = (Flight)tblSearchFlight.getValueAt(selectedRows[i], 0);
                        
                        for(int j = i+1; j < selectedRows.length; j++) {
                            Flight f1 = (Flight)tblSearchFlight.getValueAt(selectedRows[j], 0);
                            
                            if(f1.getFlightSchedule().getSource().equals(f.getFlightSchedule().getSource())) {
                                JOptionPane.showMessageDialog(null, "Two flights with same source and destination can not be selected");
                                break outer;
                            }
                        }
                        readyToBookCount++;
                        flightToBook.add(f);
                        
                        /*
                        Flight f = (Flight)tblSearchFlight.getValueAt(selectedRows[i], 0);
                        
                        if( i > 0) {
                            Flight f1 = (Flight)tblSearchFlight.getValueAt(selectedRows[i-1], 0);
                            
                            if(f1.getFlightSchedule().getSource().equals(f.getFlightSchedule().getSource())) {
                                
                            } else {
                                flightToBook.add(f);
                            }
                            
                        }else {
                            flightToBook.add(f);
                        }
                        */

                        
                        
                    }
                }
                
                if(readyToBookCount == tblSearchFlight.getSelectedRows().length) {
                    BookFlightJPanel1 searchFlightJPanel = new BookFlightJPanel1(this.panel, airlineDirectory, airplaneDirectory, masterTravelSchedule, flightToBook, custDir, cust, reservationDirectory, reservation);
                    this.panel.add(searchFlightJPanel, "SearchFlightJPanel");
                    CardLayout layout = (CardLayout)this.panel.getLayout();
                    layout.next(panel);
                }
            }
        }else {
            JOptionPane.showMessageDialog(null, "Please create an active customer before booking a flight");
        }
        
        /*
        int selectedRow1 = tblSearchFlight.getSelectedRow();
        int selectedRow2 = tblSearchRoundTripFlights.getSelectedRow();
        ArrayList<Flight> flightToBook = new ArrayList<>();
        
        if(selectedRow1<0) {
            JOptionPane.showMessageDialog(null, "Please select a Flight1");
        }
        else if(selectedRow2<0 && roundTripRB.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select a Flight2");
        }
        else {
            Flight f1;
            Flight f = (Flight)tblSearchFlight.getValueAt(selectedRow1, 0);
            if(roundTripRB.isSelected()) {
                f1 = (Flight)tblSearchRoundTripFlights.getValueAt(selectedRow2, 0);
                flightToBook.add(f1);
            }
            flightToBook.add(f);
            
            BookFlightJPanel1 searchFlightJPanel = new BookFlightJPanel1(this.panel, airlineDirectory, masterTravelSchedule, flightToBook, custDir, reservationDirectory);
            this.panel.add(searchFlightJPanel, "SearchFlightJPanel");
            CardLayout layout = (CardLayout)this.panel.getLayout();
            layout.next(panel);
        }
        */
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
        dtmMultiCity.setRowCount(dtmMultiCity.getRowCount() + 1);
        if(dtmMultiCity.getRowCount() == 1) {
            deleteRow.setEnabled(false);
        }else {
            deleteRow.setEnabled(true);
        }
    }//GEN-LAST:event_addRowActionPerformed

    private void deleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRowActionPerformed
        int selectedRow = tblMultiCity.getSelectedRow();
        if(dtmMultiCity.getRowCount() == 2) {
            deleteRow.setEnabled(false);
        }else {
            deleteRow.setEnabled(true);
        }
        
        if(selectedRow>=0){
            dtmMultiCity.removeRow(selectedRow);
        }else{
            JOptionPane.showMessageDialog(null, "Please select a row to remove");
        }
    }//GEN-LAST:event_deleteRowActionPerformed

    private void btnBackSearchFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackSearchFlightsActionPerformed
        // TODO add your handling code here:
        //this.panel.remove(this);
        //CardLayout layout = (CardLayout) this.panel.getLayout();
        //layout.previous(panel);
        /*
System.out.println(">>>--- inside seach flight back btn >>>---");
        this.panel.remove(this);
        CardLayout layout = (CardLayout)this.panel.getLayout();
        Component[] comps = this.panel.getComponents();
        for (Component comp : comps){
            if(comp instanceof ManageTravelAgency){
                ManageTravelAgency rePopulateTable = (ManageTravelAgency) comp;
                //rePopulateTable.populate();
            }
        }
        layout.previous(panel);
        System.out.println(">>>--- exit book flight back btn >>>---");
        */
        ManageTravelAgency manageTravelAgency = new ManageTravelAgency(panel, airlineDirectory, airplaneDirectory, masterTravelSchedule, custDir, cust, reservationDirectory, reservation);
        this.panel.add(manageTravelAgency, "ManageTravelAgency");
        CardLayout layout = (CardLayout)this.panel.getLayout();
        layout.next(panel); 
        
    }//GEN-LAST:event_btnBackSearchFlightsActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        populate();
        hideTables();
        hideRoundTripFields();
        hideMulticityFields();
    }//GEN-LAST:event_formAncestorAdded

    private void destinationComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationComboActionPerformed
    
    private void populateSearch() {
        /*DefaultTableModel dtm = (DefaultTableModel) tblSearchFlight.getModel();
        dtm.setRowCount(0);
        for (Flight f : masterTravelSchedule.searchFlight(searchTxtFlight, source, destination)) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = f;
            row[1] = f.getFlightSchedule().getSource();
            row[2] = f.getFlightSchedule().getDestination();
            dtm.addRow(row);
        }
          System.out.println("---------SEARCHED FLIGHTS------------");
          System.out.println("===>> SEARCHED FLIGHT" + masterTravelSchedule.searchFlight(searchTxtFlight, source, destination));
           */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker aDatePicker;
    private javax.swing.JButton addRow;
    private javax.swing.JButton btnBackSearchFlights;
    private javax.swing.JLabel dDateLabel;
    private com.github.lgooddatepicker.components.DatePicker dDatePicker;
    private javax.swing.JButton deleteRow;
    private javax.swing.JComboBox<String> destinationCombo;
    private javax.swing.JComboBox<String> destinationCombo1;
    private javax.swing.ButtonGroup flightSearchOptions;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton multiCityRB;
    private javax.swing.JRadioButton oneWayRB;
    private javax.swing.JLabel rDateLabel;
    private javax.swing.JRadioButton roundTripRB;
    private javax.swing.JButton searchFlight;
    private javax.swing.JComboBox<String> sourceCombo;
    private javax.swing.JComboBox<String> sourceCombo1;
    private javax.swing.JTable tblMultiCity;
    private javax.swing.JTable tblSearchFlight;
    private javax.swing.JTable tblSearchRoundTripFlights;
    // End of variables declaration//GEN-END:variables
}
