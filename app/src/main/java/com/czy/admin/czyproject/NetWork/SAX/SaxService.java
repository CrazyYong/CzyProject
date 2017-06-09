package com.czy.admin.czyproject.NetWork.SAX;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by czy on 2017/3/13.
 */

public class SaxService {

    public SaxService() {

             }

    //方法：解析xml数据并返回，返回值类型是HashMap
         public static List<HashMap<String, String>> readXML(InputStream inputStream, String nodeName)
         {
                 try {
                         //实例化SAX工厂类
                         SAXParserFactory factory=SAXParserFactory.newInstance();
                         //实例化SAX解析器。
                     SAXParser sParser=factory.newSAXParser();
                         //实例化工具类MyHandler，设置需要解析的节点
                         SAXHandler myHandler=new SAXHandler(nodeName);
                         // 开始解析
                         sParser.parse(inputStream, myHandler);
                         // 解析完成之后，关闭流
                         inputStream.close();
                         //返回解析结果。
                        return myHandler.getList();  //在这里返回解析之后的数据
                     } catch (Exception e) {
                         // TODO: handle exception
                     }
                 return null;
             }

}
