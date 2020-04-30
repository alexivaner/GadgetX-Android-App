package id.ac.petra.gadgetx;

public class ModelList {
    String id, name, status,network,img,dim,disty,disz,cpu,os,memory,camera,battery,brand;

    public ModelList(){};

    public ModelList(String id, String name,  String status, String network,
                     String img, String dim, String disty,
                     String disz, String cpu, String os,
                     String memory, String camera,
                     String battery, String brand) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.network=network;
        this.img = img;
        this.network = img;
        this.dim = dim;
        this.disty = disty;
        this.disz = disz;
        this.cpu = cpu;
        this.os = os;
        this.memory = memory;
        this.camera = camera;
        this.battery = battery;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDim() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public String getDisty() {
        return disty;
    }

    public void setDisty(String disty) {
        this.disty = disty;
    }

    public String getDisz() {
        return disz;
    }

    public void setDisz(String disz) {
        this.disz = disz;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
