package gradle_study.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DepartmentUI extends JFrame {

	private JPanel contentPane;
	private JTextField textDeptNo;
	private JTextField textDeptName;
	private JTextField textFloor;
	private JPanel pDept;
	private JLabel lblFloor;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public DepartmentUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pDept = new JPanel();
		contentPane.add(pDept);
		pDept.setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblDeptNo = new JLabel("New label");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		pDept.add(lblDeptNo);
		
		textDeptNo = new JTextField();
		pDept.add(textDeptNo);
		textDeptNo.setColumns(10);
		
		JLabel lblDeptName = new JLabel("New label");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		pDept.add(lblDeptName);
		
		textDeptName = new JTextField();
		pDept.add(textDeptName);
		textDeptName.setColumns(10);
		
		lblFloor = new JLabel("New label");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		pDept.add(lblFloor);
		
		textFloor = new JTextField();
		pDept.add(textFloor);
		textFloor.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnAdd = new JButton("\uCD94\uAC00");
		panel_1.add(btnAdd);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		panel_1.add(btnCancel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}

}
