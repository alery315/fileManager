package bean;

import util.Size;

public class Video {

    private String fileName;
    private String size;
    private String path;
    private boolean isDir;


    public Video(String fileName, String size, String path,boolean isDir) {
        this.fileName = fileName;
        this.size = Size.formatSize(size);
        this.path = path;
        this.isDir = isDir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    @Override
    public String toString() {
        return "Video{" +
                "fileName='" + fileName + '\'' +
                ", size='" + size + '\'' +
                ", path='" + path + '\'' +
                ", isDir=" + isDir +
                '}';
    }
}
