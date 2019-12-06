package com.billion.lagolacommon.util;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Auther: fusw
 * @Date: 2019-12-05 18:35
 * @Description:
 */
public class Md5Util {

    /**
     * 方法描述:将字符串MD5加码 生成32位md5码
     * <p>
     * [@author](https://my.oschina.net/arthor) leon 2016年10月10日 下午3:02:30
     * [@param](https://my.oschina.net/u/2303379) inStr
     * [@return](https://my.oschina.net/u/556800)
     */
    public static String md5(String inStr) {
        return DigestUtils.md5Hex(inStr.getBytes(StandardCharsets.UTF_8)).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(md5("dsfdsfs3425432"));
    }

    /**
     * 方法描述:签名字符串
     * <p>
     * <p>
     * [@param](https://my.oschina.net/u/2303379) params 需要签名的参数
     * [@param](https://my.oschina.net/u/2303379) appSecret 签名密钥
     *
     * @return
     */
    public static String sign(HashMap<String, String> params, String appSecret) {
        StringBuilder valueSb = new StringBuilder();
        params.put("appSecret", appSecret);
        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<>(params);
        Set<Map.Entry<String, String>> entrys = sortParams.entrySet();
        // 遍历排序的字典,并拼接value1+value2......格式
        for (Map.Entry<String, String> entry : entrys) {
            valueSb.append(entry.getValue());
        }
        params.remove("appSecret");
        return md5(valueSb.toString());
    }

    /**
     * 方法描述:验证签名
     *
     * @param appSecret 加密秘钥
     * @param request
     * @return
     * @throws Exception
     */
//    public static boolean verify(String appSecret, Map<String, String> param) throws Exception {
//
//        String sign = request.getParameter("sign");
//        if (sign == null) {
//            throw new Exception(URLDecoder.decode("请求中没有带签名", "UTF-8"));
//        }
//        if (request.getParameter("timestamp") == null) {
//            throw new Exception(URLDecoder.decode("请求中没有带时间戳", "UTF-8"));
//        }
//        Long timestamp = Long.parseLong(request.getParameter("timestamp"));
//        Long second = (System.currentTimeMillis() - timestamp) / (1000 * 60);
//        if (second > 10) {
//            throw new Exception(URLDecoder.decode("timestamp有效期超过十分钟", "UTF-8"));
//        }
//
//
//        HashMap<String, String> params = new HashMap<String, String>();
//
//        // 获取url参数
//        @SuppressWarnings("unchecked")
//        Enumeration<String> enu = request.getParameterNames();
//        while (enu.hasMoreElements()) {
//            String paramName = enu.nextElement().trim();
//            if (!paramName.equals("sign")) {
//                // 拼接参数值字符串并进行utf-8解码，防止中文乱码产生
//                params.put(paramName, URLDecoder.decode(request.getParameter(paramName), "UTF-8"));
//            }
//        }
//
//        //params.put("appSecret", appSecret);
//
//        // 将参数以参数名的字典升序排序
//        Map<String, String> sortParams = new TreeMap<String, String>(params);
//        Set<Entry<String, String>> entrys = sortParams.entrySet();
//
//        // 遍历排序的字典,并拼接value1+value2......格式
//        StringBuilder valueSb = new StringBuilder();
//        for (Entry<String, String> entry : entrys) {
//            valueSb.append(entry.getValue());
//        }
//        String mysign = md5(md5(valueSb.toString().toUpperCase().toString() + appSecret)).toUpperCase().toString();
//        if (mysign.equals(sign)) {
//            return true;
//        } else {
//            throw new Exception(URLDecoder.decode("签名不正确", "UTF-8"));
//        }
//
//    }


}
