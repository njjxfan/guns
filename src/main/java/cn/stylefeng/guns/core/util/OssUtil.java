package cn.stylefeng.guns.core.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;

public class OssUtil {
    // 登录阿里云申请账号，开通oss图片存储服务；
    // 登录控制台oss新建bucket(存储空间也叫容器)（注意命名规范，设置公共读写）；
    // 获取key和secret
    // 初始化一个OSSClient, OSSClient是与OSS服务交互的客户端，SDK的OSS操作都是通过OSSClient完成的。
    public static final OSSClient getOSSClient() {
        return new OSSClient("http://aishixin-oss3.oss-cn-shanghai.aliyuncs.com", "LTAIn03PZ80OyYX9", "YbqWdMVN6QJN8AW0dTatg1sJn4dCqF");
    }

    // 通过文件名判断并获取OSS服务文件上传时文件的contentType
    public static final String getContentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if ("bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if ("gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (("jpeg".equalsIgnoreCase(fileExtension)) || ("jpg".equalsIgnoreCase(fileExtension))
                || ("png".equalsIgnoreCase(fileExtension))) {
            return "image/jpeg";
        }
        if ("html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if ("txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if ("vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (("ppt".equalsIgnoreCase(fileExtension)) || ("pptx".equalsIgnoreCase(fileExtension))) {
            return "application/vnd.ms-powerpoint";
        }
        if (("doc".equalsIgnoreCase(fileExtension)) || ("docx".equalsIgnoreCase(fileExtension))) {
            return "application/msword";
        }
        if ("xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        return "text/html";
    }
    // 上传文件
    public static final String uploadInfo(InputStream is, String fileName) // 上传，并返回在文件oss上的存储路径
    {
        OSSClient client = getOSSClient();
        String resultUrl = "";
        try {
            Random random = new Random(); // 定义一个随机数
            long a = System.currentTimeMillis();
            String current = String.valueOf(a);
            String randomName = random.nextInt(9000) + 1000 + current;// 产生随机数组合
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);// 得到文件后缀
            fileName = randomName + "." + prefix;// 生成最终文件名
            ObjectMetadata metadata = new ObjectMetadata();// ObjectMetaData是用户对该object的描述
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(fileName));
            Calendar cal = Calendar.getInstance();
            int year = cal.get(1);
            int month = cal.get(2) + 1;
            String diskName = year + "/" + month + "/";
            client.putObject("aishixin-oss3", diskName + fileName, is, metadata);
            resultUrl = "http://aishixin-oss3.oss-cn-shanghai.aliyuncs.com/" + diskName + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.shutdown();
        }
        return resultUrl;
    }
}
