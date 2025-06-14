
package motorphgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessPayroll extends javax.swing.JFrame {

    public ProcessPayroll() {
        initComponents();
        loadPayrollData();
    }

private void loadPayrollData() {
    String employeeCsvPath = "C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv";
    List<PayrollRecord> payrollList = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(employeeCsvPath))) {
        String line;
        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            // Basic safety check: must have at least 15 fields
            if (data.length < 15) {
                System.out.println("Skipping incomplete line: " + line);
                continue;
            }

            try {
                String employeeId = data[0].trim(); // Assuming Employee # is in column 0
                double basicSalary = Double.parseDouble(data[11].trim());
                double riceSubsidy = Double.parseDouble(data[12].trim());
                double phoneAllowance = Double.parseDouble(data[13].trim());
                double clothingAllowance = Double.parseDouble(data[14].trim());

                // Deductions based on Basic Salary only
                double sss = DeductionsCalculator.computeSSS(basicSalary);
                double philHealth = DeductionsCalculator.computePhilHealth(basicSalary);
                double pagibig = DeductionsCalculator.computePagibig(basicSalary);
                double tax = DeductionsCalculator.computeWithholdingTax(basicSalary);

                double totalDeductions = sss + philHealth + pagibig + tax;

                // Gross includes allowances
                double grossSalary = basicSalary + riceSubsidy + phoneAllowance + clothingAllowance;
                double netPay = grossSalary - totalDeductions;

                PayrollRecord record = new PayrollRecord(
                    employeeId, grossSalary, sss, philHealth, pagibig, tax, totalDeductions, netPay
                );
                payrollList.add(record);

            } catch (NumberFormatException nfe) {
                System.out.println("Skipping row due to invalid number format: " + line);
            }
        }

        DefaultTableModel model = (DefaultTableModel) payrollTable.getModel();
        model.setRowCount(0); // Clear existing rows first
        for (PayrollRecord record : payrollList) {
            model.addRow(new Object[]{
                record.getEmployeeId(),
                String.format("%.2f", record.getBasicSalary()),
                String.format("%.2f", record.getSss()),
                String.format("%.2f", record.getPhilHealth()),
                String.format("%.2f", record.getPagibig()),
                String.format("%.2f", record.getTax()),
                String.format("%.2f", record.getTotalDeductions()),
                String.format("%.2f", record.getNetPay())
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading payroll data: " + e.getMessage());
    }
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
            java.util.logging.Logger.getLogger(ProcessPayroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new ProcessPayroll().setVisible(true));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        payrollTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        payrollTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Gross Income", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "SSS", "PhilHealth", "Pag-ibig", "Tax", "Total Deductions", "Net Pay"
            }
        ));
        jScrollPane1.setViewportView(payrollTable);

        btnBack.setText("Back to Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        new MainDialog(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable payrollTable;
    // End of variables declaration//GEN-END:variables
}
