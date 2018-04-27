package cdp2.mindle.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cdp2.mindle.manager.InformationManager;

public class InformationPanel extends JPanel
{
	InformationManager informationManager;
	JLabel[] labels;
	JTextField nameInputField;
	JTextField codeInputField;
	JCheckBox targetMaleCheckbox;
	JCheckBox targetFemaleCheckbox;
	JCheckBox targetOldCheckbox;
	JCheckBox targetAdultCheckbox;
	JCheckBox targetTeenCheckbox;
	JCheckBox targetChildCheckbox;
	JComboBox<String> languageCombobox;
	JButton addButton;
	JButton deleteButton;
	JTable extensionInfoTable;
	JScrollPane extensionPane;
	
	final String[] labelString = new String[] {
			"�̸� : ", 
			"�ĺ� �ڵ� : ",
			"���",
			"(�ߺ� ����)",
			"��� : ",
			"�߰� ����"
	};
	final String[] nationString = new String[] {
			"Korean", "English", "French", "Japanese", "Chinese"
	};
	
	public InformationPanel()
	{
		informationManager = new InformationManager();
		labels = new JLabel[6];
		for (int i = 0; i < labels.length; ++i) {
			labels[i] = new JLabel(labelString[i]);
			labels[i].setFont(new Font("����", Font.PLAIN, 15));
		}
		nameInputField = new JTextField(40);
		codeInputField = new JTextField(40);
		languageCombobox = new JComboBox<>(nationString);
		addButton = new JButton("�߰�");
		deleteButton = new JButton("����");
		
		initExtensionInfoTable();
		initTargetCheckbox();
		initLayout();
	}
	
	private void initTargetCheckbox()
	{
		targetMaleCheckbox = new JCheckBox("����");
		targetFemaleCheckbox = new JCheckBox("����");
		targetOldCheckbox = new JCheckBox("����");
		targetAdultCheckbox = new JCheckBox("����");
		targetTeenCheckbox = new JCheckBox("û�ҳ�");
		targetChildCheckbox = new JCheckBox("�Ƶ�");
		
		targetMaleCheckbox.setFont(new Font("����", Font.PLAIN, 15));
		targetFemaleCheckbox.setFont(new Font("����", Font.PLAIN, 15));
		targetOldCheckbox.setFont(new Font("����", Font.PLAIN, 15));
		targetAdultCheckbox.setFont(new Font("����", Font.PLAIN, 15));
		targetTeenCheckbox.setFont(new Font("����", Font.PLAIN, 15));
		targetChildCheckbox.setFont(new Font("����", Font.PLAIN, 15));
	}
	
	private void initExtensionInfoTable()
	{
		String columnNames[] =
			{ "No.", "Ÿ��", "����", "����"};

			Object rowData[][] =
			{
			{ 1, "����", "J.Smith", false },
			{ 2, "�ۼ��⵵", "1996", false },
			{ 3, "�ۼ�����", "2018.4.27", false }
			};
			
			extensionInfoTable = new JTable(rowData, columnNames);
			extensionInfoTable.getColumnModel().getColumn(0).setMaxWidth(50);
			extensionInfoTable.getColumnModel().getColumn(3).setMaxWidth(50);
			for (int i = 0; i < rowData.length; ++i) {
				extensionInfoTable.setRowHeight(i, 20);
			}
			extensionInfoTable.setFont(new Font("����", Font.PLAIN, 20));
			extensionPane = new JScrollPane(extensionInfoTable);
			extensionPane.setPreferredSize(new Dimension(300, 10));
	}
	
	private void initLayout()
	{
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setVerticalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(labels[0])
				           .addComponent(nameInputField))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(labels[1])
					           .addComponent(codeInputField))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(labels[2])
					           .addComponent(targetMaleCheckbox)
					           .addComponent(targetFemaleCheckbox))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(labels[3])
					           .addComponent(targetOldCheckbox)
					           .addComponent(targetAdultCheckbox)
					           .addComponent(targetTeenCheckbox)
					           .addComponent(targetChildCheckbox))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(labels[4])
					           .addComponent(languageCombobox))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(labels[5])
					           .addComponent(addButton)
					           .addComponent(deleteButton))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				    		  .addComponent(extensionPane))
				);
		
		layout.setHorizontalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(labels[0])
				           .addComponent(labels[1])
				           .addComponent(labels[2])
				           .addComponent(labels[3])
				           .addComponent(labels[4])
				           .addComponent(labels[5])
				           )
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				    		  .addComponent(nameInputField)
				    		  .addComponent(codeInputField)
				    		  .addGroup(layout.createSequentialGroup()
				    				  .addComponent(targetMaleCheckbox)
				    				  .addComponent(targetFemaleCheckbox)
				    				  )
				    		  .addGroup(layout.createSequentialGroup()
				    				  .addComponent(targetOldCheckbox)
				    				  .addComponent(targetAdultCheckbox)
				    				  .addComponent(targetTeenCheckbox)
				    				  .addComponent(targetChildCheckbox)
				    				  )
				    		  .addGroup(layout.createSequentialGroup()
				    				  .addComponent(languageCombobox)
				    		  )
				    		  .addGroup(layout.createSequentialGroup()
				    				  .addComponent(addButton)
				    				  .addComponent(deleteButton)
				    		  )
				    		  .addComponent(extensionPane)
				    	)
				);
	}
}
