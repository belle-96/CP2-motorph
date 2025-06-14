
package motorphgui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainDialog extends javax.swing.JDialog {
    private java.awt.Frame parentFrame;
    private javax.swing.JTable payrollTable;
    private javax.swing.JScrollPane payrollScrollPane;
    private javax.swing.table.DefaultTableModel payrollTableModel;

    public MainDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadEmployeeTable();
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_MEDetails = new javax.swing.JButton();
        btn_MAttendance = new javax.swing.JButton();
        btn_MExit = new javax.swing.JButton();
        btn_MWHours = new javax.swing.JButton();
        btn_MPPayroll = new javax.swing.JButton();
        lbl_main = new javax.swing.JLabel();
        jButton1btnAddEmployee = new javax.swing.JButton();
        UpdateEmployee = new javax.swing.JButton();
        DeleteEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MotorPH Payroll System");

        btn_MEDetails.setText("Employee Details");
        btn_MEDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MEDetailsActionPerformed(evt);
            }
        });

        btn_MAttendance.setText("Attendance");
        btn_MAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MAttendanceActionPerformed(evt);
            }
        });

        btn_MExit.setText("Exit");
        btn_MExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MExitActionPerformed(evt);
            }
        });

        btn_MWHours.setText("Work Hours");
        btn_MWHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MWHoursActionPerformed(evt);
            }
        });

        btn_MPPayroll.setText("Process Payroll");
        btn_MPPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MPPayrollActionPerformed(evt);
            }
        });

        lbl_main.setFont(new java.awt.Font("Sans Serif Collection", 1, 18)); // NOI18N
        lbl_main.setText("MotorPH Payroll System");

        jButton1btnAddEmployee.setText("Add Employee");
        jButton1btnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1btnAddEmployeeActionPerformed(evt);
            }
        });

        UpdateEmployee.setText("Update Employee");
        UpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateEmployeeActionPerformed(evt);
            }
        });

        DeleteEmployee.setText("Delete Employee");
        DeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_MEDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_MAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_MWHours, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_main)
                    .addComponent(btn_MPPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_MExit, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1btnAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(UpdateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(DeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_main)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_MEDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_MAttendance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_MWHours)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_MPPayroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1btnAddEmployee)
                    .addComponent(UpdateEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_MExit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btn_MEDetailsActionPerformed(java.awt.event.ActionEvent evt) {                                              
//GEN-FIRST:event_btn_MEDetailsActionPerformed
        String searchId = JOptionPane.showInputDialog(this, "Enter Employee ID to search:");
        if (searchId != null && !searchId.trim().isEmpty()) {
            boolean found = false;
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv"))) {
                String line;
                boolean skipHeader = true;
                while ((line = br.readLine()) != null) {
                    if (skipHeader) {
                        skipHeader = false;
                        continue;
                    }
                    String[] data = line.split(",");
                    if (data.length > 0 && data[0].trim().equalsIgnoreCase(searchId.trim())) {
                        Employee emp = new Employee(data);
                        Employee_DetailsResult dialog = new Employee_DetailsResult(parentFrame, true);
                        dialog.setEmployeeDetails(emp);
                        dialog.setVisible(true);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "Employee ID not found.", "Not Found", JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading employee file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btn_MEDetailsActionPerformed
    private void btn_MAttendanceActionPerformed(java.awt.event.ActionEvent evt) {                                                
//GEN-FIRST:event_btn_MAttendanceActionPerformed
        View_Attendance attendance = new View_Attendance(null, true);
        attendance.setVisible(true);
    }//GEN-LAST:event_btn_MAttendanceActionPerformed

    private void btn_MExitActionPerformed(java.awt.event.ActionEvent evt) {                                          
//GEN-FIRST:event_btn_MExitActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btn_MExitActionPerformed

    private void btn_MWHoursActionPerformed(java.awt.event.ActionEvent evt) {                                            
//GEN-FIRST:event_btn_MWHoursActionPerformed
    View_Attendance workHours = new View_Attendance(null, true);
workHours.setVisible(true);
    }//GEN-LAST:event_btn_MWHoursActionPerformed

    private void btn_MPPayrollActionPerformed(java.awt.event.ActionEvent evt) {                                              
//GEN-FIRST:event_btn_MPPayrollActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new ProcessPayroll().setVisible(true);
        });
        EmployeeCSVReader reader = new EmployeeCSVReader();
        reader.readEmployees();
    }//GEN-LAST:event_btn_MPPayrollActionPerformed

    private void jButton1btnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1btnAddEmployeeActionPerformed
    AddEmployeeDialog addDialog = new AddEmployeeDialog(parentFrame, true);
    addDialog.setVisible(true);
    loadEmployeeTable();
    }//GEN-LAST:event_jButton1btnAddEmployeeActionPerformed

    private void UpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateEmployeeActionPerformed
    String searchId = JOptionPane.showInputDialog(this, "Enter Employee ID to update:");

    if (searchId != null && !searchId.trim().isEmpty()) {
        try {
            java.util.List<String[]> employeeList = new java.util.ArrayList<>();
            boolean found = false;

            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[0].equals(searchId)) {
                        found = true;
                        String newLastName = JOptionPane.showInputDialog(this, "Enter new Last Name:", data[1]);
                        String newFirstName = JOptionPane.showInputDialog(this, "Enter new First Name:", data[2]);
                        data[1] = newLastName;
                        data[2] = newFirstName;
                    }
                    employeeList.add(data);
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Employee ID not found.");
                return;
            }

            // Overwrite the CSV with updated data
            try (java.io.FileWriter writer = new java.io.FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv")) {
                for (String[] emp : employeeList) {
                    writer.write(String.join(",", emp));
                    writer.write("\n");
                }
            }

            JOptionPane.showMessageDialog(this, "Employee updated successfully.");
            loadEmployeeTable(); // Refresh table if needed

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating employee: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_UpdateEmployeeActionPerformed

    private void DeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployeeActionPerformed
    String deleteId = JOptionPane.showInputDialog(this, "Enter Employee ID to delete:");

    if (deleteId != null && !deleteId.trim().isEmpty()) {
        try {
            java.util.List<String[]> employeeList = new java.util.ArrayList<>();
            boolean found = false;

            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[0].equals(deleteId)) {
                        found = true; // Skip this row (delete)
                        continue;
                    }
                    employeeList.add(data);
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Employee ID not found.");
                return;
            }

            // Overwrite CSV without the deleted row
            try (java.io.FileWriter writer = new java.io.FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv")) {
                for (String[] emp : employeeList) {
                    writer.write(String.join(",", emp));
                    writer.write("\n");
                }
            }

            JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
            loadEmployeeTable(); // Refresh the table

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error deleting employee: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_DeleteEmployeeActionPerformed
    public void loadEmployeeTable() {
    // Clear the table model before loading
    if (payrollTableModel != null) {
        payrollTableModel.setRowCount(0);
    }

    new javax.swing.SwingWorker<Void, String[]>() {
        @Override
        protected Void doInBackground() {
            String csvFile = "C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv";
            String line;
            String csvSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                boolean skipHeader = true;
                while ((line = br.readLine()) != null) {
                    if (skipHeader) {
                        skipHeader = false;
                        continue;
                    }
                    String[] data = line.split(csvSplitBy);
                    publish(data); // Send to process() for GUI update
                }
            } catch (IOException e) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(MainDialog.this,
                            "Error loading employee data: " + e.getMessage(),
                            "File Error", JOptionPane.ERROR_MESSAGE);
                });
            }
            return null;
        }

        @Override
        protected void process(java.util.List<String[]> chunks) {
            for (String[] rowData : chunks) {
                payrollTableModel.addRow(rowData);
            }
        }
    }.execute();
}
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            MainDialog dialog = new MainDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteEmployee;
    private javax.swing.JButton UpdateEmployee;
    private javax.swing.JButton btn_MAttendance;
    private javax.swing.JButton btn_MEDetails;
    private javax.swing.JButton btn_MExit;
    private javax.swing.JButton btn_MPPayroll;
    private javax.swing.JButton btn_MWHours;
    private javax.swing.JButton jButton1btnAddEmployee;
    private javax.swing.JLabel lbl_main;
    // End of variables declaration//GEN-END:variables
} 
