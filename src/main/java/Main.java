import io.jsonwebtoken.Claims;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        JwtUtil util = new JwtUtil();
        String ab = null;
        try {
            ab = util.createJWT(UUID.randomUUID().toString(), "{id:100,name:ali}", 6000);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("签名之后的JWT:" + ab);
        String jwt = ab;
        Claims c = null;
        try {
            c = util.parseJWT(jwt);
            //注意：如果jwt已经过期了，这里会抛出jwt过期异常。
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(c.getId());
        System.out.println(c.getIssuedAt());
        System.out.println(c.getSubject());
        System.out.println("获取私有声明中的nick_name:" + c.get("nick_name"));
        System.out.println("获取私有声明中的user_name:" + c.get("user_name"));
        System.out.println(c.get("uid", String.class));
    }
}
