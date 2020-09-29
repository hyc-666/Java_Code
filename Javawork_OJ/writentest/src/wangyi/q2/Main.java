package wangyi.q2;

import java.util.*;

/**
 * @author hyc
 * @date 2020/9/27
 */
//2
//        10
//        open libc.so
//        open libm.so
//        open libdl.so
//        dup 2
//        dup2 0 2
//        close 0
//        query 1
//        query 2
//        query 3
//        open log.txt
//        10
//        open output.txt
//        dup2 0 1000000
//        close 0
//        open output2.txt
//        dup2 0 100000
//        close 0
//        open 1.txt
//        dup 100000
//        query 1
//        query 0


//0
//        1
//        2
//        3
//        libm.so
//        libc.so
//        libdl.so
//        0
//        0
//        0
//        0
//        1
//        output2.txt
//        1.txt
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            FileOpe fileOpe = new FileOpe();
            for (int j = 0; j < n; j++) {
                String ope = scanner.next();
                switch (ope){
                    case "open":
                        String file_name = scanner.next();
                        System.out.println(fileOpe.open(file_name));
                        break;
                    case "dup":
                        int fd = scanner.nextInt();
                        System.out.println(fileOpe.dup(fd));
                        break;
                    case "dup2":
                        System.out.println(fileOpe.dup2(scanner.nextInt(), scanner.nextInt()));
                        break;
                    case "close":
                        System.out.println(fileOpe.close(scanner.nextInt()));
                        break;
                    case "query":
                        System.out.println(fileOpe.query(scanner.nextInt()));
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
class FileOpe{
    List<String> fileList = new ArrayList<>();
    public int open(String file_name){
        if (!fileList.contains(file_name)){
            fileList.add(file_name);
        }
       return fileList.size() - 1;
    }
    public String dup(int fd){
        return fileList.get(fd);
    }
    public String dup2(int fd,int new_fd){
        fileList.set(new_fd,fileList.get(fd));
        return fileList.get(fd);
    }
    public String close(int fd){
        String file_name = fileList.get(fd);
        fileList.set(fd,"");
        return file_name;
    }
    public String query(int fd){
        return fileList.get(fd);
    }
}