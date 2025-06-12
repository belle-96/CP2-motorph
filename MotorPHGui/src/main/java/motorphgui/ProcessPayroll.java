/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package motorphgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessPayroll extends javax.swing.JFrame {

    private JTable payrollTable;
    private JScrollPane jScrollPane3;
    private JButton btnBack;

    public ProcessPayroll() {
        initComponents();
        loadPayrollData();
    }

    private void initComponents() {
        jScrollPane3 = new javax.swing.JScrollPane();
        payrollTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Payroll Processing");

        payrollTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Employee ID", "Basic Salary", "SSS", "PhilHealth", "Pag-ibig", "Tax", "Total Deductions", "Net Pay"}
        ));
        jScrollPane3.setViewportView(payrollTable);

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
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBack)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MainDialog(new javax.swing.JFrame(), true).setVisible(true);
    }

private void loadPayrollData() {
    String employeeCsvPath = "C:\\Users\\HP\\OneDrive\\Desktop\\CP2\\Motorph\\employee.csv";
    List<PayrollRecord> payrollList = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(employeeCsvPath))) {
        String line;
        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            // Basic safety check: must have at least 12 fields (index 0–11)
            if (data.length < 12) {
                System.out.println("Skipping incomplete line: " + line);
                continue;
            }

            try {
                // Use appropriate index: column 11 is "Basic Salary"
                String employeeName = data[0].trim(); // Or build Employee ID from Name if you want
                double basicSalary = Double.parseDouble(data[11].trim());

                // Use basicSalary (not undefined 'salary')
                double sss = DeductionsCalculator.computeSSS(basicSalary);
                double philHealth = DeductionsCalculator.computePhilHealth(basicSalary);
                double pagibig = DeductionsCalculator.computePagibig(basicSalary);
                double tax = DeductionsCalculator.computeWithholdingTax(basicSalary);

                double totalDeductions = sss + philHealth + pagibig + tax;
                double netPay = basicSalary - totalDeductions;

                PayrollRecord record = new PayrollRecord(employeeName, basicSalary, sss, philHealth, pagibig, tax, totalDeductions, netPay);
                payrollList.add(record);

            } catch (NumberFormatException nfe) {
                System.out.println("Skipping row due to invalid number format: " + line);
            }
        }

        DefaultTableModel model = (DefaultTableModel) payrollTable.getModel();
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
    }}
}
    