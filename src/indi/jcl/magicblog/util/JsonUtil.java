package indi.jcl.magicblog.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import indi.jcl.magicblog.vo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    private static final Log log = LogFactory.getLog(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getJsonString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Unable to serialize to json: " + object, e);
            return null;
        }
    }

    public static <T> T toBean(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("Unable to deserialize from json: " + json, e);
            return null;
        }
    }


    public static void main(String[] args) {
        User user = new User();
        user.setPwd("123");
        user.setUserName("321");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 10000);
        map.put("msg", "");
        map.put("result", user);
        System.out.println(getJsonString(user));
        System.out.println(toBean(getJsonString(user),User.class));
    }
}