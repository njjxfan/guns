package cn.stylefeng.guns.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @ClassName: OSSClientConstants
 * @Description: OSS阿里云常用变量
 * @author jxFan
 * @date 2018年12月24日 上午10:46:25
 *
 */
public class OSSClientConstants {
    //阿里云API的外网域名
    public static final String ENDPOINT = "http://oss-cn-shanghai.aliyuncs.com";
    //阿里云API的密钥Access Key ID
    public static final String ACCESS_KEY_ID = "LTAIn03PZ80OyYX9";
    //阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = "YbqWdMVN6QJN8AW0dTatg1sJn4dCqF";
    //阿里云API的bucket名称
    public static final String BACKET_NAME = "aishixin-oss3";
    //阿里云API的文件夹名称
    public static final String FOLDER="user/";
    public static final String FOLDER_VIDEO="video/";
    public static final String FORMAT = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public static final String FORMATS = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
}
