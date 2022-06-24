/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JFrame;
import java.awt.Container;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import  ConnectDB.ConnectionOracle;
import java.awt.EventQueue;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRAbstractChartCustomizer;
import net.sf.jasperreports.engine.JRRenderable;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

public class ReportViewer extends JFrame{
    
    public ReportViewer(String fileName) throws SQLException
    {
        this(fileName,null);
    } 
    
    public ReportViewer(String fileName, HashMap parameter) throws SQLException
    {
        super("View report");
        try
        {
            JasperReport jsr=JasperCompileManager.compileReport(fileName);
            JasperPrint print = JasperFillManager.fillReport(jsr, parameter,ConnectionOracle.getOracleConnection());
            JRViewer view = new JRViewer(print);
            Container c =  getContentPane();
            c.add(view);
        }catch(ClassNotFoundException | SQLException | JRException e)
        {
        }
        setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
