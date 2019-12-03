package com.billion.lagola.mall.gateway.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import lombok.Data;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static String value;

    /**
     * 加密 token 的 秘钥
     *
     * @param v
     */
    @Value("${token.secret}")
    public void setValue(String v) {
        value = v;
    }

    /**
     * token  载荷Payload
     */
    public enum JWTEnum {
        /**
         * jwt签发者
         */
        ISS("iss", "jwt签发者"),

        /**
         * jwt所面向的用户
         */
        SUB("sub", "jwt所面向的用户"),

        /**
         * 接收jwt的一方
         */
        AUD("aud", "接收jwt的一方"),

        /**
         * jwt的过期时间，这个过期时间必须要大于签发时间
         */
        EXP("exp", "jwt的过期时间，这个过期时间必须要大于签发时间"),

        /**
         * 定义在什么时间之前，该jwt都是不可用的
         */
        NBF("nbf", "定义在什么时间之前，该jwt都是不可用的"),

        /**
         * jwt的签发时间
         */
        IAT("iat", "jwt的签发时间"),

        /**
         * jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
         */
        JTI("jti", "jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击");

        public String name;

        public String text;

        JWTEnum(String name, String text) {
            this.name = name;
            this.text = text;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


    /**
     * 生成token
     * JWTEnum.EXP jwt过期时间 必须是long 类型的数据
     *
     * @param payloadMap
     * @return
     * @throws JOSEException
     */
    public static String creatToken(Map<String, Object> payloadMap) throws JOSEException {
        Assert.notEmpty(payloadMap, "token载荷Payload不得为空");
//        AssertUtil.notEmpty(payloadMap.get(JWTEnum.ISS.name), "jwt签发者不能为空");
//        AssertUtil.notEmpty(payloadMap.get(JWTEnum.AUD.name), "接收jwt的一方不能为空");
//        AssertUtil.notEmpty(payloadMap.get(JWTEnum.IAT.name), "jwt签发时间不能为空");
//        AssertUtil.notEmpty(payloadMap.get(JWTEnum.EXP.name), "jwt过期时间不能为空");
        //3.先建立一个头部Header
        /**
         * JWSHeader参数：1.加密算法法则,2.类型，3.。。。。。。。
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));
        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //建立一个密匙
        JWSSigner jwsSigner = new MACSigner(value.getBytes());
        //签名
        jwsObject.sign(jwsSigner);
        //生成token
        return jwsObject.serialize();
    }

    /**
     * 验证token
     *
     * @param token 待验证的token
     * @return
     * @throws ParseException
     * @throws JOSEException
     */
    public static ValidRes valid(String token) throws ParseException, JOSEException {
//        解析token
        JWSObject jwsObject = JWSObject.parse(token);
//        获取到载荷
        Payload payload = jwsObject.getPayload();
//        建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(value.getBytes());
        ValidRes validRes = new ValidRes();
//        判断token
        if (jwsObject.verify(jwsVerifier)) {
//            载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            Long expTime = Long.valueOf(jsonObject.get(JWTEnum.EXP.getName()).toString());
            Long nowTime = System.currentTimeMillis();
            boolean isExpired = false;
//            判断token是否过期
            if (nowTime > expTime) {
                isExpired = true;
            }
            if (isExpired) {
                validRes.setValid(false);
                validRes.setMsg("token is expired ");
                validRes.setData("");
            } else {
                validRes.setValid(true);
                validRes.setMsg("success");
                validRes.setData(jsonObject.toJSONString());
            }
        } else {
            validRes.setValid(false);
            validRes.setMsg("token is error");
            validRes.setData("");
        }
        return validRes;
    }

    /**
     * 接收 token 验证返回
     */
    @Data
    public static class ValidRes {
        private boolean valid;
        private String msg;
        private String data;

    }

    public static void main(String[] args) throws JOSEException, ParseException {
        Map<String, Object> map = new HashMap<>();
        map.put(JWTEnum.ISS.name, "request");
        map.put(JWTEnum.AUD.name, "response");
        map.put(JWTEnum.IAT.name, System.currentTimeMillis());
        map.put(JWTEnum.EXP.name, System.currentTimeMillis() + 1000000000L);
        String s = creatToken(map);
        ValidRes valid = valid(s);
        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(valid));

    }

}
