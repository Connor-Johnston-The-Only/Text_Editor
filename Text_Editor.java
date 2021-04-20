/**
 * Connor Johnston
 * 
 * 
 * 
 * 1:28 - 2021 - 4 - 17
 */

import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;

public class Text_Editor{

//Public variables
	String s1 = "", s2 = "";
	String fileName = "";
	
	private JFrame frame;
	private Panel typeBeforeSave;
	private JButton tBFSButton;
	private Panel nameSavedFile;
	private TextField nSFTextField;
	private JButton nSFButton;
	private Panel resultOfSave;
	private JLabel rOSLabel;
	private JButton rOSButton;

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Text_Editor window = new Text_Editor();
					window.frame.setVisible(true);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}//run()
		});//End
	}//Man

	public Text_Editor() {
		initialize();
	}

	private void initialize() {

//Frame
		frame = new JFrame("Text Editor");
		frame.getContentPane();
		frame.setBounds(100, 100, 720, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//Panel
		typeBeforeSave = new Panel();
		nameSavedFile = new Panel();
		resultOfSave = new Panel();
		
//Label
		rOSLabel = new JLabel();
		JLabel nSFLabel = new JLabel("Name file");
		JLabel tBFSLabel = new JLabel("Please type before saving");
		
//Button
		tBFSButton = new JButton("Ok");
		JButton saveButton = new JButton("Save");
		nSFButton = new JButton("Save");
		rOSButton = new JButton("Ok");
		
//TextField
		nSFTextField = new TextField();
		
//EditorPane
		JEditorPane editorField = new JEditorPane();
		
//		-------------------------------------------------
		
//SetBounds
		typeBeforeSave.setBounds(252, 167, 199, 86);
		nameSavedFile.setBounds(260, 167, 184, 86);
		resultOfSave.setBounds(208, 167, 287, 86);
		rOSLabel.setBounds(109, 11, 71, 37);
		nSFLabel.setBounds(10, 11, 164, 14);
		tBFSLabel.setBounds(22, 11, 154, 32);
		tBFSButton.setBounds(33, 52, 133, 23);
		saveButton.setBounds(476, 64, 80, 23);
		nSFButton.setBounds(47, 61, 89, 23);
		rOSButton.setBounds(99, 52, 89, 23);
		nSFTextField.setBounds(10, 31, 164, 24);
		editorField.setBounds(148, 87, 408, 246);
		
//		-------------------------------------------------
		
//SetVisiable
		typeBeforeSave.setVisible(false);
		nameSavedFile.setVisible(false);
		resultOfSave.setVisible(false);
		
//		-------------------------------------------------

//SetLayout and .add
		typeBeforeSave.setLayout(null);
		nameSavedFile.setLayout(null);
		resultOfSave.setLayout(null);
		
	//.add
		nameSavedFile.add(nSFLabel);
		nameSavedFile.add(nSFButton);
		nameSavedFile.add(nSFTextField);
		resultOfSave.add(rOSLabel);
		typeBeforeSave.add(tBFSLabel);
		typeBeforeSave.add(tBFSButton);
		resultOfSave.add(rOSButton);
		
//		-------------------------------------------------

//Other Attributes
	//typeBeforeSave
		//Lines 174, 239
		
	//nameSavedFile
		//Lines 175, 186, 189, 240, 243
		
	//resultOfSave
		//Lines 205, 219
		
	//rOSLabel
		rOSLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
	//tBFSButton
		tBFSButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	//saveButton
		saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	//nSFButton
		nSFButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	//rOSButton
		rOSButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	//nSFTextField
		//Lines 185, 196, 235
		
	//editorField
		editorField.setEditable(true);
		//Lines 173, 183, 227, 238
		
//		-------------------------------------------------

//.add Frame
		frame.getContentPane().add(typeBeforeSave);
		frame.getContentPane().add(nameSavedFile);
		frame.getContentPane().add(resultOfSave);
		frame.getContentPane().add(saveButton);
		frame.getContentPane().add(editorField);

//		-------------------------------------------------

//MouseListener
	
	//tBFSButton
		tBFSButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				editorField.setEditable(true);
				typeBeforeSave.setVisible(false);
				nameSavedFile.setVisible(false);
			}//mouseClicked
		});//End

	//nSFButton
		nSFButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				String data = editorField.getText();

				fileName = nSFTextField.getText();
				nameSavedFile.setVisible(false);
				
				if (fileName.equals("")){
					nameSavedFile.setVisible(true);
					if (data.length() > 8){
						s2 = data.substring(0, 8);
					}
					else
					s2 = data + ".txt";
					
					nSFTextField.setText(s2);
				}//If file.equals

				try{
					FileWriter myWriter = new FileWriter(fileName);
					myWriter.write(data);
					myWriter.close();
					System.out.println("Successfully wrote to the file.");
					rOSLabel.setText("Saved");
					resultOfSave.setVisible(true);
				}
				catch (IOException e1){
					rOSLabel.setText("Failed to save");
					System.out.println("An error occurred.");
					e1.printStackTrace();
				}
			}//mouseClicked
		});//End
		
	//rOSButton
		rOSButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				resultOfSave.setVisible(false);
			}//mouseClicked
		});//End
		
	//saveButton
		saveButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				String data = editorField.getText();

				if (data.length() > 8){
					s2 = data.substring(0, 8) + ".txt";
				}
				else
				s2 = data + ".txt";
				nSFTextField.setText(s2);

				if (data.equals("")){
					editorField.setEditable(false);
					typeBeforeSave.setVisible(true);
					nameSavedFile.setVisible(false);
				}
				else if (fileName.equals("")){
					nameSavedFile.setVisible(true);
				}
			}//mouseClicked
		});//End

	}//initialize()
}//Class