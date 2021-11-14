
package logica;


public class Json {
    private String peticion;
    private String info;

    public Json(String peticion, String info) {
        this.peticion = peticion;
        this.info = info;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }

    public String getInfo() {
        info = info.replaceAll("'", "\"");
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
}
