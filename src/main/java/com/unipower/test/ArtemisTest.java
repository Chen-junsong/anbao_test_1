package ga;
import java.util.HashMap; import java.util.Map;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

/**  * 获取登录凭证接口示例
 * *  * @author 姓名 工号
 * * @version [版本号]
 * * @see [相关类/方法]
 * * @since [产品/模块版本]  */
public class ArtemisTest {


    // STEP1：设置平台参数，根据实际情况,设置host appkey appsecret 三个参数.
    static {
        ArtemisConfig.host = "192.168.16.120:443";// iSC平台实际的ip端口
        ArtemisConfig.appKey = "28113478";// 秘钥appkey
        ArtemisConfig.appSecret = "lO78S5ssitCiSYNk8EUa";// 秘钥appSecret
         }

    // STEP2：设置OpenAPI接口的上下文
    private static final String ARTEMIS_PATH = "/artemis";


    /**  * 调用Get请求方法示例
     * *  * @return String 返回结果
     * * @see [类、类#方法、类#成员]  */


    public static String callGetApi() {
        // STEP3：设置接口的URI地址
        final String getCamsApi = ARTEMIS_PATH + "/api/cas/v1/tgt/login";
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", getCamsApi);
            }
        };

        // STEP4：组装请求参数
        Map<String, String> querys = new HashMap<String, String>(3) {
            {
                put("language", "zh_CN");
                put("service", "https://192.168.16.120/");
                put("userCode", "ydds");
            }
        };

        // STEP5：调用接口
        String result = ArtemisHttpUtil.doGetArtemis(path, querys, null, "application/json");
        return result;
    }

    public static void main(String[] args) {
        String StringeResult = callGetApi();
        System.out.println("StringeResult结果示例: " + StringeResult);
    }


}
