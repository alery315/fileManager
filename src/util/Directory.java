package util;

import bean.Video;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Directory {

    public static List<Video> listDirectory(String directory) {
        File dir = new File(directory);
        List<Video> list = new ArrayList<>();
        if (dir.isFile())//判断是否是文件，如果是文件则返回。
            return list;
        File[] files = dir.listFiles(); //列出当前目录下的所有文件和目录
        if (files == null) {
            return list;
        }
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            String size = String.valueOf(files[i].length());
//            int idx = files[i].getPath().lastIndexOf("alery");
//            String path = files[i].getPath().substring(idx - 1);
            String path = files[i].getPath();
            boolean flag = false;
            if (files[i].isDirectory())//如果是目录，则继续遍历该目录
                flag = true;
            if (!fileName.startsWith(".")) {
                Video video = new Video(fileName, size, path, flag);
                list.add(video);
            }
        }
        list.sort(new CompareVideo());
        return list;
    }

    public static String upDirectory(String path) {
        int idx = path.lastIndexOf("/");
        String dir = path;
        if (idx > 1)
            dir = path.substring(0, idx);
        return dir;
    }

}

class CompareVideo implements Comparator<Video> {

    @Override
    public int compare(Video o1, Video o2) {
        if (o1.isDir() != o2.isDir()) {
            if (o1.isDir()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return o1.getFileName().compareToIgnoreCase(o2.getFileName());
        }
    }
}