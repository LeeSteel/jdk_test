package example.test2023052601;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2023/5/26 18:18
 * @Copyright: Copyright (c) 2019
 */
public class SubStrTest {
    public static void main(String[] args) {
        Map<Object,Object> integration = new HashMap<>();
        integration.put("101",new HashMap(){
            {
                put("tenant_id","101");
                put("type","WX_CP");
                put("corp_id","wwa4f6f9994fa4726d");
                put("corp_secret","rpBOogcK8869xA7TpOvd1heneLY7MK_e2Vgaq59iADcw4GOc1_x2UABv0kE_wHG3");
            }
        });
        integration.put("141",new HashMap(){
            {
                put("tenant_id","101");
                put("type","WX_CP");
                put("corp_id","wwa4f6f9994fa4726d");
                put("corp_secret","rpBOogcK8869xA7TpOvd1heneLY7MK_e2Vgaq59iADcw4GOc1_x2UABv0kE_wHG3");
            }
        });
        integration.put("142",new HashMap(){
            {
                put("0",new HashMap(){
                    {
                        put("tenant_id","142");
                        put("type","WX_CP");
                        put("corp_id","wwa4f6f9994fa4726d");
                        put("corp_secret","rpBOogcK8869xA7TpOvd1heneLY7MK_e2Vgaq59iADcw4GOc1_x2UABv0kE_wHG3");
                    }
                });
                put("1",new HashMap(){
                    {
                        put("tenant_id","142");
                        put("type","WX_CP");
                        put("corp_id","wwa4f6f9994fa4726d");
                        put("corp_secret","rpBOogcK8869xA7TpOvd1heneLY7MK_e2Vgaq59iADcw4GOc1_x2UABv0kE_wHG3");
                    }
                });
            }
        });
        Map<String, HashMap> propertyMap = new HashMap<>();
        propertyMap.put("tripartite.integration[141].type",new HashMap(){{
            put("before","WX_CP");
            put("after","WX_CP_TP");
        }});
        propertyMap.put("tripartite.integration[142][0].type",new HashMap(){{
            put("before","WX_CP");
            put("after","WX_CP_TP");
        }});
        onApplicationEvent(propertyMap,integration);
    }
    public  static  void onApplicationEvent(Map<String, HashMap> propertyMap, Map<Object,Object> integration ) {

        System.out.println(propertyMap);

        for (Map.Entry<String, HashMap> entry : propertyMap.entrySet()) {
            String configKey = entry.getKey();
            if (configKey.length() <= "tripartite.integration".length()) {
                continue;
            }
            String realKeyStr = configKey.substring("tripartite.integration".length(), configKey.length());
            String regex = "\\[(.*?)\\]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(realKeyStr);

            // 租户下 配置文件信息，单结构
            Object tenantConfig = null;
            String tenantConfigKey = null;
            // 租户下多个配置文件信息，数组结构
            Object tenantConfigArr = null;
            String tenantConfigArrKey = null;
            int index = 0;
            while (matcher.find()) {
                String result = matcher.group(1);
                if (index != 0) {
                    // 租户下多个配置信息
                    tenantConfigArr = ((Map) tenantConfig).get(result);
                    tenantConfigArrKey = result;
                } else {
                    // 处理提取结果
                    System.out.println(result);
                    tenantConfig = integration.get(result);
                    tenantConfigKey = result;
                    index++;
                }
            }

            // 提供更新前后的值
            if (tenantConfig != null && tenantConfigArr != null) {
                exchangeConfigOldAndNewValue(entry, configKey, realKeyStr, (Map) tenantConfigArr);
                ((Map)integration.get(tenantConfigKey)).put(tenantConfigArrKey,tenantConfigArr);
            }
            if (tenantConfig != null && tenantConfigArr == null) {
                exchangeConfigOldAndNewValue(entry, configKey, realKeyStr, (Map) tenantConfig);
                ((Map)integration).put(tenantConfigKey,tenantConfig);
            }
        }
        System.out.println(integration);
    }

    /**
     *  交换 配置的 新旧值
     * @param entry
     * @param configKey
     * @param realKeyStr
     * @param tenantConfig
     */
    private static void exchangeConfigOldAndNewValue(Map.Entry<String, HashMap> entry, String configKey, String realKeyStr, Map tenantConfig) {
        Object oldValue = tenantConfig.get(realKeyStr.substring(realKeyStr.lastIndexOf('.') + 1));
        Object after = entry.getValue().get("after");
        tenantConfig.put(realKeyStr.substring(realKeyStr.lastIndexOf('.') + 1), after);
        System.out.println(configKey + "before:" + oldValue + ",after:" + after);
    }

}
