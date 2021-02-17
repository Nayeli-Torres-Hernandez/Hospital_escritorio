package org.utl.hospital.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.utl.hospital.model.Paciente;

public class PrincipalController implements Initializable {

    //int id = 1;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidoPaterno;
    @FXML
    private TextField txtApellidoMaterno;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtEstatura;
    @FXML
    private TextArea txtAlergias;
    @FXML
    private TextArea txtEnfermedades;
    @FXML
    private ComboBox<String> cmbSangre;
    @FXML
    private RadioButton rbtnHombre;
    @FXML
    private RadioButton rbtnMujer;
    @FXML
    private RadioButton rbtnAlergiaNo;
    @FXML
    private RadioButton rbtnAlergiaSi;
    @FXML
    private RadioButton rbtnEnfermedadesNo;
    @FXML
    private RadioButton rbtnEnfermedadesSi;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TableView<Paciente> idTable;
    @FXML
    private TableColumn<Paciente, Integer> colId;
    @FXML
    private TableColumn<Paciente, String> colNombre;
    @FXML
    private TableColumn<Paciente, String> colApellido1;
    @FXML
    private TableColumn<Paciente, String> colApellido2;
    @FXML
    private TableColumn<Paciente, Integer> colEdad;
    @FXML
    private TableColumn<Paciente, String> colSexo;
    @FXML
    private TableColumn<Paciente, Double> colPeso;
    @FXML
    private TableColumn<Paciente, Integer> colEstatura;
    @FXML
    private TableColumn<Paciente, Boolean> colAlergias;
    @FXML
    private TableColumn<Paciente, String> colDescrA;
    @FXML
    private TableColumn<Paciente, Boolean> colEnfermedades;
    @FXML
    private TableColumn<Paciente, String> colDescrE;
    @FXML
    private TableColumn<Paciente, String> colRH;

    private ObservableList<Paciente> pacientes;

    ObservableList<String> rh = FXCollections.observableArrayList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbSangre.setItems(rh);
        pacientes = FXCollections.observableArrayList();

        this.colId.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido1.setCellValueFactory(new PropertyValueFactory("apePaterno"));
        this.colApellido2.setCellValueFactory(new PropertyValueFactory("apeMaterno"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        this.colSexo.setCellValueFactory(new PropertyValueFactory("sexo"));
        this.colPeso.setCellValueFactory(new PropertyValueFactory("peso"));
        this.colEstatura.setCellValueFactory(new PropertyValueFactory("estatura"));
        this.colAlergias.setCellValueFactory(new PropertyValueFactory("alergias"));
        this.colDescrA.setCellValueFactory(new PropertyValueFactory("detalleAlergia"));
        this.colEnfermedades.setCellValueFactory(new PropertyValueFactory("enfermedades"));
        this.colDescrE.setCellValueFactory(new PropertyValueFactory("detalleEnfer"));
        this.colRH.setCellValueFactory(new PropertyValueFactory("grupSang"));
    }

    public void guardarPaciente(ActionEvent event) {

        String sexo = "";
        boolean alergias = true;
        boolean enfermedades = true;

        if (rbtnHombre.isSelected() || rbtnMujer.isSelected()) {
            if (rbtnHombre.isSelected()) {
                sexo = "Hombre";
            }
            if (rbtnMujer.isSelected()) {
                sexo = "Mujer";
            }
        } else {
            sexo = "ninguno seleccionado";
        }
        //ALERGIAS
        if (rbtnAlergiaNo.isSelected() || rbtnAlergiaSi.isSelected()) {
            if (rbtnAlergiaNo.isSelected()) {
                alergias = false;
            }
            if (rbtnAlergiaSi.isSelected()) {
                alergias = true;
            }
        } else {
            alergias = false;
        }

        //ENFERMEDADES
        if (rbtnEnfermedadesNo.isSelected() || rbtnEnfermedadesSi.isSelected()) {
            if (rbtnEnfermedadesNo.isSelected()) {
                enfermedades = false;
            }
            if (rbtnEnfermedadesSi.isSelected()) {
                enfermedades = true;
            }
        } else {
            enfermedades = false;
        }

        try {
            int id = pacientes.size() + 1;
            String nombre = this.txtNombre.getText();
            String apePaterno = this.txtApellidoPaterno.getText();
            String apeMaterno = this.txtApellidoMaterno.getText();
            int edad = Integer.parseInt(this.txtEdad.getText());
            double peso = Double.parseDouble(this.txtPeso.getText());
            int estatura = Integer.parseInt(this.txtEstatura.getText());
            String detalleAlergia = this.txtAlergias.getText();
            String detalleEnfer = this.txtEnfermedades.getText();
            String grupSang = this.cmbSangre.getValue();

            Paciente p = new Paciente(id, nombre, apePaterno, apeMaterno, edad, sexo, peso, estatura, alergias, detalleAlergia, enfermedades, detalleEnfer, grupSang);
            //id++;
            this.pacientes.contains(p);
            this.pacientes.add(p);
            this.idTable.setItems(pacientes);
            cancelar();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error!");
            alert.setTitle("ERROR");
            alert.setContentText("No se registró el paciente");
            alert.showAndWait();
        }

    }

//botón cancelar
    public void cancelar() {
        txtNombre.setText(" ");
        txtApellidoPaterno.setText(" ");
        txtApellidoMaterno.setText(" ");
        txtEdad.setText(" ");
        rbtnHombre.setSelected(false);
        rbtnMujer.setSelected(false);
        txtPeso.setText(" ");
        txtEstatura.setText(" ");
        rbtnAlergiaNo.setSelected(false);
        rbtnAlergiaSi.setSelected(false);
        txtAlergias.setText(" ");
        rbtnEnfermedadesNo.setSelected(false);
        rbtnEnfermedadesSi.setSelected(false);
        txtEnfermedades.setText(" ");
        cmbSangre.setValue(" ");
    }
}
