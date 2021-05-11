package com.test.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // 連接本地的 Redis 服務
        Jedis jedis = new Jedis("localhost");
        // 查看服務是否運行
        System.out.println("服務正在運行且連接成功: " + jedis.ping());

//        String code = returnAuthCode();
//        System.out.println("Auth code is: " + code);
//
//        // 將資料寫進Redis
//        jedis.set("Member:M0001", code);
//        // 設定該資料存在多久時間
//        jedis.expire("Member:M0001", 10000000);
//        // 將資料讀出
//        System.out.println("Member:M0001=" + jedis.get("Member:M0001"));
//        jedis.get("Member:M0001");



        //        Scanner sc = new Scanner(System.in);
        //        System.out.println("請輸入驗證碼：");
        //        String str = sc.next();
        //
        //        // 假設會員點擊驗證信
        //        String tempAuth = jedis.get("Member:M0001");
        //        if (tempAuth == null) {
        //            System.out.println("連結信已逾時，請重新申請");
        //        } else if (str.equals(tempAuth)) {
        //            System.out.println("驗證成功!");
        //        } else {
        //            System.out.println("驗證有誤，請重新申請");
        //        }
        //
        //        sc.close();
        jedis.close();
    }

    private static String returnAuthCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            int condition = (int) (Math.random() * 3) + 1;
            switch (condition) {
                case 1:
                    char c1 = (char) ((int) (Math.random() * 26) + 65);
                    sb.append(c1);
                    break;
                case 2:
                    char c2 = (char) ((int) (Math.random() * 26) + 97);
                    sb.append(c2);
                    break;
                case 3:
                    sb.append((int) (Math.random() * 10));
            }
        }
        return sb.toString();
    }

}
