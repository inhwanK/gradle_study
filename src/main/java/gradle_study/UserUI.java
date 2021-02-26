package gradle_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gradle_study.ui.DepartmentUI;
import gradle_study.ui.TitleUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class UserUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDepartment;
	private JButton btnTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI frame = new UserUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("UserUI");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel pbtn = new JPanel();
		contentPane.add(pbtn, BorderLayout.SOUTH);
		
		btnDepartment = new JButton("\uBD80\uC11C");
		btnDepartment.addActionListener(this);
		pbtn.add(btnDepartment);
		
		btnTitle = new JButton("\uC9C1\uCC45");
		btnTitle.addActionListener(this);
		pbtn.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
		if (e.getSource() == btnDepartment) {
			actionPerformedBtnDepartment(e);
		}
	}
	protected void actionPerformedBtnDepartment(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null, "부서버튼 클릭");
		DepartmentUI frame = new DepartmentUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnTitle(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "직책버튼 클릭");
		TitleUI frame = new TitleUI();
		frame.setVisible(true);
	}
}
