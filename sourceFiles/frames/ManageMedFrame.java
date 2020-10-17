package frames;


import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import entities.*;
import repositories.*;

public class ManageMedFrame extends JFrame implements ActionListener {

    JTextField searchTf = new JTextField();
	JButton searchBt = new JButton("Search");
	JButton showAllBt = new JButton("Show All");
	
	JTable medTable;
	JScrollPane medTableSP;
	
	JLabel  medIdLb =new JLabel("Med Id");
	JTextField medIdTf= new JTextField();
	
	JCheckBox load = new JCheckBox("Load");
	
	JLabel  medNameLb =new JLabel("Med Name");
	JTextField medNameTf= new JTextField();
	
	JLabel  typeLb =new JLabel("Type");
	JTextField typeTf= new JTextField();
	
	JLabel unitPriceLb = new JLabel("Unit price");
	JTextField unitPriceTf = new JTextField();
	
	JLabel quantityLb = new JLabel("Quantity");
	JTextField quantityTf = new JTextField();
	
	JCheckBox insert = new JCheckBox("New Entry");
	
	JTextField qtyTf = new JTextField();
	
	JButton addBt = new JButton("Add");
    JButton removeBt = new JButton("Remove");
	JButton refreshBt = new JButton("Refresh");
	JButton updateBt = new JButton("Update");
	
	JButton logout=new JButton("Logout");
    JButton back=new JButton("Back");
	
	Person user;
	
	MedicineRepository mr = new MedicineRepository();

    public ManageMedFrame(Person user){
		setSize(1200,700);
		setTitle("Medicine Management");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		
		this.user=user;
        
        logout.setBounds(1070,20,80,20); //Logout button size
        logout.addActionListener(this);
        add(logout); 

        back.setBounds(1075,50,70,20); //Back button size
        back.addActionListener(this);
        add(back);

        searchTf.setBounds(550,120,200,30);
		add(searchTf);
		searchBt.setBounds(760,120,80,30);
		add(searchBt);
		searchBt.addActionListener(this);
		
		showAllBt.setBounds(850,120,100,30);
		add(showAllBt);
		showAllBt.addActionListener(this);
		
		String dataM[][] = {{"", "", "", "",""}};
		String headM[] = {"medId", "medName", "medType", "unitPrice", "quantity"};
		
		medTable = new JTable(dataM,headM);
		medTable.setEnabled(false);
		medTableSP = new JScrollPane(medTable);
		medTableSP.setBounds(500,170,600,400);
		add(medTableSP);
		
		medIdLb.setBounds(100,200,60,30);
		add(medIdLb);
		medIdTf.setBounds(170,200,120,30);
		add(medIdTf);
		
		load.setBounds(310,204,60,20);
		add(load);
		load.addActionListener(this);
		
		medNameLb.setBounds(100,250,60,30);
		add(medNameLb);
		medNameTf.setBounds(170,250,120,30);
		add(medNameTf);
		
		typeLb.setBounds(100,300,60,30);
		add(typeLb);
		typeTf.setBounds(170,300,120,30);
		add(typeTf);
		
		unitPriceLb.setBounds(100,350,60,30);
		add(unitPriceLb);
		unitPriceTf.setBounds(170,350,120,30);
		add(unitPriceTf);
		
		quantityLb.setBounds(100,400,60,30);
		add(quantityLb);
		quantityTf.setBounds(170,400,120,30);
		add(quantityTf);
		quantityTf.setEnabled(false);
		
		insert.setBounds(310,405,90,20);
		add(insert);
		insert.addActionListener(this);
		
		qtyTf.setBounds(420,400,60,30);
		add(qtyTf);
		qtyTf.setEnabled(false);
		
		addBt.setBounds(100,450,100,30);
		add(addBt);
		addBt.addActionListener(this);
		
		removeBt.setBounds(210,450,100,30);
		add(removeBt);
		removeBt.addActionListener(this);
		removeBt.setEnabled(false);
		
		refreshBt.setBounds(100,500,100,30);
		add(refreshBt);
		refreshBt.addActionListener(this);
		
		updateBt.setBounds(210,500,100,30);
		add(updateBt);
		updateBt.addActionListener(this);
		updateBt.setEnabled(false);
		
		setVisible(true);
    }

    public void actionPerformed(ActionEvent a){
		if(a.getSource()==logout){
			new LoginFrame();
			this.setVisible(false);
		}
		else if(a.getSource()==back){
			new HomeFrame(user);
			this.setVisible(false);
		}
		else if(a.getSource()==searchBt){
			if(searchTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				mr = new MedicineRepository();
				
				String dataM[][] = mr.searchMedicine(searchTf.getText());
				String headM[] = {"medId", "medName", "medType", "unitPrice", "quantity"};
				remove(medTableSP);
				
				medTable = new JTable(dataM,headM);
				medTable.setEnabled(false);
				medTableSP = new JScrollPane(medTable);
				medTableSP.setBounds(500,170,600,400);
				add(medTableSP);
				
				this.revalidate();
				this.repaint();
			}
		}
		else if(a.getSource()==showAllBt){
				mr = new MedicineRepository();
				
				String dataM[][] = mr.getMedicines();
				String headM[] = {"medId", "medName", "medType", "unitPrice", "quantity"};
				remove(medTableSP);
				
				medTable = new JTable(dataM,headM);
				medTable.setEnabled(false);
				medTableSP = new JScrollPane(medTable);
				medTableSP.setBounds(500,170,600,400);
				add(medTableSP);
				
				this.revalidate();
				this.repaint();
		}
		else if(a.getSource()==load){
			if(medIdTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Medicine Id required!!","WARNING",JOptionPane.WARNING_MESSAGE);
				load.setSelected(false);
			}
			else{
				MedicineRepository mr = new MedicineRepository();
				Medicine med = mr.getMedicine(Integer.parseInt(medIdTf.getText()));
				if(med==null){
					JOptionPane.showMessageDialog(this,"No medicine is assigned to this id","warning",JOptionPane.WARNING_MESSAGE);
					load.setSelected(false);
				}
				else{
					medNameTf.setText(med.getMedName());
					typeTf.setText(med.getMedType());
					unitPriceTf.setText(med.getUnitPrice()+"");
					quantityTf.setText(med.getQuantity()+"");
					removeBt.setEnabled(true);
					updateBt.setEnabled(true);
					addBt.setEnabled(false);
				}
			}
		}
		else if(a.getSource()==insert){
			qtyTf.setEnabled(true);
		}
		else if(a.getSource()==addBt){
			if(medIdTf.getText().equals("") || medNameTf.getText().equals("") || typeTf.getText().equals("") || unitPriceTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				MedicineRepository mr = new MedicineRepository();
				Medicine med = new Medicine();
				
				med.setMedId(Integer.parseInt(medIdTf.getText()));
				med.setMedName(medNameTf.getText());
				med.setMedType(typeTf.getText());
				med.setUnitPrice(Double.parseDouble(unitPriceTf.getText()));
				med.setQuantity(Integer.parseInt(qtyTf.getText()));
				
				mr.addMedicine(med);
				
				String dataM[][] = mr.getMedicines();
				String headM[] = {"medId", "medName", "medType", "unitPrice", "quantity"};
				remove(medTableSP);
				
				medTable = new JTable(dataM,headM);
				medTable.setEnabled(false);
				medTableSP = new JScrollPane(medTable);
				medTableSP.setBounds(500,170,600,400);
				add(medTableSP);
				
				this.revalidate();
				this.repaint();
			}
		}
		else if(a.getSource()==refreshBt){
			searchTf.setText("");
			medIdTf.setText("");
			medNameTf.setText("");
			typeTf.setText("");
			unitPriceTf.setText("");
			quantityTf.setText("");
			qtyTf.setText("");
			qtyTf.setEnabled(false);
			
			load.setSelected(false);
			removeBt.setEnabled(false);
			updateBt.setEnabled(false);
			insert.setSelected(false);
			addBt.setEnabled(true);
		}
		else if(a.getSource()==removeBt){
			mr.removeMedicine(Integer.parseInt(medIdTf.getText()));
			JOptionPane.showMessageDialog(this,"Medicine Removed","Information",JOptionPane.INFORMATION_MESSAGE);
			String data[][] = mr.getMedicines();
			String head[] = {"medId", "medName", "medType", "unitPrice", "quantity"};
			
			remove(medTableSP);
			
			medTable = new JTable(data,head);
			medTable.setEnabled(false);
			medTableSP = new JScrollPane(medTable);
			medTableSP.setBounds(500,170,600,400);
			add(medTableSP);
			
			this.revalidate();
			this.repaint();
		}
		else if(a.getSource()==updateBt){
			if(medIdTf.getText().equals("") || medNameTf.getText().equals("") || typeTf.getText().equals("") || unitPriceTf.getText().equals("") || quantityTf.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Empty Text Field!!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else{
				MedicineRepository mr = new MedicineRepository();
				Medicine med = new Medicine();
				
				if(qtyTf.getText().equals("")){
					med.setMedId(Integer.parseInt(medIdTf.getText()));
					med.setMedName(medNameTf.getText());
					med.setMedType(typeTf.getText());
					med.setUnitPrice(Double.parseDouble(unitPriceTf.getText()));
					med.setQuantity(Integer.parseInt(quantityTf.getText()));
				
					mr.updateMedicine(med);
				}
				else{
					int quantity = mr.addedQuantity(Integer.parseInt(medIdTf.getText()),Integer.parseInt(qtyTf.getText()));
					med.setMedId(Integer.parseInt(medIdTf.getText()));
					med.setMedName(medNameTf.getText());
					med.setMedType(typeTf.getText());
					med.setUnitPrice(Double.parseDouble(unitPriceTf.getText()));
					med.setQuantity(quantity);
					
					mr.updateMedicine(med);
				}
				JOptionPane.showMessageDialog(this,"Medicine Updated","Information",JOptionPane.INFORMATION_MESSAGE);
				String dataM[][] = mr.getMedicines();
				String headM[] = {"medId", "medName", "medType", "unitPrice", "quantity"};
				remove(medTableSP);
				
				medTable = new JTable(dataM,headM);
				medTable.setEnabled(false);
				medTableSP = new JScrollPane(medTable);
				medTableSP.setBounds(500,170,600,400);
				add(medTableSP);
				
				this.revalidate();
				this.repaint();
			}
		}
	}
}     