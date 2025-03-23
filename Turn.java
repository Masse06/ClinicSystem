public class Turn {
    private int id;
    private String patientName;
    private String specialty;

    public Turn(int id, String patientName, String specialty) {
        this.id = id;
        this.patientName = patientName;
        this.specialty = specialty;
    }

    public Turn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Turn {" +
                "ID: " + id +
                ", nombre del paciente: " + patientName +
                ", especialidad: " + specialty +
                '}';
    }

    public String turnInfo() {
        return id + "," + patientName + "," + specialty;
    }
}
