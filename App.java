/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

// imports
import Model.*;
import Classes.*;
import Components.RootPanel;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.sql.SQLException;
import java.awt.CardLayout;

/**
 *
 * @author Sentinail
 */

public class App extends javax.swing.JFrame {
    // Initialize
    public App() {
        initComponents();
    }

    // Components
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        rootPanel = new Components.RootPanel();
        dashboard = new Views.Dashboard();
        dashboardSidebar1 = new Components.DashboardSidebar();
        dashboardSideBarLogo1 = new Components.DashboardSideBarLogo();
        dashboardSideBarNavigationButton1 = new Components.DashboardSideBarNavigationButton("Sales & Reservation")
        ;
        dashboardSideBarNavigationButton2 = new Components.DashboardSideBarNavigationButton("Block Creator")  ;
        dashboardSideBarNavigationButton4 = new Components.DashboardSideBarNavigationButton("Lot Creator")  ;
        dashboardBody1 = new Components.DashboardBody();
        salesAndReservation1 = new Views.SalesAndReservation();
        lotSearchPanel1 = new Components.LotSearchPanel();
        login = new Views.Login();
        loginBanner3 = new Components.LoginBanner();
        loginBannerLogo1 = new Components.LoginBannerLogo();
        loginForm2 = new Components.LoginForm();
        loginButton = new Components.LoginButton();
        loginUsernameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        loginTitle1 = new Components.LoginTitle();
        jLabel7 = new javax.swing.JLabel();
        hyperlinkLabelLogin1 = new Components.HyperlinkLabelLogin();
        loginPasswordField = new javax.swing.JPasswordField();
        register = new Views.Register();
        registerBanner1 = new Components.RegisterBanner();
        registerBannerLogo2 = new Components.RegisterBannerLogo();
        registerForm1 = new Components.RegisterForm();
        registerTitle1 = new Components.RegisterTitle();
        registerButton = new Components.RegisterButton();
        registerUsernameField = new javax.swing.JTextField();
        registerPasswordField = new javax.swing.JPasswordField();
        registerConfirmPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hyperlinkLabelRegister1 = new Components.HyperlinkLabelRegister();
        jLabel5 = new javax.swing.JLabel();
        registerLastnameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        registerFirstnameField = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        dashboardSideBarNavigationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {   
                dashboardSideBarNavigationButton1ActionPerformed(evt);
            }
        });

        dashboardSideBarNavigationButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardSideBarNavigationButton2ActionPerformed(evt);
            }
        });

        dashboardSideBarNavigationButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardSideBarNavigationButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardSidebar1Layout = new javax.swing.GroupLayout(dashboardSidebar1);
        dashboardSidebar1.setLayout(dashboardSidebar1Layout);
        dashboardSidebar1Layout.setHorizontalGroup(
            dashboardSidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardSidebar1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dashboardSideBarLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardSidebar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dashboardSidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboardSideBarNavigationButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardSideBarNavigationButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardSideBarNavigationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboardSidebar1Layout.setVerticalGroup(
            dashboardSidebar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardSidebar1Layout.createSequentialGroup()
                .addComponent(dashboardSideBarLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dashboardSideBarNavigationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dashboardSideBarNavigationButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dashboardSideBarNavigationButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 349, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout salesAndReservation1Layout = new javax.swing.GroupLayout(salesAndReservation1);
        salesAndReservation1.setLayout(salesAndReservation1Layout);
        salesAndReservation1Layout.setHorizontalGroup(
            salesAndReservation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesAndReservation1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lotSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        salesAndReservation1Layout.setVerticalGroup(
            salesAndReservation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesAndReservation1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lotSearchPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        dashboardBody1.add(salesAndReservation1, "card2");

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addComponent(dashboardSidebar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dashboardBody1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardSidebar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardBody1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        rootPanel.add(dashboard, "card4");

        login.setLayout(new javax.swing.BoxLayout(login, javax.swing.BoxLayout.LINE_AXIS));

        loginBanner3.setLayout(new java.awt.BorderLayout());
        loginBanner3.add(loginBannerLogo1, java.awt.BorderLayout.CENTER);

        login.add(loginBanner3);

        loginButton.setPreferredSize(new java.awt.Dimension(294, 31));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        loginUsernameField.setMaximumSize(new java.awt.Dimension(294, 31));
        loginUsernameField.setPreferredSize(new java.awt.Dimension(294, 31));
        loginUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Username");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Password");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Don't have an account ?");

        loginPasswordField.setPreferredSize(new java.awt.Dimension(294, 31));
        loginPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginForm2Layout = new javax.swing.GroupLayout(loginForm2);
        loginForm2.setLayout(loginForm2Layout);
        loginForm2Layout.setHorizontalGroup(
            loginForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginForm2Layout.createSequentialGroup()
                .addGroup(loginForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginForm2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(loginTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginForm2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(loginForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loginUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(loginForm2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hyperlinkLabelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        loginForm2Layout.setVerticalGroup(
            loginForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginForm2Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(loginTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(hyperlinkLabelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175))
        );

        login.add(loginForm2);

        rootPanel.add(login, "card3");

        register.setAlignmentX(0.0F);
        register.setAlignmentY(0.0F);
        register.setLayout(new javax.swing.BoxLayout(register, javax.swing.BoxLayout.LINE_AXIS));

        registerBanner1.setAlignmentX(0.0F);
        registerBanner1.setAlignmentY(0.0F);
        registerBanner1.setLayout(new java.awt.BorderLayout());
        registerBanner1.add(registerBannerLogo2, java.awt.BorderLayout.CENTER);

        register.add(registerBanner1);

        registerForm1.setAlignmentX(0.0F);
        registerForm1.setAlignmentY(0.0F);

        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        registerUsernameField.setMaximumSize(new java.awt.Dimension(294, 31));
        registerUsernameField.setPreferredSize(new java.awt.Dimension(294, 31));
        registerUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUsernameFieldActionPerformed(evt);
            }
        });

        registerPasswordField.setPreferredSize(new java.awt.Dimension(294, 31));
        registerPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPasswordFieldActionPerformed(evt);
            }
        });

        registerConfirmPasswordField.setPreferredSize(new java.awt.Dimension(294, 31));
        registerConfirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerConfirmPasswordFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Confirm Password");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Already have an account ?");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Lastname");

        registerLastnameField.setMaximumSize(new java.awt.Dimension(294, 31));
        registerLastnameField.setPreferredSize(new java.awt.Dimension(294, 31));
        registerLastnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLastnameFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Firstname");

        registerFirstnameField.setMaximumSize(new java.awt.Dimension(294, 31));
        registerFirstnameField.setPreferredSize(new java.awt.Dimension(294, 31));
        registerFirstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFirstnameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerForm1Layout = new javax.swing.GroupLayout(registerForm1);
        registerForm1.setLayout(registerForm1Layout);
        registerForm1Layout.setHorizontalGroup(
            registerForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerForm1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(registerForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerForm1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hyperlinkLabelRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(registerTitle1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerFirstnameField, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerLastnameField, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerUsernameField, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerPasswordField, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerConfirmPasswordField, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerButton, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        registerForm1Layout.setVerticalGroup(
            registerForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerForm1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(registerTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerFirstnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerLastnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registerForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(hyperlinkLabelRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        register.add(registerForm1);

        rootPanel.add(register, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPasswordFieldActionPerformed

    private void registerUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsernameFieldActionPerformed

    // Register
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // Collect
        String fname = registerFirstnameField.getText();
        String lname = registerLastnameField.getText();
        String userName = registerUsernameField.getText();

        char[] passwordChars = registerPasswordField.getPassword();
        String password = new String(passwordChars);

        char[] confirmPasswordChars = registerConfirmPasswordField.getPassword();
        String confirmPassword = new String(confirmPasswordChars);

        // Validate
        if (fname.isEmpty() || lname.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Match
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create
        String role = "CUSTOMER";

        User newUser = new User(0, userName, password, fname, lname, role); // ID is auto-incremented

        UserModel userModel = new UserModel();

        try {
            // Save
            User createdUser = userModel.create(newUser);

            if (createdUser != null) {
                JOptionPane.showMessageDialog(this, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Redirect
                RootPanel rootPanel = (RootPanel) SwingUtilities.getAncestorOfClass(RootPanel.class, registerButton);

                if (rootPanel != null) {
                    // Navigate
                    Component[] components = rootPanel.getComponents();
                    JPanel loginPanel = null;

                    for (Component comp : components) {
                        if (comp instanceof JPanel && "login".equals(comp.getName())) {
                            loginPanel = (JPanel) comp;
                            break;
                        }
                    }

                    if (loginPanel != null) {
                        rootPanel.removeAll();
                        rootPanel.add(loginPanel);
                        rootPanel.repaint();
                        rootPanel.revalidate();
                    } else {
                        JOptionPane.showMessageDialog(this, "Something went wrong redirecting to login", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Something went wrong redirecting to login", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to register user.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (java.sql.SQLException e) {
            // Duplicate
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void registerLastnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLastnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerLastnameFieldActionPerformed

    private void registerFirstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFirstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerFirstnameFieldActionPerformed

    private void registerConfirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerConfirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerConfirmPasswordFieldActionPerformed


    // Submit
    private void loginUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameFieldActionPerformed

    // Login
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = loginUsernameField.getText();
        char[] passwordChars = loginPasswordField.getPassword();
        String password = new String(passwordChars);

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserModel userModel = new UserModel();

        try {
            // Authenticate
            User user = userModel.authenticate(username, password);

            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Dashboard
                rootPanel.view("card4");

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void loginPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPasswordFieldActionPerformed

    // Navigate
    private void dashboardSideBarNavigationButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardSideBarNavigationButton4ActionPerformed
        // Lots
        Views.LotCreator lotCreator = new Views.LotCreator(lotSearchPanel1);
        dashboardBody1.add(lotCreator, "lotCreator");
        CardLayout cardLayout = (CardLayout) dashboardBody1.getLayout();
        cardLayout.show(dashboardBody1, "lotCreator");
    }//GEN-LAST:event_dashboardSideBarNavigationButton4ActionPerformed

    // Navigate
    private void dashboardSideBarNavigationButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardSideBarNavigationButton2ActionPerformed
        // Blocks
        Views.BlockCreator blockCreator = new Views.BlockCreator();
        dashboardBody1.add(blockCreator, "blockCreator");
        CardLayout cardLayout = (CardLayout) dashboardBody1.getLayout();
        cardLayout.show(dashboardBody1, "blockCreator");
    }//GEN-LAST:event_dashboardSideBarNavigationButton2ActionPerformed

    // Navigate
    private void dashboardSideBarNavigationButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardSideBarNavigationButton1ActionPerformed
        // Sales
    CardLayout cardLayout = (CardLayout) dashboardBody1.getLayout();
    cardLayout.show(dashboardBody1, "card2");
    }//GEN-LAST:event_dashboardSideBarNavigationButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

     // Launch
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Start
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Dashboard dashboard;
    private Components.DashboardBody dashboardBody1;
    private Components.DashboardSideBarLogo dashboardSideBarLogo1;
    private Components.DashboardSideBarNavigationButton dashboardSideBarNavigationButton1;
    private Components.DashboardSideBarNavigationButton dashboardSideBarNavigationButton2;
    private Components.DashboardSideBarNavigationButton dashboardSideBarNavigationButton4;
    private Components.DashboardSidebar dashboardSidebar1;
    private Components.HyperlinkLabelLogin hyperlinkLabelLogin1;
    private Components.HyperlinkLabelRegister hyperlinkLabelRegister1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private Views.Login login;
    private Components.LoginBanner loginBanner3;
    private Components.LoginBannerLogo loginBannerLogo1;
    private Components.LoginButton loginButton;
    private Components.LoginForm loginForm2;
    private javax.swing.JPasswordField loginPasswordField;
    private Components.LoginTitle loginTitle1;
    private javax.swing.JTextField loginUsernameField;
    private Components.LotSearchPanel lotSearchPanel1;
    private Views.Register register;
    private Components.RegisterBanner registerBanner1;
    private Components.RegisterBannerLogo registerBannerLogo2;
    private Components.RegisterButton registerButton;
    private javax.swing.JPasswordField registerConfirmPasswordField;
    private javax.swing.JTextField registerFirstnameField;
    private Components.RegisterForm registerForm1;
    private javax.swing.JTextField registerLastnameField;
    private javax.swing.JPasswordField registerPasswordField;
    private Components.RegisterTitle registerTitle1;
    private javax.swing.JTextField registerUsernameField;
    private Components.RootPanel rootPanel;
    private Views.SalesAndReservation salesAndReservation1;
    // End of variables declaration//GEN-END:variables
}
