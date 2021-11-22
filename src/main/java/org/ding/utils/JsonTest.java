package org.ding.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.ding.entity.CVE;
import org.ding.entity.cveAll;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonTest {
    public static void main(String[] args) {
        String NewPath="E:\\images\\test.json";
        String OldPath="E:\\images\\nvdcve-1.1-2021.json";
        //CVE cve1=new CVE("cve-2019-0708",1.0,2.0);
        //object2JsonFile(NewPath,cve1);
        //cveAll cveAll=new cveAll("cve-2019-0708",1.0,2.0,3.0);
        //object2JsonFile(NewPath,cveAll);
        CVE cve2 = jsonFile2Object(NewPath, CVE.class);
        System.out.println(cve2.toString());
    }
    /**
     * Object 转换为 json 文件
     *
     * @param finalPath finalPath 是绝对路径 + 文件名，请确保欲生成的文件所在目录已创建好
     * @param object 需要被转换的 Object
     */
    public static void object2JsonFile(String finalPath, Object object) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);

        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(finalPath), StandardCharsets.UTF_8);
            osw.write(jsonObject.toJSONString());
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toJSONString());
    }

    /**
     * json 文件转换为 Object
     *
     * @param finalPath finalPath 是绝对路径 + 文件名，请确保欲生成的文件所在目录已创建好
     * @param targetClass 需要被转换的 json 对应的目标类
     * @return 解析后的 Object
     */
    public static <T> T jsonFile2Object(String finalPath, Class<T> targetClass) {
        String jsonString;
        File file = new File(finalPath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
            T object = JSON.parseObject(jsonString, targetClass);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO exception");
        }
    }


}
