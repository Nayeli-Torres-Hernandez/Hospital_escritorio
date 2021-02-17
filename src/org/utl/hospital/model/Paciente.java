package org.utl.hospital.model;

/**
 *
 * @author nayeli
 */
public class Paciente {

    private int id;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private int edad;
    private String sexo;
    private double peso;
    private int estatura;
    private boolean alergias;
    private String detalleAlergia;
    private boolean enfermedades;
    private String detalleEnfer;
    private String grupSang;

    public Paciente() {
    }

    public Paciente(int id, String nombre, String apePaterno, String apeMaterno, int edad, String sexo, double peso, int estatura, boolean alergias, String detalleAlergia, boolean enfermedades, String detalleEnfer, String grupSang) {
        this.id = id;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.estatura = estatura;
        this.alergias = alergias;
        this.detalleAlergia = detalleAlergia;
        this.enfermedades = enfermedades;
        this.detalleEnfer = detalleEnfer;
        this.grupSang = grupSang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public boolean isAlergias() {
        return alergias;
    }

    public void setAlergias(boolean alergias) {
        this.alergias = alergias;
    }

    public String getDetalleAlergia() {
        return detalleAlergia;
    }

    public void setDetalleAlergia(String detalleAlergia) {
        this.detalleAlergia = detalleAlergia;
    }

    public boolean isEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(boolean enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getDetalleEnfer() {
        return detalleEnfer;
    }

    public void setDetalleEnfer(String detalleEnfer) {
        this.detalleEnfer = detalleEnfer;
    }

    public String getGrupSang() {
        return grupSang;
    }

    public void setGrupSang(String grupSang) {
        this.grupSang = grupSang;
    }

}
