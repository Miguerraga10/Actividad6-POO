import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaPrincipal extends JFrame {
    private JTextField nombreTextField;
    private JTextField telefonoTextField;
    public VentanaPrincipal() {
        super("Agenda Telefónica");
        nombreTextField = new JTextField(20);
        telefonoTextField = new JTextField(20);
        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nombre:"));
        add(nombreTextField);
        add(new JLabel("Teléfono:"));
        add(telefonoTextField);
        add(createButton);
        add(readButton);
        add(updateButton);
        add(deleteButton);
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Create.create(nombreTextField.getText(), telefonoTextField.getText());
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Contacto creado exitosamente");
            }
        });
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Read.read(nombreTextField.getText());
            String targetName = nombreTextField.getText().trim();
            String foundNumber = Read.read(targetName);
            if (foundNumber != null) {
                telefonoTextField.setText(foundNumber);
            } else {
                telefonoTextField.setText("");
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Nombre no encontrado");
            }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Update.update(nombreTextField.getText(), telefonoTextField.getText());
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Contacto actualizado exitosamente");
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Delete.delete(nombreTextField.getText());
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Contacto eliminado exitosamente");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}