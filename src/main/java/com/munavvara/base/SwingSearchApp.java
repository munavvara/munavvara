package com.munavvara.base;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SwingSearchApp extends JFrame implements ActionListener{
	//Initializing Components
    JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb5d;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf11, tf12, tf5d;
    JButton btn, btn11, btn12, btn13, btn14, btn15;
    
    int book_entry_id = -1;
    int borrower = -1;
    boolean putnew = false;
    boolean update = false;
    /*
    private getDate(){
    	java.sql.Date date = resultSet.getDate("bdate");
    	java.sql.Date date = resultSet.getDate("theDateColumn");
    	
    	String s = "01/28/2013";
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	java.util.Date d = df.parse(s);
    	java.sql.Date date = new java.sql.Date(d.getTime());
    }
 */
    //Creating Constructor for initializing JFrame components
    SwingSearchApp() {
        //Providing Title
        super("Fetching Book Information");
        lb5 = new JLabel("Enter Reg. No.:");
        lb5.setBounds(20, 20, 100, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 100, 20);
        
        // btn12.setBounds(350, 420, 100, 20);
        lb5d = new JLabel("Enter Section:");
        lb5d.setBounds(250, 20, 100, 20);
        tf5d = new JTextField(20);
        tf5d.setBounds(350, 20, 50, 20);
 
        btn = new JButton("Submit");
        btn.setBounds(50, 50, 100, 20);
        btn.addActionListener(this);
        btn.setActionCommand("1");
 
        lb = new JLabel("Fetching Book Information From Database");
        lb.setBounds(30, 80, 450, 30);
        lb.setForeground(Color.red);
        lb.setFont(new Font("Serif", Font.BOLD, 20));
        setVisible(true);
        
        lb10 = new JLabel("Borrowers Information");
        lb10.setBounds(30, 360, 450, 30);
        lb10.setForeground(Color.red);
        lb10.setFont(new Font("Serif", Font.BOLD, 20));
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
 
        //REG. NO.	SECTION	ISBN	TITLE	AUTHOR	PUBLISHER	PUB. DATE	REMARKS

        lb1 = new JLabel("REG. NO.");
        lb1.setBounds(20, 120, 100, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 120, 200, 20);
        
        btn15 = new JButton("New");
        btn15.setBounds(350, 120, 100, 20);
        btn15.addActionListener(this);
        btn15.setActionCommand("7");
        
        lb2 = new JLabel("SECTION:");
        lb2.setBounds(20, 150, 100, 20);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 150, 200, 20);
        
        lb4 = new JLabel("ISBN:");
        lb4.setBounds(20, 210, 100, 20);
        tf4 = new JTextField(50);
        tf4.setBounds(130, 210, 100, 20);
        
        lb3 = new JLabel("TITLE:");
        lb3.setBounds(20, 180, 100, 20);
        tf3 = new JTextField(50);
        tf3.setBounds(130, 180, 200, 20);
        
        lb6 = new JLabel("AUTHOR:");
        lb6.setBounds(20, 240, 100, 20);
        tf6 = new JTextField(50);
        tf6.setBounds(130, 240, 200, 20);
        
        lb7 = new JLabel("PUBLISHER:");
        lb7.setBounds(20, 270, 100, 20);
        tf7 = new JTextField(50);
        tf7.setBounds(130, 270, 200, 20);
        
        lb8 = new JLabel("PUB. DATE:");
        lb8.setBounds(20, 300, 100, 20);
        tf8 = new JTextField(50);
        tf8.setBounds(130, 300, 200, 20);
        
        btn13 = new JButton("Insert");
        btn13.setBounds(350, 300, 100, 20);
        btn13.addActionListener(this);
        btn13.setActionCommand("5");
        
        lb9 = new JLabel("REMARKS:");
        lb9.setBounds(20, 330, 100, 20);
        tf9 = new JTextField(50);
        tf9.setBounds(130, 330, 200, 20);
        
        btn14 = new JButton("Update");
        btn14.setBounds(350, 330, 100, 20);
        btn14.addActionListener(this);
        btn14.setActionCommand("6");
        
        lb11 = new JLabel("NAME:");
        lb11.setBounds(20, 390, 100, 20);
        tf11 = new JTextField(50);
        tf11.setBounds(130, 390, 200, 20);
        
        btn11 = new JButton("Insert");
        btn11.setBounds(350, 390, 100, 20);
        btn11.addActionListener(this);
        btn11.setActionCommand("2");
        
        lb12 = new JLabel("DATE:");
        lb12.setBounds(20, 420, 100, 20);
        tf12 = new JTextField(50);
        tf12.setBounds(130, 420, 200, 20);
        
        btn12 = new JButton("Delete");
        btn12.setBounds(350, 420, 100, 20);
        btn12.addActionListener(this);
        btn12.setActionCommand("3");
        
        setLayout(null);
 
        //Add components to the JFrame
        add(lb5);
        add(tf5);
        add(btn);
 
        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(tf4);
 
        add(lb6);
        add(tf6);
        add(lb7);
        add(tf7);
        add(lb8);
        add(tf8);
        add(lb9);
        add(tf9);
        
        add(lb10);
        
        add(lb11);
        add(tf11);
        add(lb12);
        add(tf12);       
        
        add(btn11);
        add(btn12);
        
        add(lb5d);
        add(tf5d);
        
        add(btn13);
        add(btn14);
        
        add(btn15);
        
        //Set TextField Editable False
        tf11.setEditable(false);
        tf12.setEditable(false);
        
        btn11.setEnabled(false);
        btn12.setEnabled(false);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        
        btn13.setEnabled(false);
        btn14.setEnabled(false);
    }
 
    public void actionPerformed(ActionEvent e) {
        //Create DataBase Coonection and Fetching Records
    	
        try {
        	
        	if (e.getActionCommand() == "1"){
        	
	            String regn = tf5.getText();
	            String section = tf5d.getText();
	 
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
	            PreparedStatement st = con.prepareStatement("select * from maroshibooks where regnum=? and section=?");
	            st.setString(1, regn);
	            st.setString(2, section);
	 
	            //Excuting Query
	            ResultSet rs = st.executeQuery();
	 
	            if (rs.next()) {
	                book_entry_id = Integer.valueOf(rs.getString(1));
	                
	                String s2 = rs.getString(2);
	                String s3 = rs.getString(3);
	                String s4 = rs.getString(4);
	                String s5 = rs.getString(5);
	                String s6 = rs.getString(6);
	                String s7 = rs.getString(7);
	                String s8 = rs.getString(8);
	                String s9 = rs.getString(9);
	 
	                //Sets Records in TextFields.
	                tf1.setText(s2);
	                tf2.setText(s3);
	                
	                tf3.setText(s5);
	                tf4.setText(s4);
	                tf6.setText(s6);
	                
	                tf7.setText(s7);
	                if (s8.equals("0")){
	                	tf8.setText("");
	                }else{
	                	tf8.setText(s8);
	                }
	                tf9.setText(s9);
	                
	                btn11.setEnabled(true);
	                
	                tf1.setEditable(false);
	                tf2.setEditable(false);
	                tf3.setEditable(false);
	                tf4.setEditable(false);
	                
	                tf6.setEditable(false);
	                tf7.setEditable(false);
	                tf8.setEditable(false);
	                tf9.setEditable(false);
	                
	                btn13.setEnabled(false);
	                btn14.setEnabled(true);
	                
	                tf11.setEditable(true);
	                tf12.setEditable(true);
	                
	                btn15.setEnabled(false);

	             // book_entry_id
	            	PreparedStatement st1 = con.prepareStatement("select * from maroshibrrowers where book_entry_id=" + book_entry_id);
	            	ResultSet rs1 = st1.executeQuery();
	            	
	            	 tf11.setText("");
            		 tf12.setText("");
	            	
	            	if (rs1.next()){
	            		 borrower = Integer.valueOf(rs1.getString(1));
	            		 String name = rs1.getString(2);
	            		 String ret_day = rs1.getString(4);
	            		 
	            		 tf11.setText(name);
	            		 tf12.setText(ret_day);
	            		 
	            		 btn11.setEnabled(false);
	            		 btn12.setEnabled(true);
	            		 
	            	     tf11.setEditable(false);
	            	     tf12.setEditable(false);
	            	}
	            	
	            	con.close();
	            	
	            } else {
	                JOptionPane.showMessageDialog(null, "Book was not Found");
	            }
            }else if (e.getActionCommand() == "2"){
            	String name = tf11.getText();
            	String return_date = tf12.getText();
            	
            	if (name.isEmpty() || return_date.isEmpty() || book_entry_id == -1){
            		JOptionPane.showMessageDialog(null, "Wrong Parameters");
            	}else{
            		// book_entry_id
            		
            		Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
            		PreparedStatement stp = con.prepareStatement("insert into maroshibrrowers (name, book_entry_id, return_date) values('" + name + "' , " + book_entry_id + ", '" + return_date + "');");	            
            		stp.executeUpdate();
            		con.close();
            		
            		btn11.setEnabled(false);
            		btn12.setEnabled(true);
	            }
            }else if (e.getActionCommand() == "3"){
            	btn11.setEnabled(true);
            	
        		Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
        		PreparedStatement st = con.prepareStatement("delete from maroshibrrowers where book_entry_id="+ book_entry_id + ";");
        		st.executeUpdate();
        		con.close();
            	
            	tf11.setText("");
            	tf12.setText("");
            	
            	tf11.setEditable(true);
            	tf12.setEditable(true);
            	
            }else if (e.getActionCommand() == "7"){
            	if (putnew == false){
            		putnew = true;
	                tf1.setEditable(true);
	                tf2.setEditable(true);
	                tf3.setEditable(true);
	                tf4.setEditable(true);
	                
	                tf6.setEditable(true);
	                tf7.setEditable(true);
	                tf8.setEditable(true);
	                tf9.setEditable(true);
	                
	                if (book_entry_id == -1)
	                	btn13.setEnabled(true);
	                else
	                	btn14.setEnabled(true);
	                
	                tf5.setEditable(false);
	                tf5d.setEditable(false);
	                
	                btn.setEnabled(false);
            	}else if (putnew == true){
            		putnew = false;
	                tf1.setEditable(false);
	                tf2.setEditable(false);
	                tf3.setEditable(false);
	                tf4.setEditable(false);
	                
	                tf6.setEditable(false);
	                tf7.setEditable(false);
	                tf8.setEditable(false);
	                tf9.setEditable(false);
	                
	                btn13.setEnabled(false);
	                btn14.setEnabled(false);
	                
	                tf5.setEditable(true);
	                tf5d.setEditable(true);
	                
	                btn.setEnabled(true);
            	}
            }else if (e.getActionCommand() == "5"){
            	String regn = tf1.getText();
            	String section = tf2.getText();
            	String title = tf3.getText();
            	String isbn = tf4.getText();
            	
            	String author = tf6.getText();
            	String publisher = tf7.getText();
            	String pubdate = tf8.getText();
            	String remarks = tf9.getText();
            	
            	
            	if (regn.isEmpty() || section.isEmpty() 
            			|| book_entry_id != -1
            			|| title.isEmpty()
            			|| isbn.isEmpty()
            			|| author.isEmpty() || publisher.isEmpty()
            		){
            		JOptionPane.showMessageDialog(null, "Wrong Parameters");
            	}else{
            		// book_entry_id
            		
            		Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
            		PreparedStatement stp = con.prepareStatement("insert into maroshibooks (regnum, section, isbn, title, author, publisher, pubdate, remarks) values('" + regn + "' , '" + section + "', '" + title + "', '" + isbn + "', '" +author+ "', " + pubdate + ",'" + remarks +  "');");	            
            		stp.executeUpdate();
            		con.close();
	            }
            }else if (e.getActionCommand() == "6"){
            	
            	if (!update){
	                tf1.setEditable(true);
	                tf2.setEditable(true);
	                tf3.setEditable(true);
	                tf4.setEditable(true);
	                
	                tf6.setEditable(true);
	                tf7.setEditable(true);
	                tf8.setEditable(true);
	                tf9.setEditable(true);
	                update = true;
            	}else{
            		
            		
	            	String regn = tf1.getText();
	            	String section = tf2.getText();
	            	String title = tf3.getText();
	            	String isbn = tf4.getText();
	            	
	            	String author = tf6.getText();
	            	String publisher = tf7.getText();
	            	String pubdate = tf8.getText();
	            	String remarks = tf9.getText();
	            	
	            	if (pubdate.isEmpty()){
	            		pubdate = "0";
	            	}
	            	
	            	if ( book_entry_id == -1){
	            		JOptionPane.showMessageDialog(null, "Wrong Parameters");
	            	}
	            	
	            	if (regn.isEmpty() || section.isEmpty() 
	            			|| title.isEmpty()
	            			|| isbn.isEmpty()
	            			|| author.isEmpty() || publisher.isEmpty()
	            		){
	            		JOptionPane.showMessageDialog(null, "Wrong Parameters");
	            	}else{
	            		Class.forName("com.mysql.jdbc.Driver");
	            		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
	            		PreparedStatement stp = con.prepareStatement("update maroshibooks set regnum = '" + regn + "', section = '" + section + "' , isbn = '" +isbn + "', title = '" + title + "', author = '" + author + "', publisher = '" + publisher + "', pubdate = " + pubdate + ", remarks = '" + remarks + "' where entry_id = " + book_entry_id + ";");	            
	            		stp.executeUpdate();
	            		con.close();
	            		
	            		update = false;
		                tf1.setEditable(false);
		                tf2.setEditable(false);
		                tf3.setEditable(false);
		                tf4.setEditable(false);
		                
		                tf6.setEditable(false);
		                tf7.setEditable(false);
		                tf8.setEditable(false);
		                tf9.setEditable(false);
	        		}
            	}
            }
 
            //Create Exception Handler
        } catch (Exception ex) {
 
            System.out.println(ex);
        }
    }
//Running Constructor
 
    public static void main(String args[]) {
        new SwingSearchApp();
    }
} 

